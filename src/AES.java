import java.util.Arrays;
import java.util.HashMap;

public class AES {
    static HashMap<String, String> byteSubHashmap = new HashMap<>();
    //static HashMap<String, String> reverseByteSubHashmap = new HashMap<>();

    public static String encrypt(String plaintext, String key) {

        return plaintext;
    }

    public static String decrypt(String ciphertext, String key) {
        return ciphertext;
    }

    public static byte[][] subBytes(byte[][] byteArray) {
        initializeByteSubHashmap();

        for (int i=0;i<byteArray.length;i++) {
            for (int j=0;j<byteArray[i].length;i++) {
                //byte temp = byteArray[i][j];
                String byteInHex = Converter.binaryToHexImproved(byteArray[i][j]);
                String subbedByteInHex = byteSubHashmap.get(byteInHex);
                byteArray[i][j] = Converter.hexToBinary(subbedByteInHex);
            }
        }
//        String byteInHex = Converter.binaryToHexImproved(byteArray[0][0]);
//        String subbedByteInHex = byteSubHashmap.get(byteInHex);
//        byteArray[0][0] = Converter.hexToBinary(subbedByteInHex);

        return byteArray;
    }

    public static byte[][] shiftRow(byte[][] byteArray) {
        //shifting second row left by one
        shiftRowHelper(byteArray, 1, 1);

        //shifting third row left by two
        shiftRowHelper(byteArray, 2, 2);

        //shifting fourth row left by three
        shiftRowHelper(byteArray,3,3);

        return byteArray;
    }

    public static byte[][] shiftRowHelper(byte[][] byteArray, int row, int shiftBy) {
        for (int i=0;i<shiftBy;i++) {
            byte temp = byteArray[row][0];
            for (int j=0;j<byteArray.length-1;j++) {
                byteArray[row][j] = byteArray[row][j+1];
            }
            byteArray[row][3] = temp;
        }

        return byteArray;
    }

    public static void initializeByteSubHashmap() {
        byteSubHashmap.put("00", "63");
        byteSubHashmap.put("01", "7c");
        byteSubHashmap.put("02", "77");
        byteSubHashmap.put("03", "7b");
        byteSubHashmap.put("04", "f2");
        byteSubHashmap.put("05", "6b");
        byteSubHashmap.put("06", "6f");
        byteSubHashmap.put("07", "c5");
        byteSubHashmap.put("08", "30");
        byteSubHashmap.put("09", "01");
        byteSubHashmap.put("0a", "67");
        byteSubHashmap.put("0b", "2b");
        byteSubHashmap.put("0c", "fe");
        byteSubHashmap.put("0d", "d7");
        byteSubHashmap.put("0e", "ab");
        byteSubHashmap.put("0f", "76");

        byteSubHashmap.put("10", "ca");
        byteSubHashmap.put("11", "82");
        byteSubHashmap.put("12", "c9");
        byteSubHashmap.put("13", "7d");
        byteSubHashmap.put("14", "fa");
        byteSubHashmap.put("15", "59");
        byteSubHashmap.put("16", "47");
        byteSubHashmap.put("17", "f0");
        byteSubHashmap.put("18", "ad");
        byteSubHashmap.put("19", "d4");
        byteSubHashmap.put("1a", "a2");
        byteSubHashmap.put("1b", "af");
        byteSubHashmap.put("1c", "9c");
        byteSubHashmap.put("1d", "a4");
        byteSubHashmap.put("1e", "72");
        byteSubHashmap.put("1f", "c0");

        byteSubHashmap.put("20", "b7");
        byteSubHashmap.put("21", "fd");
        byteSubHashmap.put("22", "93");
        byteSubHashmap.put("23", "26");
        byteSubHashmap.put("24", "36");
        byteSubHashmap.put("25", "3f");
        byteSubHashmap.put("26", "f7");
        byteSubHashmap.put("27", "cc");
        byteSubHashmap.put("28", "34");
        byteSubHashmap.put("29", "a5");
        byteSubHashmap.put("2a", "e5");
        byteSubHashmap.put("2b", "f1");
        byteSubHashmap.put("2c", "71");
        byteSubHashmap.put("2d", "d8");
        byteSubHashmap.put("2e", "31");
        byteSubHashmap.put("2f", "15");

        byteSubHashmap.put("30", "04");
        byteSubHashmap.put("31", "c7");
        byteSubHashmap.put("32", "23");
        byteSubHashmap.put("33", "c3");
        byteSubHashmap.put("34", "18");
        byteSubHashmap.put("35", "96");
        byteSubHashmap.put("36", "05");
        byteSubHashmap.put("37", "9a");
        byteSubHashmap.put("38", "07");
        byteSubHashmap.put("39", "12");
        byteSubHashmap.put("3a", "80");
        byteSubHashmap.put("3b", "e2");
        byteSubHashmap.put("3c", "eb");
        byteSubHashmap.put("3d", "27");
        byteSubHashmap.put("3e", "b2");
        byteSubHashmap.put("3f", "75");

        byteSubHashmap.put("40", "09");
        byteSubHashmap.put("41", "83");
        byteSubHashmap.put("42", "2c");
        byteSubHashmap.put("43", "1a");
        byteSubHashmap.put("44", "1b");
        byteSubHashmap.put("45", "6e");
        byteSubHashmap.put("46", "5a");
        byteSubHashmap.put("47", "a0");
        byteSubHashmap.put("48", "52");
        byteSubHashmap.put("49", "3b");
        byteSubHashmap.put("4a", "d6");
        byteSubHashmap.put("4b", "b3");
        byteSubHashmap.put("4c", "29");
        byteSubHashmap.put("4d", "e3");
        byteSubHashmap.put("4e", "2f");
        byteSubHashmap.put("4f", "84");

        byteSubHashmap.put("50", "53");
        byteSubHashmap.put("51", "d1");
        byteSubHashmap.put("52", "00");
        byteSubHashmap.put("53", "ed");
        byteSubHashmap.put("54", "20");
        byteSubHashmap.put("55", "fc");
        byteSubHashmap.put("56", "b1");
        byteSubHashmap.put("57", "5b");
        byteSubHashmap.put("58", "6a");
        byteSubHashmap.put("59", "cb");
        byteSubHashmap.put("5a", "be");
        byteSubHashmap.put("5b", "39");
        byteSubHashmap.put("5c", "4a");
        byteSubHashmap.put("5d", "4c");
        byteSubHashmap.put("5e", "58");
        byteSubHashmap.put("5f", "cf");

        byteSubHashmap.put("60", "d0");
        byteSubHashmap.put("61", "ef");
        byteSubHashmap.put("62", "aa");
        byteSubHashmap.put("63", "fb");
        byteSubHashmap.put("64", "43");
        byteSubHashmap.put("65", "4d");
        byteSubHashmap.put("66", "33");
        byteSubHashmap.put("67", "85");
        byteSubHashmap.put("68", "45");
        byteSubHashmap.put("69", "f9");
        byteSubHashmap.put("6a", "02");
        byteSubHashmap.put("6b", "7f");
        byteSubHashmap.put("6c", "50");
        byteSubHashmap.put("6d", "3c");
        byteSubHashmap.put("6e", "9f");
        byteSubHashmap.put("6f", "a8");

        byteSubHashmap.put("70", "51");
        byteSubHashmap.put("71", "a3");
        byteSubHashmap.put("72", "40");
        byteSubHashmap.put("73", "8f");
        byteSubHashmap.put("74", "92");
        byteSubHashmap.put("75", "9d");
        byteSubHashmap.put("76", "38");
        byteSubHashmap.put("77", "f5");
        byteSubHashmap.put("78", "bc");
        byteSubHashmap.put("79", "b6");
        byteSubHashmap.put("7a", "da");
        byteSubHashmap.put("7b", "21");
        byteSubHashmap.put("7c", "10");
        byteSubHashmap.put("7d", "ff");
        byteSubHashmap.put("7e", "f3");
        byteSubHashmap.put("7f", "d2");

        byteSubHashmap.put("80", "cd");
        byteSubHashmap.put("81", "0c");
        byteSubHashmap.put("82", "13");
        byteSubHashmap.put("83", "ec");
        byteSubHashmap.put("84", "5f");
        byteSubHashmap.put("85", "97");
        byteSubHashmap.put("86", "44");
        byteSubHashmap.put("87", "17");
        byteSubHashmap.put("88", "c4");
        byteSubHashmap.put("89", "a7");
        byteSubHashmap.put("8a", "7e");
        byteSubHashmap.put("8b", "3d");
        byteSubHashmap.put("8c", "64");
        byteSubHashmap.put("8d", "5d");
        byteSubHashmap.put("8e", "19");
        byteSubHashmap.put("8f", "73");

        byteSubHashmap.put("90", "60");
        byteSubHashmap.put("91", "81");
        byteSubHashmap.put("92", "4f");
        byteSubHashmap.put("93", "dc");
        byteSubHashmap.put("94", "22");
        byteSubHashmap.put("95", "2a");
        byteSubHashmap.put("96", "90");
        byteSubHashmap.put("97", "88");
        byteSubHashmap.put("98", "46");
        byteSubHashmap.put("99", "ee");
        byteSubHashmap.put("9a", "b8");
        byteSubHashmap.put("9b", "14");
        byteSubHashmap.put("9c", "de");
        byteSubHashmap.put("9d", "5e");
        byteSubHashmap.put("9e", "0b");
        byteSubHashmap.put("9f", "db");

        byteSubHashmap.put("a0", "e0");
        byteSubHashmap.put("a1", "32");
        byteSubHashmap.put("a2", "3a");
        byteSubHashmap.put("a3", "0a");
        byteSubHashmap.put("a4", "49");
        byteSubHashmap.put("a5", "06");
        byteSubHashmap.put("a6", "24");
        byteSubHashmap.put("a7", "5c");
        byteSubHashmap.put("a8", "c2");
        byteSubHashmap.put("a9", "d3");
        byteSubHashmap.put("aa", "ac");
        byteSubHashmap.put("ab", "62");
        byteSubHashmap.put("ac", "91");
        byteSubHashmap.put("ad", "95");
        byteSubHashmap.put("ae", "e4");
        byteSubHashmap.put("af", "79");

        byteSubHashmap.put("b0", "e7");
        byteSubHashmap.put("b1", "c8");
        byteSubHashmap.put("b2", "37");
        byteSubHashmap.put("b3", "6d");
        byteSubHashmap.put("b4", "8d");
        byteSubHashmap.put("b5", "d5");
        byteSubHashmap.put("b6", "4e");
        byteSubHashmap.put("b7", "a9");
        byteSubHashmap.put("b8", "6c");
        byteSubHashmap.put("b9", "56");
        byteSubHashmap.put("ba", "f4");
        byteSubHashmap.put("bb", "ea");
        byteSubHashmap.put("bc", "65");
        byteSubHashmap.put("bd", "7a");
        byteSubHashmap.put("be", "ae");
        byteSubHashmap.put("bf", "08");

        byteSubHashmap.put("c0", "ba");
        byteSubHashmap.put("c1", "78");
        byteSubHashmap.put("c2", "25");
        byteSubHashmap.put("c3", "2e");
        byteSubHashmap.put("c4", "1c");
        byteSubHashmap.put("c5", "a6");
        byteSubHashmap.put("c6", "b4");
        byteSubHashmap.put("c7", "c6");
        byteSubHashmap.put("c8", "e8");
        byteSubHashmap.put("c9", "dd");
        byteSubHashmap.put("ca", "74");
        byteSubHashmap.put("cb", "1f");
        byteSubHashmap.put("cc", "4b");
        byteSubHashmap.put("cd", "bd");
        byteSubHashmap.put("ce", "8b");
        byteSubHashmap.put("cf", "8a");

        byteSubHashmap.put("d0", "70");
        byteSubHashmap.put("d1", "3e");
        byteSubHashmap.put("d2", "b5");
        byteSubHashmap.put("d3", "66");
        byteSubHashmap.put("d4", "48");
        byteSubHashmap.put("d5", "03");
        byteSubHashmap.put("d6", "f6");
        byteSubHashmap.put("d7", "0e");
        byteSubHashmap.put("d8", "61");
        byteSubHashmap.put("d9", "35");
        byteSubHashmap.put("da", "57");
        byteSubHashmap.put("db", "b9");
        byteSubHashmap.put("dc", "86");
        byteSubHashmap.put("dd", "c1");
        byteSubHashmap.put("de", "1d");
        byteSubHashmap.put("df", "9e");

        byteSubHashmap.put("e0", "e1");
        byteSubHashmap.put("e1", "f8");
        byteSubHashmap.put("e2", "98");
        byteSubHashmap.put("e3", "11");
        byteSubHashmap.put("e4", "69");
        byteSubHashmap.put("e5", "d9");
        byteSubHashmap.put("e6", "8e");
        byteSubHashmap.put("e7", "94");
        byteSubHashmap.put("e8", "9b");
        byteSubHashmap.put("e9", "1e");
        byteSubHashmap.put("ea", "87");
        byteSubHashmap.put("eb", "e9");
        byteSubHashmap.put("ec", "ce");
        byteSubHashmap.put("ed", "55");
        byteSubHashmap.put("ee", "28");
        byteSubHashmap.put("ef", "df");

        byteSubHashmap.put("f0", "8c");
        byteSubHashmap.put("f1", "a1");
        byteSubHashmap.put("f2", "89");
        byteSubHashmap.put("f3", "0d");
        byteSubHashmap.put("f4", "bf");
        byteSubHashmap.put("f5", "e6");
        byteSubHashmap.put("f6", "42");
        byteSubHashmap.put("f7", "68");
        byteSubHashmap.put("f8", "41");
        byteSubHashmap.put("f9", "99");
        byteSubHashmap.put("fa", "2d");
        byteSubHashmap.put("fb", "0f");
        byteSubHashmap.put("fc", "b0");
        byteSubHashmap.put("fd", "54");
        byteSubHashmap.put("fe", "bb");
        byteSubHashmap.put("ff", "16");
    }

//    public static void initializeInverseByteSubHashmap() {
//        reverseByteSubHashmap.put("63","00");
//        reverseByteSubHashmap.put("63","00");
//    }

    public static void mixColumn() {

    }

    public static byte gMul(byte x, byte y) {
        byte p=0;

        for (int i=0;i<8;i++) {
            if ((y & 1) != 0) {
                p ^= x;
            }

            Boolean hiBitSet = (x & 0x80) != 0;
            x <<= 1;
            if (hiBitSet) {
                x ^= 0x1B; /* x^8 + x^4 + x^3 + x + 1 */
            }
            y >>= 1;
        }

        return p;
    }

    public static byte[][] addRoundKey(byte[][] byteArray, byte[][] key) {
        for (int i=0;i< byteArray.length;i++) {
            for (int j=0;j< byteArray[i].length;j++) {
                byteArray[i][j] = (byte) (byteArray[i][j] ^ key[i][j]);
            }
        }

        return byteArray;
    }

    public static void main(String[] args) {
        //addRoundKey testing
        byte byte1 = 82;
        byte byte2 = 103;

        byte byte3 = (byte) (byte1 ^ byte2);
        System.out.println(byte3);


        //bytesub testing
//        byte[][] byteArray = {{102,103,104},{105,106,107}};
//
//        for (int i=0;i< byteArray.length;i++) {
//            for (int j=0;j< byteArray[i].length;j++) {
//                System.out.print(byteArray[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        byte[][] alteredByteArray = subBytes(byteArray);
//
//        for (int i=0;i< alteredByteArray.length;i++) {
//            for (int j=0;j< alteredByteArray[i].length;j++) {
//                System.out.print(alteredByteArray[i][j] + " ");
//            }
//            System.out.println();
//        }







//        String str = "z";
//        byte[] tester = str.getBytes();
//        System.out.println(tester[0]);
//        int x = Converter.binaryToDecimal(tester);

//        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//
//        for (int i=0;i<arr.length;i++) {
//            for (int j=0;j<arr[i].length;j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        arr = shiftRowHelper(arr, 3, 2);
//        System.out.println("\n");
//        for (int i=0;i<arr.length;i++) {
//            for (int j=0;j<arr[i].length;j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
