/* Class Name: randomQuicksort.java
 * 
 * Programmer: Zuhayr Elahi
 * 
 * Runtime: Worst Case - O(n2), Best Case - O(log n), Average Case - O(log n)
 * 
 * Description:  runs quicksort based on a randomly selected partition.
 * 
 * References: http://en.wikibooks.org/wiki/Algorithm_Implementation/Sorting/Quicksort#Java
 * 				professorjava.weebly.com/quicksort.html
 */

import java.util.Random;

public class randomQuicksort {
	
/* Function Descriptions: contains descriptions for all functions in this class
	 * 
	 * swap(): calls swap method in Swap.java
	 * getNumberOfComparisons(): returns the number of comparisons
	 * rQsort(): sorts an array based on a partition
	 * rPartition(): partitions the array based on a random pivot
	 * 
*/
	
	Swap integerSwap = new Swap(); 
	public static final Random RAND = new Random(System.currentTimeMillis());
	static private int numOfComparisons = 0;
	
	public int getNumberOfComparisons() {
		return numOfComparisons;
	}
	
	private void swap(int A[], int pos1, int pos2) {
		integerSwap.swap(A, pos1, pos2);
	}
	
	public void rQsort(int[] A, int leftIndex, int rightIndex) {

    	//base case
   	 	if(A == null || A.length == 0){
   	 		return;
   	 	}
   	 	
   	 	//recursively calls quicksort and partition to sort each sub array
   	 	if(leftIndex < rightIndex) {
   	 		int partition = rPartition(A, leftIndex, rightIndex); 
   	 		rQsort(A, leftIndex, partition - 1); 
   	 		rQsort(A, partition + 1, rightIndex); 
   	 	}
    }
	

	protected int rPartition(int A[], int left, int right) {
		
		
		int startIndex= left; 
		int rightIndex = right;
		
		//create a random pivot 
		int pivotIndex = startIndex + RAND.nextInt(right - left); 
		int pivot = A[pivotIndex];
		
		swap(A, pivotIndex, rightIndex); //move the pivotIndex to the back 
		
		//compares each value with the pivot and sorts accordingly
		for(int i = left; i < right; i++){
			if(A[i] <= pivot){
				numOfComparisons++;
				swap(A, i, startIndex); //move the value to the left of the pivot
				startIndex++;
			}
		}
		swap(A,right, startIndex); //moves the larger element towards the right of the pivot
		return startIndex;
	}
}
