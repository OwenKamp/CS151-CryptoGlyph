import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AES {
    static HashMap<String, String> byteSubHashmap = new HashMap<>();
    static HashMap<String, String> etable = new HashMap<>();

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

    public static byte multiply(byte a, byte b) {
        byte returnValue = 0;
        byte temp = 0;
        while (a != 0) {
            if ((a & 1) != 0)
                returnValue = (byte) (returnValue ^ b);
            temp = (byte) (b & 0x80);
            b = (byte) (b << 1);
            if (temp != 0)
                b = (byte) (b ^ 0x1b);
            a = (byte) ((a & 0xff) >> 1);
        }
        return returnValue;
    }

    public static byte[][] mixColumns(byte[][] input, boolean decrypt) {
        byte[][] matrix = { { 0x03, 0x0b }, { 0x01, 0x0d }, { 0x01, 0x09 }, { 0x02, 0x0e } };
        int[] temp = new int[4];

        int arrayIndex = decrypt ? 1 : 0;

        byte a = matrix[0][arrayIndex];
        byte b = matrix[1][arrayIndex];
        byte c = matrix[2][arrayIndex];
        byte d = matrix[3][arrayIndex];

        for (int i = 0; i < 4; i++) {
            temp[0] = multiply(d, input[0][i]) ^ multiply(a, input[1][i])
                    ^ multiply(b, input[2][i]) ^ multiply(c, input[3][i]);
            temp[1] = multiply(c, input[0][i]) ^ multiply(d, input[1][i])
                    ^ multiply(a, input[2][i]) ^ multiply(b, input[3][i]);
            temp[2] = multiply(b, input[0][i]) ^ multiply(c, input[1][i])
                    ^ multiply(d, input[2][i]) ^ multiply(a, input[3][i]);
            temp[3] = multiply(a, input[0][i]) ^ multiply(b, input[1][i])
                    ^ multiply(c, input[2][i]) ^ multiply(d, input[3][i]);
            for (int j = 0; j < 4; j++)
                input[j][i] = (byte) (temp[j]);
        }
        return input;
    }

    public static byte[][] mixColumn(byte[][] byteArray) {
        initializeGaloisMultiplicationTable();

        for (int i=0;i< byteArray.length;i++) {
            // getting subbed bytes in hex
            String byteInHex = Converter.binaryToHexImproved(byteArray[0][i]);
            String subbedHexByte = getKeyByValue(etable, byteInHex);
            int byteInDecimal = Integer.parseInt(subbedHexByte, 16);

            int sum = byteInDecimal + 2;

            if (sum > Integer.parseInt("FF", 16)) {
                sum -= Integer.parseInt("FF", 16);
            }

            byte[] sumInBinary = Converter.decimalToBinary(sum);
            StringBuilder sb = new StringBuilder();
            for (int j=0;i<sumInBinary.length;i++) {
                sb.append(Converter.binaryToHexImproved(sumInBinary[j]));
            }

            byteArray[0][i] = (byte) ( (byteArray[0][i] * 2) ^ (byteArray[1][i] * 3) ^ (byteArray[2][i]) ^ (byteArray[3][i]));
            byteArray[1][i] = (byte) (byteArray[0][i] ^ (byteArray[1][i] * 2) ^ (byteArray[2][i] * 3) ^ byteArray[3][i]);
            byteArray[2][i] = (byte) (byteArray[0][i] ^ byteArray[1][i] ^ (byteArray[2][i] * 2) ^ (byteArray[3][i] * 3));
            byteArray[3][i] = (byte) ((byteArray[0][i] * 3) ^ byteArray[1][i] ^ byteArray[2][i] ^ (byteArray[3][i] * 2));
        }

        return byteArray;
    }

    public static <T, E> T getKeyByValue(HashMap<T, E> hashMap, E value) {
        for (Map.Entry<T, E> entry : hashMap.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void initializeGaloisMultiplicationTable() {
        //HashMap<String, String> etable = new HashMap<>();
        etable.put("00","01");
        etable.put("01","03");
        etable.put("02","05");
        etable.put("03","0F");
        etable.put("04","11");
        etable.put("05","33");
        etable.put("06","55");
        etable.put("07","FF");
        etable.put("08","1A");
        etable.put("09","2E");
        etable.put("0A","72");
        etable.put("0B","96");
        etable.put("0C","A1");
        etable.put("0D","F8");
        etable.put("0E","13");
        etable.put("0F","35");

        etable.put("10","5F");
        etable.put("11","E1");
        etable.put("12","38");
        etable.put("13","48");
        etable.put("14","D8");
        etable.put("15","73");
        etable.put("16","95");
        etable.put("17","A4");
        etable.put("18","F7");
        etable.put("19","02");
        etable.put("1A","06");
        etable.put("1B","0A");
        etable.put("1C","1E");
        etable.put("1D","22");
        etable.put("1E","66");
        etable.put("1F","AA");

        etable.put("20","E5");
        etable.put("21","34");
        etable.put("22","5C");
        etable.put("23","E4");
        etable.put("24","37");
        etable.put("25","59");
        etable.put("26","EB");
        etable.put("27","26");
        etable.put("28","6A");
        etable.put("29","BE");
        etable.put("2A","D9");
        etable.put("2B","70");
        etable.put("2C","90");
        etable.put("2D","AB");
        etable.put("2E","E6");
        etable.put("2F","31");

        etable.put("30","53");
        etable.put("31","F5");
        etable.put("32","04");
        etable.put("33","0C");
        etable.put("34","14");
        etable.put("35","3C");
        etable.put("36","44");
        etable.put("37","CC");
        etable.put("38","4F");
        etable.put("39","D1");
        etable.put("3A","68");
        etable.put("3B","B8");
        etable.put("3C","D3");
        etable.put("3D","6E");
        etable.put("3E","B2");
        etable.put("3F","CD");

        etable.put("40","4C");
        etable.put("41","D4");
        etable.put("42","67");
        etable.put("43","A9");
        etable.put("44","E0");
        etable.put("45","3B");
        etable.put("46","4D");
        etable.put("47","D7");
        etable.put("48","62");
        etable.put("49","A6");
        etable.put("4A","F1");
        etable.put("4B","08");
        etable.put("4C","18");
        etable.put("4D","28");
        etable.put("4E","78");
        etable.put("4F","88");

        etable.put("50","83");
        etable.put("51","9E");
        etable.put("52","B9");
        etable.put("53","D0");
        etable.put("54","6B");
        etable.put("55","BD");
        etable.put("56","DC");
        etable.put("57","7F");
        etable.put("58","81");
        etable.put("59","98");
        etable.put("5A","B3");
        etable.put("5B","CE");
        etable.put("5C","49");
        etable.put("5D","DB");
        etable.put("5E","76");
        etable.put("5F","9A");

        etable.put("60","B5");
        etable.put("61","C4");
        etable.put("62","57");
        etable.put("63","F9");
        etable.put("64","10");
        etable.put("65","30");
        etable.put("66","50");
        etable.put("67","F0");
        etable.put("68","0B");
        etable.put("69","1D");
        etable.put("6A","27");
        etable.put("6B","69");
        etable.put("6C","BB");
        etable.put("6D","D6");
        etable.put("6E","61");
        etable.put("6F","A3");

        etable.put("70","FE");
        etable.put("71","19");
        etable.put("72","2B");
        etable.put("73","7D");
        etable.put("74","87");
        etable.put("75","92");
        etable.put("76","AD");
        etable.put("77","EC");
        etable.put("78","2F");
        etable.put("79","71");
        etable.put("7A","3");
        etable.put("7B","20");
        etable.put("7C","E9");
        etable.put("7D","AE");
        etable.put("7E","60");
        etable.put("7F","A0");

        etable.put("80","FB");
        etable.put("81","16");
        etable.put("82","3A");
        etable.put("83","4E");
        etable.put("84","D2");
        etable.put("85","6D");
        etable.put("86","B7");
        etable.put("87","C2");
        etable.put("88","5D");
        etable.put("89","E7");
        etable.put("8A","32");
        etable.put("8B","56");
        etable.put("8C","FA");
        etable.put("8D","15");
        etable.put("8E","3F");
        etable.put("8F","41");

        etable.put("90","C3");
        etable.put("91","5E");
        etable.put("92","E2");
        etable.put("93","3D");
        etable.put("94","47");
        etable.put("95","C9");
        etable.put("96","40");
        etable.put("97","C0");
        etable.put("98","5B");
        etable.put("99","ED");
        etable.put("9A","2C");
        etable.put("9B","74");
        etable.put("9C","9C");
        etable.put("9D","BF");
        etable.put("9E","DA");
        etable.put("9F","75");

        etable.put("A0","9F");
        etable.put("A1","BA");
        etable.put("A2","D5");
        etable.put("A3","64");
        etable.put("A4","AC");
        etable.put("A5","EF");
        etable.put("A6","2A");
        etable.put("A7","7E");
        etable.put("A8","82");
        etable.put("A9","9D");
        etable.put("AA","BC");
        etable.put("AB","DF");
        etable.put("AC","7A");
        etable.put("AD","8E");
        etable.put("AE","89");
        etable.put("AF","80");

        etable.put("B0","9B");
        etable.put("B1","B6");
        etable.put("B2","C1");
        etable.put("B3","58");
        etable.put("B4","E8");
        etable.put("B5","23");
        etable.put("B6","65");
        etable.put("B7","AF");
        etable.put("B8","EA");
        etable.put("B9","25");
        etable.put("BA","6F");
        etable.put("BB","B1");
        etable.put("BC","C8");
        etable.put("BD","43");
        etable.put("BE","C5");
        etable.put("BF","54");

        etable.put("C0","FC");
        etable.put("C1","1F");
        etable.put("C2","21");
        etable.put("C3","63");
        etable.put("C4","A5");
        etable.put("C5","F4");
        etable.put("C6","07");
        etable.put("C7","09");
        etable.put("C8","1B");
        etable.put("C9","2D");
        etable.put("CA","77");
        etable.put("CB","99");
        etable.put("CC","B0");
        etable.put("CD","CB");
        etable.put("CE","46");
        etable.put("CF","CA");

        etable.put("D0","45");
        etable.put("D1","CF");
        etable.put("D2","4A");
        etable.put("D3","DE");
        etable.put("D4","79");
        etable.put("D5","8B");
        etable.put("D6","86");
        etable.put("D7","91");
        etable.put("D8","A8");
        etable.put("D9","E3");
        etable.put("DA","3E");
        etable.put("DB","42");
        etable.put("DC","C6");
        etable.put("DD","51");
        etable.put("DE","F3");
        etable.put("DF","0E");

        etable.put("E0","12");
        etable.put("E1","36");
        etable.put("E2","FA");
        etable.put("E3","EE");
        etable.put("E4","29");
        etable.put("E5","7B");
        etable.put("E6","8D");
        etable.put("E7","8C");
        etable.put("E8","8F");
        etable.put("E9","8A");
        etable.put("EA","85");
        etable.put("EB","94");
        etable.put("EC","A7");
        etable.put("ED","F2");
        etable.put("EE","0D");
        etable.put("EF","17");

        etable.put("F0","39");
        etable.put("F1","4B");
        etable.put("F2","DD");
        etable.put("F3","7C");
        etable.put("F4","84");
        etable.put("F5","97");
        etable.put("F6","A2");
        etable.put("F7","FD");
        etable.put("F8","1C");
        etable.put("F9","24");
        etable.put("FA","6C");
        etable.put("FB","B4");
        etable.put("FC","C7");
        etable.put("FD","52");
        etable.put("FE","F6");
        etable.put("FF","01");
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
        //mix columns testing
        byte[][] columns = {{19,19,83,69},{1,1,1,1},{45,38,49,76},{1,10,34,92}};
        byte[][] columnsRevised = mixColumns(columns, false);

        for (int i=0;i<columnsRevised.length;i++) {
            for (int j=0;j< columnsRevised[i].length;j++) {
                System.out.print(columnsRevised[i][j] + " ");
            }
            System.out.println("");
        }

        byte[][] originalColumns = mixColumns(columnsRevised, true);

        System.out.println("\n\n");
        for (int i=0;i< originalColumns.length;i++) {
            for (int j=0;j< originalColumns[i].length;j++) {
                System.out.print(originalColumns[i][j] + " ");
            }
            System.out.println("");
        }

        //addRoundKey testing
//        byte byte1 = 82;
//        byte byte2 = 103;
//
//        byte byte3 = (byte) (byte1 ^ byte2);
//        System.out.println(byte3);


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
