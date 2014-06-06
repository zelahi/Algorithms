import java.util.Random;

public class maintest {

		static int k = 5; //kth value to be entered into the array
		
		static qsort sortTest1 = new qsort();
		static randomQuicksort sortTest2 = new randomQuicksort();
		static Quickselect sortTest3 = new Quickselect();
		
		
	public static int[] randomArray() {
		Random numbers = new Random();
		
		//create an array to test sorting
		int arraySize = 100000000;
		int A[] = new int[arraySize];
		
		for(int i = 0; i < arraySize; i++){
			   //random numbers from 1 to 100
			   A[i] = numbers.nextInt(arraySize) + 1;
			}
		return A;
	}
	
	static int[] testArray = randomArray();
		
	public static void main(String[] args) {
		
		//return duration and number of comparisons for quicksort
		System.out.println("Total Execution Time for quicksort = " + sortTest1.quicksort(testArray, 0, testArray.length-1));
		System.out.println("Total Number of comparisons = " + sortTest1.printNumOfCamparisons()); 
		
		//return duration and number of comparisons for random quicksort
		System.out.println("Total Execution Time for quicksort = " + sortTest2.rQsort(testArray, 0, testArray.length-1));
		System.out.println("Total Number of comparisons = " + sortTest2.printNumOfCamparisons()); 

	}
}