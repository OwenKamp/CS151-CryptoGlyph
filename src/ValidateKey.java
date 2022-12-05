import java.util.regex.*;  

public class ValidateKey {
//	Do not make exceptions, just return a string.
	public static String validateEncrypt(String algorithm, String key) {
		switch (algorithm) {
		case "Caesar's Cipher":
			try {
				Integer.parseInt(key);
			}
			catch (NumberFormatException e) {
				return "Key should be a decimal number";
			}
			break;
		case "A51":
			if(key.length() != 64) {
				return "Key should be 64 characters long";
			}
			try {
				for(int i = 0; i < key.length(); i++) {
					int n = Integer.parseInt(key.substring(i,i+1));
					if(n!=1 && n!=0) {
						return "Key should be in binary only";
					}
				}
			}
			catch (NumberFormatException e) {
				return "Key should be a 64 digit binary number";
			}
			break;
		case "Knapsack":
			String[] values = key.split(",");
			if(values.length != 8) {
				return "Invalid Length Encrypt Key";
			}
			break;
		case "RSA":
<<<<<<< HEAD
			String[] ints = key.split(",");
			if(ints.length != 3) {
				return "Incorrect number of values for encrypt key, need p,q,e as integers";
			}
			try {
				for(String i : ints) {
					Integer.parseInt(i);
				}
			}
			catch (NumberFormatException e) {
				return "Encryption key not formatted correctly, make sure to only have three integers, no spaces";
			}
=======
//			Values that check if input key is valid for encryption

>>>>>>> 559f5f4e363a794ad23758e0772158d26acb1e05
			break;
		}

		return key;
	}
	
	public static String validateDecrypt(String algorithm, String key) {
		switch (algorithm) {
		case "Caesar's Cipher":
			try {
				Integer.parseInt(key);
			}
			catch (NumberFormatException e) {
				return "Key should be a decimal number";
			}
			break;
		case "A51":
			if(key.length() != 64) {
				return "Key should be 64 characters long";
			}
			try {
				for(int i = 0; i < key.length(); i++) {
					int n = Integer.parseInt(key.substring(i,i+1));
					if(n!=1 && n!=0) {
						return "Key should be in binary only";
					}
				}
			}
			catch (NumberFormatException e) {
				return "Key should be a 64 digit binary number";
			}
			break;
		case "Knapsack":
			String[] values = key.split(",");
			if(values.length != 10) {
				return "Invalid Length Decrypt Key";
			}
			break;
		case "RSA":
<<<<<<< HEAD
			String[] ints = key.split(",");
			if(ints.length != 3) {
				return "Incorrect number of values for decrypt key, need p,q,e as integers";
			}
			try {
				for(String i : ints) {
					Integer.parseInt(i);
				}
			}
			catch (NumberFormatException e) {
				return "Decryption key not formatted correctly, make sure to only have three integers, no spaces";
			}
			break;
=======
//			Values that check if input key is valid for DEcryption
			break;

>>>>>>> 559f5f4e363a794ad23758e0772158d26acb1e05
		}
		return key;
	}

}
