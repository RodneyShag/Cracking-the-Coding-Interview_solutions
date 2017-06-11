package __Intro_Prime;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test Prime\n");
		test(11);
		test(12);
		test(13);
		testGeneratePrimes(50);
	}
	
	private static void test(int num) {
		System.out.println("Is " + num + " prime? " + Prime.isPrime(num));
	}
	
	private static void testGeneratePrimes(int num) {
		boolean[] primes = Prime.generatePrimes(num);
		System.out.format("\nPrimes from 1-%d: ", num);
		for (int i = 0; i < primes.length; i++) {
			if (primes[i]) {
				System.out.print(i + " ");
			}
		}
	}
}
