import java.util.ArrayList;

public class countSubsetGivenDiff {
    public static int subset(int []arr,int sum,int[][]dp){
        int n0=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==0) {
                n0+=1;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < sum+1; j++) {
                if (i==0) {
                    dp[i][j]=0;
                }
                if (j==0) {
                    dp[i][j]=1;
                }
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(arr[i-1] > j || arr[i-1] == 0){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-arr[i-1]];
                    
                }
            }
        }
        return  (int)Math.pow(2, n0) * dp[arr.length][sum] ;

    }
    public static int countMinSum(int []arr,int dff){
        int range=0;
        for (int i = 0; i < arr.length; i++) {
            range+=arr[i];
        }
        int [][] dp =new int[arr.length+1][range+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=0;   
            }
        }
        int s1=(dff+range)/2;
        int count=subset(arr, s1, dp);        
       return count;
    }
    public static void main(String[] args) {
        // int [] arr={1,2,7};
        int [] wt={0,0,0,0,0,0,0,0,1};
        int diff=1;
        System.out.println( countMinSum(wt, diff));
    }
}
