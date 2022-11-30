import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class Converter {
    // method to convert a string to its binary representation
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

    // method to convert a string of binary digits to a string of regular characters
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

    public static byte hexToBinary(String hexString) {
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
        byte theByte;

        for (int i=0;i<hexString.length();i++) {
            char ch = hexString.charAt(0);
            if (hexHashMap.containsKey(ch)) {
                sb.append(hexHashMap.get(ch));
            } else {
                throw new IllegalArgumentException("Invalid Hexadecimal String");
            }
        }
        String str = sb.toString();

        theByte = new BigInteger(str, 2).byteValue();

        return theByte;
    }

    public static String byteToBits(byte theByte) {
        int total = theByte;
        StringBuilder bitBuilder = new StringBuilder(Integer.toBinaryString(total));
        while (bitBuilder.toString().length() < 8) {
            bitBuilder.insert(0, "0");
        }
        return bitBuilder.toString();
    }
    public static String binaryToHexImproved(byte theByte) {
        HashMap<String, String> hexHash = new HashMap<>();

        hexHash.put("0000", "0");
        hexHash.put("0001", "1");
        hexHash.put("0010", "2");
        hexHash.put("0011", "3");
        hexHash.put("0100", "4");
        hexHash.put("0101", "5");
        hexHash.put("0110", "6");
        hexHash.put("0111", "7");
        hexHash.put("1000", "8");
        hexHash.put("1001", "9");
        hexHash.put("1010", "a");
        hexHash.put("1011", "b");
        hexHash.put("1100", "c");
        hexHash.put("1101", "d");
        hexHash.put("1110", "e");
        hexHash.put("1111", "f");

        String binaryString = byteToBits(theByte);
        char[] binaryCharacterArray = binaryString.toCharArray();

        StringBuilder bitBuilder = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i=0;i<4;i++) {
            bitBuilder.append(binaryCharacterArray[i]);
        }
        result.append(hexHash.get(bitBuilder.toString()));
        bitBuilder = new StringBuilder();
        for (int i=4;i<8;i++) {
            bitBuilder.append(binaryCharacterArray[i]);
        }
        result.append(hexHash.get(bitBuilder.toString()));

        return result.toString();
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
        byte[] bytes = decimalToBinary(2);
        for (int i=0;i<bytes.length;i++) {
            System.out.println(bytes[i]);
        }
//        byte theByte = 102;
//        System.out.println(theByte);
////        String str = byteToBits(theByte);
////        System.out.println(str);
//        String strRevised = binaryToHexImproved(theByte);
//        System.out.println(strRevised);
//        byte theByteAfterConversion = hexToBinary(strRevised);
//        System.out.println(theByteAfterConversion);
//        byte[] tester = stringToBinary("Testing");
//        for (int i=0;i< tester.length;i++) {
//            System.out.print(tester[i]);
//        }
//        String str = new String(tester);
//        System.out.println("\n" + str);
//
//        //testing binary to decimal and vice versa
//        byte[] binaryTest = decimalToBinary(300);
//        System.out.println("\n\nBinary Test:");
//        for (int i=0;i< binaryTest.length;i++) {
//            System.out.print(binaryTest[i]);
//        }
//        int decimal = binaryToDecimal(binaryTest);
//        System.out.println("\nDecimal Test: " + decimal);
//
//        //testing binary to hex and vice versa
//        String hexString = "12";
//        byte[] hexBytes = hexToBinary(hexString);
//        System.out.print("\n\nHexToBinary: ");
//        for (int i=0;i< hexBytes.length;i++) {
//            System.out.print(hexBytes[i]);
//        }
//        String hexString2 = binaryToHex(hexBytes);
//        System.out.println("\nHex String: " + hexString2);
//
//
//        System.out.println("\n\nbinaryString to String and back testing");
//        String testingbsts = "hello my";
//        String testingbstsInBinaryString = stringToBinaryString(testingbsts);
//        System.out.println("BinaryString: " + testingbstsInBinaryString);
//        String reversed = binaryStringToString(testingbstsInBinaryString);
//        System.out.println("Reversed: " + reversed);
    }
}
