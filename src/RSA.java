public class RSA extends Cryptography {
	// I set default values, just remove these if you don't want them
	
	private static int p = 61;
	private static int q = 53;
	private static int e = 17;
	private static int n = p*q;
	private static int g = LCM(p-1,q-1);
	private static int d = calcD();
	
	// only necessary if you want to have p, q, and e be inputs
	public static void update(int newP, int newQ, int newE) {
		p = newP;
		q = newQ;
		e = newE;
		n = p*q;
		g = LCM(p-1,q-1);
		d = calcD();
	}
	
	// if you need these, they give a 64 bit key with the first 32 being n and e for the public key, and n and d for the private key
	public static String getPublicKey() {
		StringBuilder s = new StringBuilder();
		String str = Integer.toBinaryString(n);
		if(str.length()<32) {
			for(int i = str.length(); i < 32; i++) {
				s.append("0");
			}
		}
		s.append(str);
		
		str = Integer.toBinaryString(e);
		if(str.length()<32) {
			for(int i = str.length(); i < 32; i++) {
				s.append("0");
			}
		}
		s.append(str);
		
		return s.toString();
	}
	public static String getPrivateKey() {
		StringBuilder s = new StringBuilder();
		String str = Integer.toBinaryString(n);
		if(str.length()<32) {
			for(int i = str.length(); i < 32; i++) {
				s.append("0");
			}
		}
		s.append(str);
		
		str = Integer.toBinaryString(d);
		if(str.length()<32) {
			for(int i = str.length(); i < 32; i++) {
				s.append("0");
			}
		}
		s.append(str);
		
		return s.toString();
	}
	
	public static int encrypt(int msg) {
		int ret = 1;
		for(int i = 0; i < e; i++) {
			ret*=msg;
			while(ret >= n) {
				ret-=n;
			}
		}
		return ret;
	}
	public static int decrypt(int msg) {
		int ret = 1;
		for(int i = 0; i < d; i++) {
			ret*=msg;
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
	private static int calcD() {
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
	public static void main(String[] args) {
		System.out.println(n);
		int msg = 65;
		int c = encrypt(msg);
		System.out.println(c);
		System.out.println(decrypt(c));
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