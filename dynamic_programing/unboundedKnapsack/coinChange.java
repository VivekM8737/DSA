public class coinChange {
    public static int coinChange_(int [] arr,int sum){
        int [][] dp = new int[arr.length+1][sum+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i==0) {
                    dp[i][j]=Integer.MAX_VALUE-1;
                }
                if(i>=1 && j==0){
                    dp[i][j]=0;
                }
                if (i==1 && j>0) {
                    if (j%arr[0]==0) {
                        dp[i][j]=j/arr[0];
                    }
                    else{
                        dp[i][j]=Integer.MAX_VALUE-1;
                    }
                }
            }
        }

        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr[i-1]<=j) {
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-arr[i-1]]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[arr.length][sum];
    }
    public static void main(String[] args) {
        int []arr={1,2,3};
        int sum=5;
        System.out.println(coinChange_(arr, sum));
    }
}
