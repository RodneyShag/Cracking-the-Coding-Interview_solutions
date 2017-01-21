package chapter7;

public class Prime {
	public static boolean isPrime(int n){
		for (int i = 2; i <= (int) Math.sqrt(n); i++){
			if (n % i == 0)
				return false;
		}
		return true;
	}
	
	public static boolean[] generatePrimes(int max){
		boolean [] flags = new boolean[max + 1];
		initialize(flags);
		int prime = 2;
		while (prime < flags.length && prime <= Math.sqrt(max)){ // see comment in crossOff() to see why we stop at sqrt(max) here
			crossOff(flags, prime);
			prime = getNextPrime(flags, prime);
		}
		return flags;
	}
	
	private static void initialize(boolean [] flags){
		flags[0] = false;
		flags[1] = false;
		for (int i = 2; i < flags.length; i++){
			flags[i] = true;
		}
	}
	
	/* Cross off multiples of prime from our array */
	private static void crossOff(boolean[] flags, int prime) {
		/* We can start with (prime*prime), because if we have a k * prime, where , < prime,
		   this value would have already been crossed off in a prior call to this function */
		for (int i = prime*prime; i < flags.length; i += prime){
			flags[i] = false;
		}
	}
	
	private static int getNextPrime(boolean[] flags, int prime) {
		for (int i = prime + 1; i < flags.length; i++){
			if (flags[i] == true)
				return i;
		}
		return -1; // our boolean[] wasn't big enough so we couldn't find the next prime.
	}
}
