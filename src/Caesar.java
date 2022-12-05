import static java.lang.String.valueOf;

public class Caesar extends Cryptography {
    public String encrypt(String plaintext, String key) {
        String validity = ValidateKey.validateEncrypt("Caesar's Cipher", key);
        if(!key.equals(validity)) {
            return validity;
        }
        int Key = Integer.parseInt(key);
        Key = Key % 26;
        System.out.println(Key);
        char[] plaintextArray = plaintext.toCharArray();
        System.out.println(plaintextArray[0]);
        for (int i=0;i< plaintextArray.length;i++) {
            plaintextArray[i] += Key;
//            if (plaintextArray[i] > 90) {
//                plaintextArray[i] -= 26;
//            }
        }
        ciphertext = valueOf(plaintextArray);
        return ciphertext;
    }

    public String decrypt(String ciphertext, String key) {
        String validity = ValidateKey.validateEncrypt("Caesar's Cipher", key);
        if(!key.equals(validity)) {
            return validity;
        }
        int Key = Integer.parseInt(key);
        Key = Key % 26;
        char[] ciphertextArray = ciphertext.toCharArray();

        for (int i=0;i< ciphertextArray.length;i++) {
            ciphertextArray[i] -= Key;
//            if (ciphertextArray[i] < 65) {
//                ciphertextArray[i] += 26;
//            }
        }
        plaintext = valueOf(ciphertextArray);
        return plaintext;
    }

    public static void main(String[] args) {
        Caesar cs = new Caesar();
        String encrypted = cs.encrypt("Testing", "3");
        System.out.println("Tester: " + encrypted);
        String decrypted = cs.decrypt(encrypted, "3");
        System.out.println("After decryption: " + decrypted);
    }
}
