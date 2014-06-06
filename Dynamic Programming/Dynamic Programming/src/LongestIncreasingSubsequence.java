
public class LongestIncreasingSubsequence {
	

	public static int lis(int arr[], int n) {
		int max =0;
		int[] lis = new int[n];
		
		//Initialize LIS values for all indexes
		for(int i=0; i< n; i++) {
			lis[i] = 1;
		}
		
		//Compute the optimized LIS values through Tabulerization or in a bottom up manner
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		
			//print out the longest subsequence
			for(int incr = 0; incr < lis.length; incr ++)
				System.out.print(lis[incr]);
		}
		
		//Pick the maximum of all LIS values
		for(int count=0; count<n; count++) {
			if(max < lis[count]) {
				max = lis[count];
			}
		}
		//return the max value in the array
		return max;
		
	}
	
	public static void main(String[] args) {
		int arr[] = {10, 22, 9, 33, 21, 50, 41, 60,25, 40, 100, 99};
		int n = arr.length;
		System.out.print("Length of LIS:" + lis(arr, arr.length));
	}
}
