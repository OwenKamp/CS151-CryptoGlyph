import java.util.Arrays;

public class A51 implements Cryptography {
    private static int[] registerX = new int[19];
    private static int[] registerY = new int[22];
    private static int[] registerZ = new int[23];

    public static String encrypt(String plaintext, String key) {
        String binaryPlaintext = Converter.stringToBinaryString(plaintext);
        char[] binaryPlaintextArray = binaryPlaintext.toCharArray();
        StringBuilder ciphertextBuilder = new StringBuilder();

        initializeRegisters(key);

        for (int i=0;i<binaryPlaintextArray.length;i++) {
            //System.out.println(registerX[8] + registerY[10] + registerZ[10]);
            if (registerX[8] + registerY[10] + registerZ[10] < 2) {
                //anything with 0 steps
                if (registerX[8] == 0) {
                    xSteps();
                }
                if (registerY[10] == 0) {
                    ySteps();
                }
                if (registerZ[10] == 0) {
                    zSteps();
                }
            } else {
                if (registerX[8] == 1) {
                    xSteps();
                }
                if (registerY[10] == 1) {
                    ySteps();
                }
                if (registerZ[10] == 1) {
                    zSteps();
                }
            }
            int keyStreamBit = registerX[18] ^ registerY[21] ^ registerZ[22];
            //System.out.println("keyStreamBit: " + keyStreamBit + "\nbinaryPlaintextArray: " + binaryPlaintextArray[i]);
            char binaryNumber = (char) (keyStreamBit ^ binaryPlaintextArray[i]);
            ciphertextBuilder.append(binaryNumber);
            //System.out.println(ciphertextBuilder.toString());
        }
        //ciphertext = ciphertextBuilder.toString();
        return ciphertextBuilder.toString();
    }

    public static String decrypt(String ciphertext, String key) {
        char[] ciphertextArray = ciphertext.toCharArray();
        StringBuilder plaintextBuilder = new StringBuilder();

        initializeRegisters(key);

        for (int i=0;i<ciphertextArray.length;i++) {
            //System.out.println(registerX[8] + registerY[10] + registerZ[10]);
            if (registerX[8] + registerY[10] + registerZ[10] < 2) {
                //anything with 0 steps
                if (registerX[8] == 0) {
                    xSteps();
                }
                if (registerY[10] == 0) {
                    ySteps();
                }
                if (registerZ[10] == 0) {
                    zSteps();
                }
            } else {
                if (registerX[8] == 1) {
                    xSteps();
                }
                if (registerY[10] == 1) {
                    ySteps();
                }
                if (registerZ[10] == 1) {
                    zSteps();
                }
            }
            int keyStreamBit = registerX[18] ^ registerY[21] ^ registerZ[22];
            //System.out.println("keyStreamBit: " + keyStreamBit + "\nbinaryPlaintextArray: " + binaryPlaintextArray[i]);
            char binaryNumber = (char) (keyStreamBit ^ ciphertextArray[i]);
            plaintextBuilder.append(binaryNumber);
            //System.out.println(ciphertextBuilder.toString());
        }
        //plaintext = Converter.binaryStringToString(plaintextBuilder.toString());
        return Converter.binaryStringToString(plaintextBuilder.toString());
    }

    public static void xSteps() {
        int temp = registerX[13] ^ registerX[16] ^ registerX[17] ^ registerX[18];
        for (int i=18;i>0;i--) {
            registerX[i] = registerX[i-1];
        }
        registerX[0] = temp;
    }

    public static void ySteps() {
        int temp = registerY[20] ^ registerY[21];
        for (int i=21;i>0;i--) {
            registerY[i] = registerY[i-1];
        }
        registerY[0] = temp;
    }

    public static void zSteps() {
        int temp = registerZ[7] ^ registerZ[20] ^ registerZ[21] ^ registerZ[22];
        for (int i=22;i>0;i--) {
            registerZ[i] = registerZ[i-1];
        }
        registerZ[0] = temp;
    }

    public static void initializeRegisters(String key) {
        for (int i=0;i<19;i++) {
            registerX[i] = key.charAt(i) - '0';
        }

        for (int i=0;i<22;i++) {
            registerY[i] = key.charAt(i+19) - '0';
        }

        for (int i=0;i<23;i++) {
            registerZ[i] = key.charAt(i+41) - '0';
        }
    }

    public static void main(String[] args) {
        A51 tester = new A51();
        String ciphertext = tester.encrypt("hello my name is john doe and i am doing some testing", "1111111111111111111000000000000000000000011111111111111111111111");
        System.out.println("Ciphertext: " + ciphertext);
        String plaintext = tester.decrypt(ciphertext, "1111111111111111111000000000000000000000011111111111111111111111");
        System.out.println(plaintext);
    }
}
