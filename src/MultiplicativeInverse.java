
public class MultiplicativeInverse {
	public static long mult_inverse_nm(long m, long n) {
		long v = 0;
		long result = 0;
		while (result != 1) {
			v += 1;
			result = (n * v) % m;
		}
		return v;
	}
	
	
	public static void main(String[] args) {
		MultiplicativeInverse m = new MultiplicativeInverse();
		System.out.println(MultiplicativeInverse.mult_inverse_nm(491,41));
	}
}
