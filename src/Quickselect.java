/* Class Name: Quickselect.java
 * 
 * Programmer: Zuhayr Elahi
 * 
 * Big-O Runtime:  Worst Case: O(n^2) Best + Average Case: O(n)
 * 
 * Description: Implements the quickselect algorithm.  It creates a 
 * 				partition based on the kth Value and then sorts the
 * 				array.
 * 
 * References: http://chinmaylokesh.wordpress.com/2011/03/01/order-statistics-general-find-the-kth-smallest-element-from-an-unsorted-array-in-linear-time-specific-find-median-of-unsorted-array-in-linear-time/
 * 
 */
import java.util.Random;

public class Quickselect {

/* Function Descriptions: contains descriptions for all functions in this class
	 * 
	 * swap(): call to swap method in Swap.java 
	 * getNumberOfComparisons(): returns the number of comparisons
	 * randomPartition(): partitions the array passed on the kth-value
	 * randomSelection(): Uses the kth number to select a pivot and sort the array
	 * 
*/
	
	static Swap integerSwap = new Swap(); 
	public static final Random RAND = new Random(System.currentTimeMillis());
	private static int numOfComparisons = 0;
	
	//calls the swap methods from the Swap java class
	private static void swap(int A[], int pos1, int pos2) {
		integerSwap.swap(A, pos1, pos2);
	}
	
	public int getNumberOfComparisons() {
		return numOfComparisons;
	}
	
	private static int randomPartition(int[] A, int leftIndex, int rightIndex) {
			
		//create a pivot 
		int pivotIndex = leftIndex + RAND.nextInt(rightIndex - leftIndex);
		int pivotValue = A[pivotIndex];
		int counter = leftIndex - 1;

		//move the pivot to the back of the array
		swap(A, pivotIndex, rightIndex);  
		pivotIndex = rightIndex;
		
		//loop through and compare the values with the pivot
		for(int curr = leftIndex; curr<rightIndex; curr++) { 
			if(A[curr] <= pivotValue){
				numOfComparisons++;
				++counter;
				swap(A, counter, curr);
			}
		}
		++counter;
		swap(A,counter,pivotIndex);
		
		return ++counter;
		
	}
	
	public int randomSelection(int A[], int leftIndex, int rightIndex, int kthValue) {
		
		//Base Case
		if(leftIndex == rightIndex) {
			return A[leftIndex];
		}
		
		if(leftIndex < rightIndex) {
			int partition = randomPartition(A, leftIndex, rightIndex);
			int partitionIndex = partition - leftIndex + 1;  //select a random median based
			
			if(partitionIndex == kthValue) { //terminate the sort
				return partitionIndex; 
			}else if(kthValue <= partitionIndex) {
				//the first sub array is from the beginning of the subarray to the kthValue
				return randomSelection(A, leftIndex, partition - 1, kthValue);
			}else {
				//the second sub array is from the kthValue to the last index of the sub array
				return randomSelection(A, partition + 1, rightIndex, kthValue - partitionIndex);
			}
		}
		return kthValue;
	}
}

 