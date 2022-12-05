public class RSATesting {
	public static RSA rsa;
	
	public static void initialize() {
		rsa = new RSA();
	}
	
	public static void main(String[] args) {
		initialize();
		// values
		int p = 61;
		int q = 53;
		int e = 17;
		int n = p*q;
		int g = RSA.LCM(p-1,q-1);
		int d = RSA.calcD(e,g);
		
		String publicKey = n + "," + e;
		String privateKey = n + "," + d;
		
		String plainText = "a";
		String cipherText = rsa.encrypt(plainText,publicKey);
		String result = rsa.decrypt(cipherText,privateKey);
		
		String passed = "Passed!";
		if(!plainText.equals(result)) {
			print("basic program not working properly");
			print(result);
		}
		
		print("Main testing done!");
		testEncrypt(plainText,n,e);
		testDecrypt(cipherText,n,d);
	}
	public static void testEncrypt(String plainText, int n, int e) {
		// assume inputs are fine
		String publicKey = n + "," + e;
		String cipherText = rsa.encrypt(plainText,publicKey);
		
		publicKey = n + "," + e + ",0";
		cipherText = rsa.encrypt(plainText,publicKey);
		if(!cipherText.equals("Incorrect number of values for encrypt key, need n,e as integers")) {
			print("ValidateKey not counting values correctly");
		}
		
		publicKey = "n," + e;
		cipherText = rsa.encrypt(plainText,publicKey);
		if(!cipherText.equals("Encryption key not formatted correctly, make sure to only have two integers, no spaces")) {
			print("ValidateKey not recognizing non-int input");
		}
		
		e = 4;
		publicKey = n+","+e;
		cipherText = rsa.encrypt(plainText,publicKey);
		if(!cipherText.equals("second number should be prime")) {
			print("ValidateKey not recognizing non-prime e");
		}
		
		print("Encryption testing done!");
	}
	public static void testDecrypt(String cipherText, int n, int d) {
		String privateKey = n+","+d;
		String result = rsa.decrypt(cipherText,privateKey);
		
		privateKey = n+","+d+",0";
		result = rsa.decrypt(cipherText,privateKey);
		if(!result.equals("Incorrect number of values for encrypt key, need n,d as integers")) {
			print("ValidateKey not counting values correctly");
		}
		
		privateKey = "n,"+d;
		result = rsa.decrypt(cipherText,privateKey);
		if(!result.equals("Encryption key not formatted correctly, make sure to only have two integers, no spaces")) {
			print("ValidateKey not recognizing non-int inputs");
		}
		
		print("Decryption testing done!");
	}
	public static void print(String s) {
		System.out.println(s);
	}
}
