public class RSA extends Cryptography {
	// for the sake of getting it to work, I decided to set the values
	// we could overwrite them manually by having some method "fix" them
	// maybe an update() method that takes all of the text boxes in GUIand fills in?
	// only need to overwrite p, q, and e
	
	// if you do that, make sure to check that p and q are prime
	// preferably, e is prime as well
	
	private static int p = 61;
	private static int q = 53;
	private static int e = 17;
	private static int n = p*q;
	private static int g = LCM(p-1,q-1);
	private static int d = calcD();
	
	
	// not too sure how to complete these, I assume you know what you want
	public static int getPublicKey(int m) {
		// returns n and e
		return 0;
	}
	public static int getPrivateKey(int c) {
		// returns n and d
		return 0;
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
