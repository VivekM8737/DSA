
public class countSumSubset {
    public static int countSubset(int[] wt, int sum, int [][]dp){
        int n=wt.length;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i==0){
                    dp[i][j]=0;
                }

                if (j==0) {
                    dp[i][j]=1;
                    
                }
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(wt[i-1]<=j){
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-wt[i-1]];
                }  
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    
    public static void main(String[] args) {
        int [] wt={2,3,7,8,10};
        int sum=10;
        int dp[][]=new int[wt.length+1][sum+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=0;   
            }
        }
        
        System.out.println(countSubset(wt, sum, dp));
        }
}