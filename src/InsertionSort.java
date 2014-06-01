
public class InsertionSort {
	
	private static int numOfComparisons = 0;
	
	public int getNumberOfComparisons() {
		return numOfComparisons;
	}
	
	public static void insertionsort(char[] A) {
		
		
		for(int counter = 0; counter < A.length; counter ++) {
			char currentValue = A[counter];
			int curr = counter - 1;
			
			while(curr >= 0 && A[curr] > currentValue) {
				numOfComparisons++;
				A[curr + 1] = A[curr];
				System.out.println(A[curr]);
				curr = curr - 1;
			}
			A[curr + 1] = currentValue;
			
		}
	}

}
