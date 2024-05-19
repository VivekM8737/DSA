
public class equalSp {
    public static boolean subSetsum(int []wt,int sum,int n,boolean[][]dp){
        if (n<=0 && sum!=0){
            dp[n][sum]=false;
            return false;
        }
        if (sum==0 || dp[n][sum]==true) {
            dp[n][sum]=true;
            return true;
        }
        else{
            if (wt[n-1]<=sum) {
                // System.out.println("yes");
                dp[n][sum]=subSetsum(wt, sum-wt[n-1], n-1,dp) || subSetsum(wt, sum, n-1,dp);
                return dp[n][sum]; 
            }
            else{
                dp[n][sum]=subSetsum(wt, sum, n-1,dp);
                return dp[n][sum];
            }
        }
    }
    public static boolean subsetSum(int [] wt,int sum,boolean[][]dp){
        int n=wt.length;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i==0) {
                    dp[i][j]=false;
                }
                if (j==0) {
                    dp[i][j]=true;
                }
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                 if (wt[i-1]<=j) {
                    dp[i][j]=dp[i-1][j-wt[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[n][sum];

    }
    public static boolean eualSumPartition(int []wt,int sum,boolean[][]dp){
        int x=0;
        int n=wt.length;
        for (int i = 0; i < wt.length; i++) {
            x+=wt[i];
        }
        if (x%2==0) {
            return subSetsum(wt, sum, n, dp);
        }
        else{return false;}
    }
    public static void main(String[] args) {
        int [] wt={2,3,7,8,10};
        int sum=12;
        boolean dp[][]=new boolean[wt.length+1][sum+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=false;   
            }
        }

        System.out.println(subSetsum(wt, sum, wt.length,dp));
        System.out.println(subsetSum(wt, sum,dp));
        System.out.println(eualSumPartition(wt, sum, dp));
    }
}
