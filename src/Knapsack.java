import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Random;

// This will be worked on by David
public class Knapsack extends Cryptography {
//	m and n are relatively prime
//	n is greater than the sum of all elements in the super- increasing knapsack.
//	To get the general knapsack, you need to mod the result of sik and multiplier(m) by n.  
	private static java.util.Random r = new java.util.Random();

	protected static final byte[] MASKS = { ((byte) 0b00000001), ((byte) 0b00000010), ((byte) 0b00000100),
			((byte) 0b00001000), ((byte) 0b00010000), ((byte) 0b00100000), ((byte) 0b01000000), ((byte) 0b10000000) };

//	https://www.geeksforgeeks.org/copyright-information/?ref=footer
//	https://www.geeksforgeeks.org/java-program-to-display-all-prime-numbers-from-1-to-n/
	public static float generateMultiplier() {
		return r.nextInt(3) + 1 + (r.nextFloat()*0.5f) + 0.01f;
	}

//	For the Super-Increasing Knapsack generate an int array where the next element
//	in the array is greater than the sum of all previous weights.
//	Basically generates the Private key
	public static long[] generateSIK() {
//		Each SIK will be 8 numbers long. The length of one byte. The 9th will be m, the 10th will 
//		be n
//		n > sum of all elements in SIK
		long[] sik = new long[10];
		sik[0] = r.nextInt(5);
		long sum = sik[0];

//		The next number should be the sum of all the previous numbers 
////	times a float between 1.01 and 4.00 times the sum. Then it should be cast to an int.
		for (int i = 1; i < 8; i++) {
			float mul = generateMultiplier();
			sik[i] = (long) (sum * mul);
			sum += sik[i];
//			System.out.println(sum);
		}
		PrimeFinder pf = new PrimeFinder();
		long[] primes;
		pf.calculatePrimes((long) (Arrays.stream(sik).sum() * generateMultiplier()));
		try {
//			Only the following lines could be problematic   
			primes = pf.getPrimes();
//			The last prime number is the n value. 
			sik[9] = primes[primes.length - 1];
//			Select the multiplier from the first half of prime numbers array
			long centerPrime = primes[((primes.length - 1) / 2)];
			sik[8] = pf.getRandomPrime(r);
			while (sik[8] >= centerPrime) {
				sik[8] = pf.getRandomPrime(r);
			}

		} catch (PrimesNotCalculatedException e1) {
			return null;
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
		return sik;
	}

	public static long[] generateGK(long[] sik) {

		long[] gk = new long[8];
		for (int i = 0; i < 8; i++) {
			gk[i] = (sik[i] * sik[8]) % sik[9];
		}

		return gk;
	}

//	key is 10 CSV values. m is 9th , n is 10th
//	This ignores the 
	@Override
	public String encrypt(String plainText, String key) {
		if (plainText == null) {
			return null;
		}
		long len = plainText.length();
		if (len == 0) {
			return null;
		}
		long[] keyArray = csvToLongArray(key);

		long[] sums = new long[(int)len];

//		For each letter in the plainText to encrypt 
		for (int i = 0; i < len; i++) {
//			get that letter as a binary 8-bit representation
			byte c = (byte) plainText.charAt(i);
//			for each bit in each letter starting right to left,
			for (int j = 0; j < 8; j++) {
//				if the bit is 1,
				if (getBit(c, j) == 1) {
//					add to the current letter's sum the corresponding keyArray's value.
					sums[i] += keyArray[7 - j];
				}
			}
		}
		return longArrayToCsv(sums);
	}

//	Encrypted returns the sums of the public knapsack.
//	To convert back to the original number ,I must take the number and multiply it by the inverse of m and modulo it by n.

	@Override
	public String decrypt(String cipherText, String key) {
//		Create the value to return
		StringBuilder sb = new StringBuilder();
//		change the input to integer arrays.
		long[] sumArray = csvToLongArray(cipherText);
		long[] keyArray = csvToLongArray(key);
		for (int i = 0; i < sumArray.length; i++) {
			sb.append(solveKnapsack(sumArray[i], keyArray));
		}
		return sb.toString();
	}

	public static int[] charToBinaryArray(char c) {
		int[] binaryArray = new int[8];
		String charBinaryStr = charToBinaryStr(c);
		for (int i = 0; i < 8; i++) {
			binaryArray[i] = Integer.parseInt(Character.toString(charBinaryStr.charAt(i)));
		}
		return binaryArray;
	}

//	https://stackoverflow.com/questions/9354860/how-to-get-the-value-of-a-bit-at-a-certain-position-from-a-byte
	public static int getBit(byte b, int position) {
		return (b >> position) & 1;
	}

	public static char solveKnapsack(long encrypted, long[] sik) {
		byte ret = 0x00;
		long m = sik[8];
		long n = sik[9];
		long conversionFactor = MultiplicativeInverse.mult_inverse_nm(n, m);
		long sum = (encrypted * conversionFactor) % n;
		int i = 0;
		while(sum > 0) {
			if (sum >= sik[7-i]) {
				long v = sik[7-i];
				ret = (byte)(ret | MASKS[i]);
				sum = sum - v;
			}
			i++;
		}
		return (char) ret;
		}

	public static String longArrayToCsv(long[] longArray) {
		StringBuilder sb = new StringBuilder();
		for (long i : longArray) {
			sb.append(i);
			sb.append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public static long[] csvToLongArray(String csv) {
		return Stream.of(csv.split(",")).mapToLong(Long::parseLong).toArray();
	}

	public static String convertStringToBinary(String input) {

		StringBuilder result = new StringBuilder();
		char[] chars = input.toCharArray();
		for (char aChar : chars) {
			result.append(charToBinaryStr(aChar));
		}
		return result.toString();

	}

	public static String charToBinaryStr(char c) {
		return String.format("%8s", Integer.toBinaryString(c)).replaceAll(" ", "0");
	}

	public static void main(String[] args) {
		Knapsack k = new Knapsack();
		long[] sik = Knapsack.generateSIK();
		long[] gk = Knapsack.generateGK(sik);
		String wordToEncrypt = "Hello There Warshawsky";
		System.out.println(wordToEncrypt);
		String encrypted = k.encrypt(wordToEncrypt, Knapsack.longArrayToCsv(gk));
		System.out.println("ENCRYPTED: " + encrypted);
		String decrypted = k.decrypt(encrypted, Knapsack.longArrayToCsv(sik));
		System.out.println("DECRYPTED: " + decrypted);
		
//		https://stackoverflow.com/questions/36019032/how-to-iterate-over-all-bits-of-a-byte-in-java

	}

}
