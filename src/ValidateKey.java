import java.util.regex.*;  

public class ValidateKey {
//	Do not make exceptions, just return a string.
	public static String validateEncrypt(String algorithm, String key) {
		switch (algorithm) {
		case "Knapsack":
			String[] values = key.split(",");
			if(values.length != 8) {
				return "Invalid Length Encrypt Key";
			}
			break;
		case "RSA":
//			Values that check if input key is valid for encryption

			break;
		}

		return key;
	}
	
	public static String validateDecrypt(String algorithm, String key) {
		switch (algorithm) {
		case "Knapsack":
			String[] values = key.split(",");
			if(values.length != 10) {
				return "Invalid Length Decrypt Key";
			}
			break;
		case "RSA":
//			Values that check if input key is valid for DEcryption
			break;

		}
		return key;
	}

}
