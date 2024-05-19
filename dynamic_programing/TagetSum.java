public class TagetSum {
    public static int findSunset(int [] wt,int sum){
        int [][]dp=new int[wt.length+1][sum+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
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
                  if (wt[i-1]<=j) {
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-wt[i-1]];
                  } 
                  else{
                        dp[i][j]=dp[i-1][j];
                  }             
            }
            
        }
        return dp[wt.length][sum];
    }
    public static int taget_sum(int []wt){
        int sumarr=0;
        for (int i = 0; i < wt.length; i++) {
            sumarr+=wt[i];
        }
        int s1=(sumarr+1)/2;
        int res=findSunset(wt, s1);
        return res;
    }
    public static void main(String[] args) {
        int[] wt={1,1,2,3};
        System.out.println(taget_sum(wt));
    }
}

