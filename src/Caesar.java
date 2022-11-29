import static java.lang.String.valueOf;

public class Caesar implements Cryptography {

    // method to encrypt plaintext using Caesar's algorithm
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
        return valueOf(plaintextArray);
    }

    // method to decrypt ciphertext using Caesar's algorithm
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
        return valueOf(ciphertextArray);
    }
}
