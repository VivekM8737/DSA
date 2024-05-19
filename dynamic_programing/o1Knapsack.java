public class o1Knapsack {

    public static int o1(int[] wt,int [] val,int capacity,int ind,int [][] dp){
        if (capacity==0  || ind==0) {
            return 0;
        }
        else if (dp[ind][capacity]!=-1) {
            return dp[ind][capacity];
        }
        else{
            if(wt[ind-1]<=capacity){

                dp[ind][capacity]=Math.max(val[ind-1]+o1(wt, val, capacity-wt[ind-1], ind-1,dp), o1(wt, val, capacity, ind-1,dp));
               return  dp[ind][capacity];
            }
            else{
                dp[ind][capacity]=o1(wt, val, capacity, ind-1,dp);
                return  dp[ind][capacity];
            }
        }
        
    }
    public static int o1knap(int [][] dp,int[] wt,int []val,int n,int capacity){
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < capacity+1; j++) {
                if (i==0 || j==0) {
                    dp[i][j]=0;
                }
                else if (wt[i-1]<=j) {
                    dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
                }
                else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[n][capacity];
    }
    public static void main(String[] args) {
        int [] wt={1,3,4,5};
        int[] val={1,4,5,7};
        int capacity=13;
        int [][] dp=new int[wt.length+1][capacity+1];
        for (int i = 0; i < val.length+1; i++) {
            for (int j = 0; j < capacity+1; j++) {
                dp[i][j]=-1;
            }
        }
        System.out.println(o1(wt, val, capacity,wt.length,dp));
        for (int i = 0; i < val.length+1; i++) {
            for (int j = 0; j < capacity+1; j++) {
                dp[i][j]=-1;
            }
        }
        System.out.println(o1knap(dp, wt, val, wt.length, capacity));
        
    }
}
