/* Class Name: TestBench.java
 * 
 * Programmer: Zuhayr Elahi
 * 
 * Description: This function tests the three different implementations of quicksort.
 * 				It then returns the number of comparisons made and the execution time
 * 				of each algorithm.
 */

import java.util.Random;
import java.util.Scanner;

public class TestBench {
	
/* Function Descriptions: contains a description of all function in this class.
 * 						  All test functions return the number of comparisons
 * 						  and execution time.
 * 
 * Set up test environment with:
 * 	getStartTime(): retrieves the time when the algorithm started
 * 	getEndTime(): retrieves when the algorithm ended
 * 	randomArray(): creates an array and fills it with random integers
 * 
 * The following functions test the different implementations of quicksort:
 * 	quicksortTest(): tests qsort.java
 * 	randomQuicksortTest(): tests randomQuicksort.java
 * 	quickSelectTest(): tests Quickselect.java
 * 	printArraySize(): prints the array size
 * 	isSorted(): checks to see if the array is sorted
 * 	checkIfArrayIsSorted():  Prints True or false to console to indicate if the array is sorted
 * 	
*/
	static long elapsedTime, startTime, endTime;
	
//The following functions listed below are used to set up the test enviornment
	public static long getStartTime() {
		long startTime = System.nanoTime();
		return startTime;
	}
	    
    public static long getEndTime() {
    	long endTime = System.nanoTime();
    	return endTime;
    }
    
    public static void printArraySize(int[] Array) {
    	System.out.println("Array Size = " + Array.length);
    }
	    
	public static int[] randomArray() {
		Random numbers = new Random();
		
		Scanner inputArraySize = new Scanner(System.in);
		int arraySize = 0;
		
		//Reads in User input to create an array of the requested size
		System.out.println("Enter an array size:");
		arraySize = inputArraySize.nextInt();

		int A[] = new int[arraySize];
		//fills the array with random integers
		for(int i = 0; i < arraySize; i++){
			   A[i] = numbers.nextInt(arraySize) + 1;
			}
		return A;
	}
	
	private static boolean isSorted(int[] integerArray) {
		boolean sorted = true;
		
		//loop through and check if the array is sorted
		for (int counter = 0; counter < integerArray.length - 1; counter++) {
		    if (integerArray[counter] > integerArray[counter+1]) {
		        sorted = false;
		        break;
		    }
		}
		return sorted;
	}
	
	public static void checkIfArrayIsSorted(int[] integerArray) {
		boolean sorted = isSorted(integerArray);
		if (sorted == false){ //prints if array is sorted
			System.out.println("Array is not sorted");
		}else {
			System.out.println("Array is sorted");
		}
	}

//The functions listed bellow are for testing the three different sorting implementations
	public static void quicksortTest(int[] integerArray) {
		qsort sortTest = new qsort();

		//Test for quicksort
		startTime = getStartTime();
		sortTest.quicksort(integerArray, 0, integerArray.length-1);
		endTime = getEndTime();
		
		//return the information requested for Quicksort
		int ComparisonCount = sortTest.getNumberOfComparisons();
		System.out.println("Quicksort Results:");
		System.out.println("Number of comparisons = " + ComparisonCount);
		elapsedTime = endTime - startTime;
		System.out.println("Time to execute quicksort = " + elapsedTime + " ns");
		checkIfArrayIsSorted(integerArray);
	}
	
	public static void randomQuicksortTest(int[] integerArray) {
		 randomQuicksort sortTest = new randomQuicksort();
		 
		//Test for random Quicksort
		startTime = getStartTime();
		sortTest.rQsort(integerArray, 0, integerArray.length-1);
		endTime = getEndTime();
		
		//return the information requested for Random Quicksort
		int ComparisonCount = sortTest.getNumberOfComparisons();
		System.out.println("Random Quicksort Results:");
		System.out.println("Number of comparisons = " + ComparisonCount);
		elapsedTime = endTime - startTime;
		System.out.println("Execution Time:" + elapsedTime + " ns");
		checkIfArrayIsSorted(integerArray);
	}
	
	public static void quickSelectTest(int[] integerArray) {
		Quickselect sortTest = new Quickselect();
		int kthValue = integerArray.length/2;
		
		//Test for random Quickselect
		startTime = getStartTime();
		sortTest.randomSelection(integerArray, 0, integerArray.length-1, kthValue);
		endTime = getEndTime();
		
		//return the information requested for Quickselect
		int ComparisonCount = sortTest.getNumberOfComparisons();
		System.out.println("Quickselect Results:");
		System.out.println("Number of comparisons = " + ComparisonCount);
		elapsedTime = endTime - startTime;
		System.out.println("Execution Time:" + elapsedTime + " ns");
		checkIfArrayIsSorted(integerArray);
	}
	
	public static void insertionSortTest(char[] myArray) {
		InsertionSort sortTest = new InsertionSort();
		sortTest.insertionsort(myArray);
		int ComparisonCount = sortTest.getNumberOfComparisons();
		System.out.println("Number of comparisons = " + ComparisonCount);

	}
	
	public static void qsortTailTest(int[] myArray) {
		qsortTail sortTest = new qsortTail();
		
		sortTest.tailRecursiveQuicksort(myArray, 1, myArray.length);
		for(int i = 0; i < myArray.length-1; i++) {
			System.out.print(myArray[i] + " ");
		}
	}

		
	public static void main(String[] args) {
		int[] integerArray = randomArray();  //create the random integer array
		char[] myArray = {'C','R','A','Z','Y','Q','U','E','S','T','I','O','N'};
		int[] testArray = {10,9,3,5,76,12};
		
		//printArraySize(integerArray);
		
		//insertionSortTest(myArray);
		qsortTailTest(testArray);
		//quicksortTest(integerArray);	
		//randomQuicksortTest(integerArray);
		//quickSelectTest(integerArray);	
	}
}