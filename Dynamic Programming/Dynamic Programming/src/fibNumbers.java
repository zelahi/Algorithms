
public class fibNumbers {
	
	public static long memoizedFib(int n) {
		return memoizedFib(n, new long[n+1]);
	}
	
	private static long memoizedFib(int n, long[] lookup){
		if (n < 2) {
			return n;
		}
		
		if(lookup[n] != 0) {
			return lookup[n];
		} else {
			long sum = memoizedFib(n-1, lookup) + memoizedFib(n-2, lookup);
			lookup[n] = sum;
			printLookup(lookup);
			return sum;
		}
	}
	
	public static long fib(int n) {
		if (n < 2) {
			return n;
		} else {
			return fib(n-1) + fib(n-2);
		}	
	}
	
	public static long bottomUpFib(int n) {
		long[] fib = new long[n+1];
		fib[0] = 0; fib[1] = 1; //initialize the first couple values for the fib sequence
		for(int incr = 2; incr <= n; incr++) {
			fib[incr] = fib[incr - 1] + fib[incr - 2];
		}
		return fib[n];
	}
	
	public static void printLookup(long[] lookup) {
		
		for(int count = 0; count < lookup.length - 2; count++)
			System.out.print(lookup[count] + " ");
		
		System.out.println("Values in lookup table:");
	}
	
	
	public static void main(String[] args) {
		int n = 4;
		
		//System.out.print("Fib number:" + memoizedFib(n));
		System.out.print("Bottomup Fib: " + bottomUpFib(n));
	}
}




