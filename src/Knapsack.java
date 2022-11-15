import java.util.Arrays;
import java.util.Random;

public class Knapsack extends Cryptography {
//	m and n are relatively prime
//	n is greater than the sum of all elements in the super- increasing knapsack.
//	To get the general knapsack, you need to mod the result of sik and multiplier(m) by n.  
	private static Random r = new Random();

//	https://www.geeksforgeeks.org/copyright-information/?ref=footer
//	https://www.geeksforgeeks.org/java-program-to-display-all-prime-numbers-from-1-to-n/
	public static float generateMultiplier() {
		return r.nextInt(1, 4) + r.nextFloat() + 0.01f;
	}

//	For the Super-Increasing Knapsack generate an int array where the next element
//	in the array is greater than the sum of all previous weights.
//	Basically generates the Private key
	public int[] generateSIK() {
//		Each SIK will be 8 numbers long. The length of one byte. The 9th will be m, the 10th will 
//		be n
		int[] sik = new int[10];
		sik[0] = r.nextInt(101);
		int sum = sik[0];

//		The next number should be the sum of all the previous numbers 
////	times a float between 1.01 and 4.00 times the sum. Then it should be cast to an int.
		for (int i = 1; i < 8; i++) {
			float mul = generateMultiplier();
			sik[i] = (int) (sum * mul);
			sum += sik[i];
//			System.out.println(sum);
		}
		PrimeFinder pf = new PrimeFinder();
		int[] primes;
		pf.calculatePrimes((int) (Arrays.stream(sik).sum() * generateMultiplier()));
		try {
//			Only the following lines could be problematic   
			primes = pf.getPrimes();
//			The last prime number is the n value. 
			sik[9] = primes[primes.length - 1];
//			Select the multiplier from the first half of prime numbers array
			int centerPrime = primes[((primes.length - 1) / 2)];
			sik[8] = pf.getRandomPrime(r);
			while (sik[8] >= centerPrime) {
				sik[8] = pf.getRandomPrime(r);
			}
			
		} catch (PrimesNotCalculatedException e1) {
			// TODO Auto-generated catch block
			return null;
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
		return sik;
	}

	public int[] generateGK(int sik[]) {
		
		int[] gk = new int[8];
		for(int i=0;i<8;i++) {
			gk[i] = (sik[i]*sik[8]) % sik[9];
		}

		return gk;
	}
	
	public static String convertStringToBinary(String input) {

        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(aChar))   // char -> int, auto-cast
                            .replaceAll(" ", "0")                         // zero pads
            );
        }
        return result.toString();

    }
	
	
	@Override
	public String encrypt(String plainText, String key) {
		String binary = convertStringToBinary(plainText);
		return null;
	}

	@Override
	public String decrypt(String cipherText, String key) {
		// TODO Auto-generated method stub
		return null;
	}
	public static String charToBinaryStr(char c) {
		return String.format("%8s", Integer.toBinaryString('i')).replaceAll(" ", "0");
	}
	
	public static int[] charToBinaryArray(char c) {
		int[] bArray = new int[8];
		String charBinaryStr = charToBinaryStr(c);
		for (int i=0;i<8;i++) {
			bArray[i] = Integer.parseInt(charBinaryStr[i]);
		}
		return bArray;
	}

	public static void main(String[] args) {
//		System.out.println(Arrays.toString(generateSIK()));
		System.out.println();
	}

}
