/* Class Name: randomQuicksort.java
 * 
 * Programmer: Zuhayr Elahi
 * 
 * Runtime: O(1)
 * 
 * Description:  This class contains functions that are used by every version of quicksort
 * 
 */

public class Swap {
	
	//keep track of the number of comparisons made in quicksort
	int numOfComparisons = 0;
	
	 //swaps two elements in the array
    protected void swap(int A[], int pos1, int pos2) {
    	if(pos1 != pos2){  //checks to ensure the two positions are not the same
   	 		int temp = A[pos2];
   	 		A[pos2] = A[pos1];
   	 		A[pos1] = temp;
    	}
    }
    
    //function to keep a count of the number of comparisons
    protected void comparisonCount() {
    	numOfComparisons ++;
    }
    
    //returns the number of comparisons
    public int printNumOfCamparisons() {
    	return numOfComparisons;
    }

}
