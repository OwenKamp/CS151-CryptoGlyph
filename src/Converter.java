import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.stream.Stream;

public class Converter {

    public static int getBit(byte b, int position) {
        return (b >> position) & 1;
    }

    public static long[] csvToLongArray(String csv) {
        return Stream.of(csv.split(",")).mapToLong(Long::parseLong).toArray();
    }

    public static Integer stringToInt(String str) {
        String strBinary = Converter.stringToBinaryString(str);
        return Integer.parseInt(strBinary, 2);
    }

    public static String intToString(int i) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(i));

        while (sb.toString().length() % 8 != 0) {
            sb.insert(0, "0");
        }
        return Converter.binaryStringToString(sb.toString());
    }

    public static String convertStringToBinary(String input) {

        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result.append(Converter.charToBinaryStr(aChar));
        }
        return result.toString();

    }

    public static String longArrayToCsv(long[] longArray) {
        StringBuilder sb = new StringBuilder();
        for (long i : longArray) {
            sb.append(i);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    public static float generateMultiplier(java.util.Random r) {
        return r.nextInt(3) + 1 + (r.nextFloat()*0.5f) + 0.01f;
    }

    public static int[] charToBinaryArray(char c) {
        int[] binaryArray = new int[8];
        String charBinaryStr = charToBinaryStr(c);
        for (int i = 0; i < 8; i++) {
            binaryArray[i] = Integer.parseInt(Character.toString(charBinaryStr.charAt(i)));
        }
        return binaryArray;
    }

    public static String stringToBinaryString(String str) {
        StringBuilder binaryString = new StringBuilder();
        char[] chars = str.toCharArray();

        for (char character : chars) {
            StringBuilder letterBuilder = new StringBuilder(Integer.toBinaryString(character));
            while (letterBuilder.length() < 8) {
                letterBuilder.insert(0, "0");
            }

            binaryString.append(letterBuilder);
        }
        return binaryString.toString();
    }

    public static String charToBinaryStr(char c) {
        return String.format("%8s", Integer.toBinaryString(c)).replaceAll(" ", "0");
    }

    public static String binaryStringToString(String str) {
        String regularString = "";
        for (int i = 0; i < str.length()/8; i++) {
            int a = Integer.parseInt(str.substring(8*i,(i+1)*8),2);
            regularString += (char)(a);
        }

        return regularString;
    }

    public static byte[] stringToBinary(String str) {
        byte[] bytes = str.getBytes();
        return bytes;
    }

    public static String binaryToString(byte[] bytes) {
        String str = new String(bytes);
        return str;
    }

    public static int binaryToDecimal(byte[] bytes) {
        String str = binaryToString(bytes);
        int decimal = Integer.parseInt(str, 2);
        return decimal;
    }

    public static byte[] decimalToBinary(int decimal) {
        String binaryString = Integer.toBinaryString(decimal);
        byte[] bytes = binaryString.getBytes();
        return bytes;
    }

    public static byte[] hexToBinary(String hexString) {
        HashMap<Character, String> hexHashMap = new HashMap<Character, String>();

        // storing the key value pairs
        hexHashMap.put('0', "0000");
        hexHashMap.put('1', "0001");
        hexHashMap.put('2', "0010");
        hexHashMap.put('3', "0011");
        hexHashMap.put('4', "0100");
        hexHashMap.put('5', "0101");
        hexHashMap.put('6', "0110");
        hexHashMap.put('7', "0111");
        hexHashMap.put('8', "1000");
        hexHashMap.put('9', "1001");
        hexHashMap.put('A', "1010");
        hexHashMap.put('B', "1011");
        hexHashMap.put('C', "1100");
        hexHashMap.put('D', "1101");
        hexHashMap.put('E', "1110");
        hexHashMap.put('F', "1111");

        hexString = hexString.toUpperCase();
        StringBuilder sb = new StringBuilder();
        byte[] bytes;

        for (int i=0;i<hexString.length();i++) {
            char ch = hexString.charAt(0);
            if (hexHashMap.containsKey(ch)) {
                sb.append(hexHashMap.get(ch));
            } else {
                throw new IllegalArgumentException("Invalid Hexadecimal String");
            }
        }
        String str = sb.toString();


        short a = Short.parseShort(str, 2);
        ByteBuffer byteBuffer = ByteBuffer.allocate(2).putShort(a);
        bytes = byteBuffer.array();
        return bytes;
    }

    public static String binaryToHex(byte[] bytes) {
        String hex = "";

        // Iterating through each byte in the array
        for (byte i : bytes) {
            hex += String.format("%02X", i);
        }

        return hex;
        //        char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
//
//        char[] hexChars = new char[bytes.length * 2];
//        for (int j = 0; j < bytes.length; j++) {
//            int v = bytes[j] & 0xFF;
//            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
//            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
//        }
//        return new String(hexChars);
    }

    public static void main(String[] args) {
        byte[] tester = stringToBinary("Testing");
        for (int i=0;i< tester.length;i++) {
            System.out.print(tester[i]);
        }
        String str = new String(tester);
        System.out.println("\n" + str);

        //testing binary to decimal and vice versa
        byte[] binaryTest = decimalToBinary(300);
        System.out.println("\n\nBinary Test:");
        for (int i=0;i< binaryTest.length;i++) {
            System.out.print(binaryTest[i]);
        }
        int decimal = binaryToDecimal(binaryTest);
        System.out.println("\nDecimal Test: " + decimal);

        //testing binary to hex and vice versa
        String hexString = "12";
        byte[] hexBytes = hexToBinary(hexString);
        System.out.print("\n\nHexToBinary: ");
        for (int i=0;i< hexBytes.length;i++) {
            System.out.print(hexBytes[i]);
        }
        String hexString2 = binaryToHex(hexBytes);
        System.out.println("\nHex String: " + hexString2);


        System.out.println("\n\nbinaryString to String and back testing");
        String testingbsts = "hello my";
        String testingbstsInBinaryString = stringToBinaryString(testingbsts);
        System.out.println("BinaryString: " + testingbstsInBinaryString);
        String reversed = binaryStringToString(testingbstsInBinaryString);
        System.out.println("Reversed: " + reversed);
    }
}
