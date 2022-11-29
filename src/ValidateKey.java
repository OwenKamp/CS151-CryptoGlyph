import java.util.regex.*;  

public class ValidateKey {
	
	public static String validateEncrypt(String algorithm, String key) {
		switch (algorithm) {
		case "Knapsack":
			String[] values = key.split(",");
			if(values.length != 8) {
				return "Invalid Length Encrypt Key";
			}
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
		}
		return key;
	}

}
