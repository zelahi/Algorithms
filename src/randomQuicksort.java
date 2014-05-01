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
	
	Swap integerSwap = new Swap(); //creates a swap object from the swap class
	public static final Random RAND = new Random(1);
	
	//calls the swap methods from the Swap java class
	private void swap(int A[], int pos1, int pos2) {
		integerSwap.swap(A, pos1, pos2);
	}
	
	//wrapper function to count the number of comparisons
	private void compareCount() {
		integerSwap.comparisonCount();
	}
	
	//wrapper function to print the comparison count
	public int printNumOfCamparisons() {
		return integerSwap.printNumOfCamparisons();
    } 
	
	//quicksort using a random partition
	public long rQsort(int[] A, int begin, int end) {
    	final long startTime = System.nanoTime(); //start recording execution time

    	//base case
   	 	if(A == null || A.length == 0){
   	 		return 0;
   	 	}
   	 	
   	 	//recursively calls quicksort and partition to sort the array
   	 	if(begin < end) {
   	 		compareCount(); //increment everytime a comparison is made
   	 		int partition = rPartition(A, begin, end); //creates a partition to divide the array
   	 		rQsort(A, begin, partition - 1); //sort the first half of the array
   	 		rQsort(A, partition + 1, end); //sort the second half of the array
   	 	}
   	 	
   	 final long endTime = System.nanoTime();  //record time it stops running
   	 return endTime - startTime;  //return the duration of the program
    }
	
	//creates a random partition for each subarray
	protected int rPartition(int A[], int left, int right) {
		
		//startIndex at the leftmost value in the array and end at the rightmost value in each array
		int startIndex= left; 
		int end = right;
		
		//create a random pivot that lies in the array
		int pivotIndex = startIndex + RAND.nextInt(right - left); 
		int pivot = A[pivotIndex];
		
		swap(A, pivotIndex, end); //move the pivotIndex to the back 
		
		//compares currently selected value with the pivot
		for(int i = left; i < right; i++){
			if(A[i] <= pivot){
				swap(A, i, startIndex); //move the value to the left of the pivot
				startIndex++;
			}
		}
		swap(A,right, startIndex); //moves the larger element towards the right of the pivot
		return startIndex;
	}
}
