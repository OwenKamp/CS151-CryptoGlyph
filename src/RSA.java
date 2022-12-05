import java.util.stream.Stream;

public class RSA extends Cryptography {
	// overflows if the msg is > 4 chars long, cuz encoding takes 8*n bits, n = length of input
	// ints have 32 bits in memory, so 32/8 = 4, so n max is 4

	public static String getPublicKey(int p, int q, int e) {
		StringBuilder s = new StringBuilder();
		int n = p*q;
		s.append("n=");
		s.append(n);
		s.append(",e=");
		s.append(e);
		return s.toString();
	}
	public static String getPrivateKey(int p, int q, int e) {
		StringBuilder s = new StringBuilder();
		int n = p*q;
		int d = calcD(e, LCM(p,q));
		s.append("n=");
		s.append(n);
		s.append(",d=");
		s.append(d);
		return s.toString();
	}
	
	public String encrypt(String plainText, String publicKey) {
		String validity = ValidateKey.validateEncrypt("RSA", publicKey);
		if(!publicKey.equals(validity)) {
			return validity;
		}
		String[] key = publicKey.split(",");
		int msg = Converter.stringToInt(plainText);
		int n = Integer.parseInt(key[0]);
		int e = Integer.parseInt(key[1]);
		
		int ret = encryptNum(msg,n,e);
		
		return Converter.intToString(ret);
	}
	public int encryptNum(int m, int n, int e) {
		int ret = 1;
		for(int i = 0; i < e; i++) {
			ret*=m;
			while(ret >= n) {
				ret-=n;
			}
		}
		return ret;
	}
	public String decrypt(String cipherText, String privateKey) {
		String validity = ValidateKey.validateDecrypt("RSA", privateKey);
		if(!privateKey.equals(validity)) {
			System.out.println("inside if statement");
			return validity;
		}
		
		String[] key = privateKey.split(",");
		int cipher = Converter.stringToInt(cipherText);
		int n = Integer.parseInt(key[0]);
		int d = Integer.parseInt(key[1]);
		
		int ret = decryptNum(cipher,n,d);
		
		return Converter.intToString(ret);
	}
	public int decryptNum(int c, int n, int d) {
		int ret = 1;
		for(int i = 0; i < d; i++) {
			ret*=c;
			while(ret >= n) {
				ret-=n;
			}
		}
		
		return ret;
	}
	private static int LCM(int p, int q) {
		return Math.abs(p*q)/GCD(p,q);
	}
	private static int GCD(int p, int q) {
		int m1 = Math.min(p,q);
		int m2 = Math.max(p,q);
		
		int ret = m1;
		while(ret > 0 && (m1%ret!=0 || m2%ret!=0)) {
			ret--;
		}
		return ret;
	}
	private static int calcD(int e, int g) {
		int d = 1;
		while((d*e)%g!=1) {
			d++;
		}
		return d;
	}


	public static void main(String[] args) {
		RSA encrypter = new RSA();
		int p = 61;
		int q = 53;
		int e = 17;

		String origin = "o";
		String cipher = encrypter.encrypt(origin, "3233,17");
		String plain = encrypter.decrypt(cipher, "3233,413");
		System.out.println(origin);
		System.out.println(cipher);
		System.out.println(plain);
	}

	/*	Proof for calcD time complexity
	 * 
	 * de = 1 (mod g)
	 * 17d = 1 (mod 3233)
	 * d = 413
	 * 
	 * e < n
	 * 
	 * n is not even
	 * if e = n-2 (mod n)
	 * 2e = 2n-4 (mod n)
	 * 2e = n-4 (mod n)
	 * ....
	 * xe = xn-2x (mod n)
	 * xe = n-2x (mod n)
	 * 
	 * since n is odd, this will eventually result in max of 2x = n+1 = d, so
	 * de = n-n+1 (mod n)
	 * de = 1 (mod n)
	 * 
	 * 
	 * if e = n-2k (mod n),
	 * 2k is even, but will still eventually reach 2k = n+1 = d
	 * so, de = n-n+1 (mod n)
	 * de = 1 (mod n)
	 * 
	 * e and n are both odd, because they are both prime, and e,n != 2
	 * since e < n, 
	 * e = n - 2k always
	 * 
	 * finding d is in O(n+1) = O(n) worst case
	 */
}
