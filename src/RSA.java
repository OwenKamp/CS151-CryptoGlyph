import java.util.stream.Stream;

public class RSA extends Cryptography {
	// currently, integers will overflow if the size is > 4. If we want to encode larger values, would probably just break up the string into sections of 4
	// would still get overflow eventually from putting the ints back together
	private int p;
	private int q;
	private int n;
	private int e;
	private int g;
	private int d;
	
	public void setKeys(String key) {
		ValidateKey.validateEncrypt("RSA", key);
		// only one key input format :)
		String[] vals = key.split(",");
		this.p = Integer.parseInt(vals[0]);
		this.q = Integer.parseInt(vals[1]);
		this.e = Integer.parseInt(vals[2]);
		this.n = p*q;
		this.g = LCM(p-1,q-1);
		this.d = calcD();
	}
	public String getPublicKey() {
		StringBuilder s = new StringBuilder();
		s.append("n=");
		s.append(n);
		s.append(",e=");
		s.append(e);
		return s.toString();
	}
	public String getPrivateKey() {
		StringBuilder s = new StringBuilder();
		s.append("n=");
		s.append(n);
		s.append(",d=");
		s.append(d);
		return s.toString();
	}
	
	public String encrypt(String plainText, String publicKey) {
		int msg = stringToInt(plainText);
		String cur = publicKey.substring(0,32);
		int n = stringToInt(cur);
		cur = publicKey.substring(32);
		int e = stringToInt(cur);
		
		int ret = 1;
		for(int i = 0; i < e; i++) {
			ret*=msg;
			while(ret >= n) {
				ret-=n;
			}
		}
		
		return intToString(ret);
	}
	public String decrypt(String cipherText, String privateKey) {
		int msg = stringToInt(cipherText);
		String cur = privateKey.substring(0,32);
		int n = stringToInt(cur);
		cur = privateKey.substring(32);
		int d = stringToInt(cur);
		
		int ret = 1;
		for(int i = 0; i < d; i++) {
			ret*=msg;
			while(ret >= n) {
				ret-=n;
			}
		}
		
		return intToString(ret);
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
	private int calcD() {
		int ret = 1;
		int val = e;
		while(val%g!=1) {
			val+=e;
			ret+=1;
			
			// make sure of no overflow, replaces mod at the end
			if(val > g) {
				val-=g;
			}
		}
		return ret;
	}
	
	// by cian
	private static String intToString(int i) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(i));

        while (sb.toString().length() % 8 != 0) {
            sb.insert(0, "0");
        }
        return Converter.binaryStringToString(sb.toString());
    }
	private static Integer stringToInt(String str) {
        String strBinary = Converter.stringToBinaryString(str);
        return Integer.parseInt(strBinary, 2);
    }
	public static void main(String[] args) {
		String str = "abcd";
		int num = stringToInt(str);
		System.out.println(str);
		System.out.println(num);
		System.out.println(intToString(num));
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
