
public class qsortTail extends qsort {
	
	public void tailRecursiveQuicksort(int[] Array, int pivotIndex, int rangeIndex) { 
		
		if(rangeIndex == 1 || Array.length == 1) {
			return;
		}
		
		while(pivotIndex < rangeIndex) {
			//partition and sort left subarray
			int partition = Partition(Array, pivotIndex, rangeIndex);
			tailRecursiveQuicksort(Array, pivotIndex, partition-1);
			pivotIndex = partition + 1;
		}
	}
}
