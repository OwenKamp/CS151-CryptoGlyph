import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PrimeFinder {
	public int[] primes;
    public void calculatePrimes(int n){
    	//  Create a boolean array
	    // "prime[0..n]" and
        // initialize all entries
        // it as true. A value in
        // prime[i] will finally be
        // false if i is Not a
        // prime, else true.
    	ArrayList<Integer> primes = new ArrayList<Integer>() ;
        boolean prime[] = new boolean[n + 1];
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
                primes.add(i);
        }
        this.primes = primes.stream().mapToInt(Integer::intValue).toArray();

    }
    
    public int[] getPrimes() throws PrimesNotCalculatedException {
    	if (primes.length == 0) {
    		throw new PrimesNotCalculatedException();
    	}
    	return primes;
    }
//    Gets a random prime number except for the last one. The last one is n.
//    This is used to pick a multiplier(m).
    public int getRandomPrime(Random r) throws PrimesNotCalculatedException {
    	if (primes.length == 0) {
    		throw new PrimesNotCalculatedException();
    	}
    	return primes[r.nextInt(primes.length)];
    }
    
    public static void main(String[] args) {
		PrimeFinder p = new PrimeFinder();
		p.calculatePrimes(100);
		int[] plist = null;
		try {
			plist = p.getPrimes();
		} catch (PrimesNotCalculatedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Arrays.toString(plist));
	}
}
