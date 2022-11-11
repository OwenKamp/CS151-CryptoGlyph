public abstract class Cryptography {
    public String plaintext;
    public String ciphertext;

    public abstract String encrypt(String plaintext, String key);
    public abstract String decrypt(String ciphertext, String key);
}