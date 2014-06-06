/*
 * Class Name: qsort.java
 * 
 * Programmer: Zuhayr Elahi
 * 
 * Runtime: Worst Case: O(n^2) Best Case and Average Case: O(n log n)
 * 
 * Description: This program performs quicksort where the partition is 
 * 				the last element in the array
 * 
 * References: Lecture 3
 */


public class qsort {
	

/* Function Descriptions: contains descriptions for all functions in this class
	 * 
	 * swap(): call to swap method in Swap.java 
	 * getNumberOfComparisons(): returns the number of comparisons
	 * quicksort(): sorts an array of integers recursively calling quicksort
	 * Partition(): partitions the array based on the pivot
	 * 
*/
	
	static Swap integerSwap = new Swap(); //class which contains the swap function
	static private int numOfComparisons = 0;
	
	private static void swap(int A[], int pos1, int pos2) {
		integerSwap.swap(A, pos1, pos2);
	}
	
	public int getNumberOfComparisons() {
		return numOfComparisons;
	}
	

    public void quicksort(int[] A, int pivotIndex, int rangeIndex) {
    	 
    	//Base Case
   	 	if(A == null || A.length == 1){
   	 		return;
   	 	}
   	 	
   	 	//recursively calls quicksort and partition to sort the array
   	 	if(pivotIndex < rangeIndex) {
   	 		int partition = Partition(A, pivotIndex, rangeIndex); //creates a partition to divide the array
   	 		quicksort(A, pivotIndex, partition - 1); //sort the first half of the array
   	 		quicksort(A, partition + 1, rangeIndex); //sort the second half of the array
   	 	}
  
    }
    
    protected static int Partition(int A[], int pivotIndex, int rangeIndex) {
    	
    	//set the pivot element as the last element in the subarray
   	 	int pivot = A[rangeIndex];
   	 	int i = pivotIndex - 1;
   	 	
   	 	//places all elements of the array less than the pivot to the left of the pivot
   	 	for(int j = pivotIndex; j < rangeIndex; j++) {
   	 		if(A[j] <= pivot) {
   	 			numOfComparisons++;
   	 			i++;
   	 			swap(A, i, j);
   	 		}
   	 	}
   	 	swap(A, ++i, rangeIndex);  
   	 	return i++;
    }
    
   

}


