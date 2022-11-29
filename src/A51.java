import java.util.Arrays;

public class A51 implements Cryptography {
    private static int[] registerX = new int[19];
    private static int[] registerY = new int[22];
    private static int[] registerZ = new int[23];

    // method to encrypt a plaintext using the A51 algorithm
    public static String encrypt(String plaintext, String key) {
        String binaryPlaintext = Converter.stringToBinaryString(plaintext);                                         // convert plaintext into a string of binary digits
        char[] binaryPlaintextArray = binaryPlaintext.toCharArray();                                                // convert string into char array
        StringBuilder ciphertextBuilder = new StringBuilder();

        initializeRegisters(key);                                                                                   // initialize each register

        for (int i=0;i<binaryPlaintextArray.length;i++) {                                                           // for each binary digit in the plaintext, xor it with keystream bit
            if (registerX[8] + registerY[10] + registerZ[10] < 2) {                                                 // figure out majority, anything with majority steps
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
            } else {                                                                                                // if majority is 1
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
            int keyStreamBit = registerX[18] ^ registerY[21] ^ registerZ[22];                                       // generate keystream bit
            char binaryNumber = (char) (keyStreamBit ^ binaryPlaintextArray[i]);                                    // xor keystream bit with plaintext bit
            ciphertextBuilder.append(binaryNumber);                                                                 // append bit to ciphertext
        }
        return ciphertextBuilder.toString();
    }

    // method to decrypt a plaintext using the A51 algorithm
    public static String decrypt(String ciphertext, String key) {
        char[] ciphertextArray = ciphertext.toCharArray();                                                          // convert ciphertext string into a character array
        StringBuilder plaintextBuilder = new StringBuilder();

        initializeRegisters(key);                                                                                   // initialize the registers

        for (int i=0;i<ciphertextArray.length;i++) {                                                                // for each binary digit in ciphertext, xor it with keystream bit
            if (registerX[8] + registerY[10] + registerZ[10] < 2) {                                                 // figure out majority, anything with majority steps
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
            } else {                                                                                                // if majority is 1
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
            int keyStreamBit = registerX[18] ^ registerY[21] ^ registerZ[22];                                       // generate keystream bit
            char binaryNumber = (char) (keyStreamBit ^ ciphertextArray[i]);                                         // xor keystream bit with plaintext bit
            plaintextBuilder.append(binaryNumber);                                                                  // append bit to ciphertext
        }
        return Converter.binaryStringToString(plaintextBuilder.toString());
    }

    // method to make x register "step"
    public static void xSteps() {
        int temp = registerX[13] ^ registerX[16] ^ registerX[17] ^ registerX[18];
        for (int i=18;i>0;i--) {
            registerX[i] = registerX[i-1];
        }
        registerX[0] = temp;
    }

    // method to make the y register "step"
    public static void ySteps() {
        int temp = registerY[20] ^ registerY[21];
        for (int i=21;i>0;i--) {
            registerY[i] = registerY[i-1];
        }
        registerY[0] = temp;
    }

    // method to make the z register "step"
    public static void zSteps() {
        int temp = registerZ[7] ^ registerZ[20] ^ registerZ[21] ^ registerZ[22];
        for (int i=22;i>0;i--) {
            registerZ[i] = registerZ[i-1];
        }
        registerZ[0] = temp;
    }

    // function to initialize the registers using the key
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

    public static int[] getRegisterX() {
        return registerX;
    }

    public static int[] getRegisterY() {
        return registerY;
    }

    public static int[] getRegisterZ() {
        return registerZ;
    }
}
