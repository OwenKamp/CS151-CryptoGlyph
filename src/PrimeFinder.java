import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PrimeFinder {
	public long[] primes;
    public void calculatePrimes(long n){
    	//  Create a boolean array
	    // "prime[0..n]" and
        // initialize all entries
        // it as true. A value in
        // prime[i] will finally be
        // false if i is Not a
        // prime, else true.
    	// Minimum value is 20 because otherwise there will not be enough primes.
    	if(n < 20) {
    		n = 20;
    	}
    	ArrayList<Long> primes = new ArrayList<Long>() ;
        boolean prime[] = new boolean[(int) (n + 1)];
        for (int i = 0; i <= n; i++)
            prime[i] = true;
 
        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a
            // prime
            if (prime[p] == true) {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
 
        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true)
                primes.add((long)i);
        }
        this.primes = primes.stream().mapToLong(Long::longValue).toArray();

    }
    
    public long[] getPrimes(){
    	return primes;
    }
//    Gets a random prime number except for the first and last one. The last one is n.
//    the first 3 are two small so it is not allowed.
//    This is used to pick a multiplier(m).
    public long getRandomPrime(Random r) throws PrimesNotCalculatedException {
    	if (primes.length == 0) {
    		throw new PrimesNotCalculatedException("No primes calculated yet");
    	}
    	return primes[r.nextInt(3,primes.length)];
    }
    
    public static void main(String[] args) throws PrimesNotCalculatedException {
		PrimeFinder p = new PrimeFinder();
		p.calculatePrimes(100);
		long[] plist = null;
		plist = p.getPrimes();
		Random r = new Random();
		for (int i=0;i<100;i++) {
			System.out.println(p.getRandomPrime(r)); 
		}
		System.out.println(Arrays.toString(plist));
	}
}
