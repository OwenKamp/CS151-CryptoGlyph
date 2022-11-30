import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class A51Testing {
    private static A51 a51;
    @BeforeAll
    public static void initialize(){
        a51 = new A51();
    }

    @Test
    public void testInitializeRegisters() {
        a51.initializeRegisters("1111111111111111111000000000000000000000011111111111111111111111");
        int[] xReg = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int[] yReg = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] zReg = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

        Boolean xCorrect = Arrays.equals(xReg, a51.getRegisterX());
        Boolean yCorrect = Arrays.equals(yReg, a51.getRegisterY());
        Boolean zCorrect = Arrays.equals(zReg, a51.getRegisterZ());

        assertTrue(xCorrect);
        assertTrue(yCorrect);
        assertTrue(zCorrect);
    }

    @BeforeEach
    public void initializeRegisters() {
        a51.initializeRegisters("1010101010101010101010101010101010101010101010101010101010101010");
    }

    @Test
    public void testGetRegisterX() {
        int[] registerX = {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1};
        Boolean equal = Arrays.equals(registerX, a51.getRegisterX());

        assertTrue(equal);
    }

    @Test
    public void testGetRegisterY() {
        int[] registerY = {0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1};
        Boolean equal = Arrays.equals(registerY, a51.getRegisterY());

        assertTrue(equal);
    }

    @Test
    public void testGetRegisterZ() {
        int[] registerZ = {0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0};
        Boolean equal = Arrays.equals(registerZ, a51.getRegisterZ());

        assertTrue(equal);
    }

    @Test
    public void testXStep() {
        int[] registerX = {0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0};
        a51.xSteps();

        Boolean equal = Arrays.equals(registerX, a51.getRegisterX());
        assertTrue(equal);
    }

    @Test
    public void testYStep() {
        int[] registerY = {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0};
        a51.ySteps();

        Boolean equal = Arrays.equals(registerY, a51.getRegisterY());
        assertTrue(equal);
    }

    @Test
    public void testZStep() {
        int[] registerZ = {0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1};
        a51.zSteps();

        Boolean equal = Arrays.equals(registerZ, a51.getRegisterZ());
        assertTrue(equal);
    }

    @Test
    public void testEncryption() {
        String ciphertext = a51.encrypt("hello my name is john doe and i am doing some testing", "1111111111111111111000000000000000000000011111111111111111111111");
        assertEquals("0110100001100101010100111001001110010000001101000110111010111010110001010110100101001001101110110000001100000111101011100111111101111000011001001100010110010001111111010001111011110011010010110011111111111011011111110010111101101001001001111001010111001001000110110111101001101010111010100010011000111101101000111101010100101110110000010110010010011011100111011110110011110010100000011111101011010100101100011011110010100101", ciphertext);
    }

    @Test
    public void testDecryption() {
        String plaintext = a51.decrypt("0110100001100101010100111001001110010000001101000110111010111010110001010110100101001001101110110000001100000111101011100111111101111000011001001100010110010001111111010001111011110011010010110011111111111011011111110010111101101001001001111001010111001001000110110111101001101010111010100010011000111101101000111101010100101110110000010110010010011011100111011110110011110010100000011111101011010100101100011011110010100101", "1111111111111111111000000000000000000000011111111111111111111111");
        assertEquals("hello my name is john doe and i am doing some testing", plaintext);
    }
}
