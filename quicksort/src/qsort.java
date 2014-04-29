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
	
	Swap integerSwap = new Swap(); //creates a swap object from the swap class
	
	//calls the swap methods from the Swap java class
	private void swap(int A[], int pos1, int pos2) {
		integerSwap.swap(A, pos1, pos2);
		
	}
    
	//sorts the algorithm in O(n log n) time
    public void quicksort(int[] A, int pivotIndex, int rangeIndex) {
    	
    	//base case
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
    
    //Creates a partition and makes the necessary swaps based on the partition
    private int Partition(int A[], int pivotIndex, int rangeIndex) {
    	
    	//set the pivot element as the last element in the subarray
   	 	int pivot = A[rangeIndex];
   	 	int i = pivotIndex - 1;
   	 	
   	 	//places all elements of the array less than the pivot to the left of the pivot
   	 	for(int j = pivotIndex; j < rangeIndex; j++) {
   	 		if(A[j] <= pivot) {
   	 			i++;
   	 			swap(A, i, j);
   	 		}
   	 	}
   	 	swap(A, ++i, rangeIndex);  //changes the last element
   	 	return i++;
    }
    
   

}


