
public class maintest {

		
		static int[] testArray = {2,1,3, 5, 30, 0};
		static qsort sortTest1 = new qsort();
		static randomQuicksort sortTest2 = new randomQuicksort();
		
	public static void main(String[] args) {
		/*sortTest1.quicksort(testArray, 0, testArray.length-1);
		for(int i=0; i < testArray.length; i++) 
			System.out.print(testArray[i] + " ");  */
	
	sortTest2.rQsort(testArray, 0, testArray.length-1);
	for(int i=0; i < testArray.length; i++) 
		System.out.print(testArray[i] + " "); 

	}
	

}
