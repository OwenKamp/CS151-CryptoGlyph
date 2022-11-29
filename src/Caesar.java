import static java.lang.String.valueOf;

public class Caesar implements Cryptography {
    public static String encrypt(String plaintext, String key) {
        int Key = Integer.parseInt(key);
        plaintext = plaintext.toUpperCase();
        char[] plaintextArray = plaintext.toCharArray();

        for (int i=0;i< plaintextArray.length;i++) {
            plaintextArray[i] += Key;
            if (plaintextArray[i] > 90) {
                plaintextArray[i] -= 26;
            }
        }
        //ciphertext = valueOf(plaintextArray);
        return valueOf(plaintextArray);
    }

    public static String decrypt(String ciphertext, String key) {
        int Key = Integer.parseInt(key);
        ciphertext = ciphertext.toUpperCase();
        char[] ciphertextArray = ciphertext.toCharArray();

        for (int i=0;i< ciphertextArray.length;i++) {
            ciphertextArray[i] -= Key;
            if (ciphertextArray[i] < 65) {
                ciphertextArray[i] += 26;
            }
        }
        //plaintext = valueOf(ciphertextArray);
        return valueOf(ciphertextArray);
    }

    public static void main(String[] args) {
        Caesar cs = new Caesar();
        String encrypted = cs.encrypt("Testing", "3");
        System.out.println("Tester: " + encrypted);
        String decrypted = cs.decrypt(encrypted, "3");
        System.out.println("After decryption: " + decrypted);
    }
}
