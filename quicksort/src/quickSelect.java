import java.util.Random;

/* Class Name: quickselect.java
 * 
 * Programmer Name: Zuhayr Elahi
 * 
 * Description: Quickselect algorithm which selects the Kth element from a list in linear time
 * 				It selects a random element from the list as, and places every item smaller 
 * 				than the pivot to the right of the pivot and the larger elements are placed on
 * 				the left.  
 * 
 * Runtime: Worst Case - O(n^2) Best Case: O(n) Average Case: O(n)
 * 
 * References: http://rosettacode.org/wiki/Quickselect_algorithm#Java
 * 			   blog.teamlead.net.com/2012/07/quick-select-algorithm-find-kth-element.html
 * 
 */

public class quickSelect {
	
	Swap integerSwap = new Swap(); //creates a swap object from the swap class
	public static final Random RAND = new Random(1);
	
	//calls the swap methods from the Swap java class
	private static void swap(int A[], int pos1, int pos2) {
		integerSwap.swap(A, pos1, pos2);
		
	}
	
	private static int partition(int[] A, int start, int last, int pivotIndex) {
		
		//set the pivot and move it to the back of the array
		int pivot = A[pivotIndex]; 
		swap(A, pivot, last);
		
		int index = start;
		
		//loops through and swaps the element to set the pivot
		for(int i = start; i < last; i++) {
			if(A[i] <= pivot) {
				swap(A, i, index);
				index++;
			}
		}
		swap(A, last, index);
		return index;
	}

}
