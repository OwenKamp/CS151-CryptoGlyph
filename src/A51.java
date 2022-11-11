import java.util.Arrays;

public class A51 extends Symmetric {
    private int[] registerX = new int[19];
    private int[] registerY = new int[22];
    private int[] registerZ = new int[23];

    public String encrypt(String plaintext, String key) {
        initializeRegisters(key);

        for (int i=0;i<plaintext.length();i++) {
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
        }
        int keyStreamBit = registerX[18] ^ registerY[21] ^ registerZ[22];


        return ciphertext;
    }

    public String decrypt(String ciphertext, String key) {
        return plaintext;
    }

    public void xSteps() {
        int temp = registerX[13] ^ registerX[16] ^ registerX[17] ^ registerX[18];
        for (int i=19;i>0;i--) {
            registerX[i] = registerX[i-1];
        }
        registerX[0] = temp;
    }

    public void ySteps() {
        int temp = registerY[20] ^ registerY[21];
        for (int i=21;i>0;i--) {
            registerY[i] = registerY[i-1];
        }
        registerY[0] = temp;
    }

    public void zSteps() {
        int temp = registerZ[7] ^ registerZ[20] ^ registerZ[21] ^ registerZ[22];
        for (int i=22;i>0;i++) {
            registerZ[i] = registerZ[i-1];
        }
        registerZ[0] = temp;
    }

    public void initializeRegisters(String key) {
        for (int i=0;i<19;i++) {
            registerX[i] = key.charAt(i);
        }

        for (int i=0;i<22;i++) {
            registerY[i] = key.charAt(i+19);
        }

        for (int i=0;i<23;i++) {
            registerZ[i] = key.charAt(i+41);
        }
    }

    public static void main(String[] args) {
        A51 tester = new A51();
        tester.encrypt("TEst", "1111111111111111111000000000000000000000011111111111111111111111");
    }
}
