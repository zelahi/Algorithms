public class KnapSack_01 {

	/* Variable Declarations
	 * int W: the maximum weight the knapsack can hold
	 * int[] wt: An array containing the weights of each item
	 * int[] val: An array containing the value of each item
	 * int n: Size of the arrays
	 * 
	 */
	public static int knapSack(int W, int[] wt, int[] val, int n) {
		
		int[][] Knapsack = new int[n+1][W+1];
		
		//Build table K[][] bottom up
		for(int i=0;i < n;i++){
			for(int w=0; w <= W; w++){
				if(i==0 || w== 0){
					Knapsack[i][w]=0;
				} else if(wt[i-1]<=w){
					Knapsack[i][w] = Math.max(val[i-1]+Knapsack[i+1][w-wt[i-1]], Knapsack[i-1][w]);
				} else {
					Knapsack[i][w] = Knapsack[i-1][w];
				}
			}
		}
		return Knapsack[n][W];
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] val = {60,100,120};
		int[] wt = {10,20,30};
		int W = 50;
		System.out.println("Maximum value of the knapsack is:" + knapSack(W,wt,val,val.length));

	}

}
