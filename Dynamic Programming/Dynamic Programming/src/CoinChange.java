public class CoinChange {
	
	/* Variable Declarations
	 * int S[]: set of coins used to make change
	 * int m: mth coin or the coin we are trying to find for change
	 * int n: size of the set
	 * 
	 */
	public static int count(int S[], int m, int n) {
		
		/* Construct a table to save the possible combinations of change.
		 * It is filled in a bottom up manner with the base case being there 
		 * are no coins.  This is when n = 0;
		 */
		int[] table = new int[n+1];
		for(int incr=0; incr < table.length; incr++) {
			table[incr] = 0;
		}
		
		//Base case if n =0
		table[0]=1;
		
		/* Pick the coins one by one and update the table[] values 
		 * after the index greater than or equal to the value of 
		 * the coin picked
		 */
		for(int i=0; i<m; i++) {
			for(int j=S[i]; j<=n; j++) {
				table[j] += table[j-S[i]];
			}
		}
		return table[n];
	}

	//Driver function to test the coin count
	public static void main(String[] args){
		int[] arr = {2,3,5,6};
		int n = 10;
		System.out.print(count(arr,arr.length, n));
		
	}
}
