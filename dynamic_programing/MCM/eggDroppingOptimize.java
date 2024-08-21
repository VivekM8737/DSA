public class eggDroppingOptimize {
    public static int minimumAtamedInWorstCase(int egg,int flor,int [][]dp){
        if (flor==0|| flor==1) {
            return flor;
        }
        if (egg==1) {
            return flor;
        }
        if (dp[egg][flor]!=-1) {
            return dp[egg][flor];
        }
        int mn=Integer.MAX_VALUE;
        for (int i = 1; i <= flor; i++) {
            int low;
            int high;
            if (dp[egg-1][i-1]!=-1) {
                low=dp[egg-1][i-1];
            }else{
                low=minimumAtamedInWorstCase(egg-1, i-1,dp);
                dp[egg-1][i-1]=low;

            }
            if(dp[egg][flor-i]!=-1  ){
                high=dp[egg][flor-i];
            }else{
                high=minimumAtamedInWorstCase(egg, flor-i,dp);
                dp[egg][flor-i]=high;

            }

            int temp=1+Math.max(low, high);
            mn=Math.min(mn, temp);
        }
        dp[egg][flor]=mn;
        return mn;
    }
    public static void main(String [] args ){
        int egg=3;
        int flor=5;
        int [][] dp =new int[egg+1][flor+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;
            }
        }
        System.out.println(minimumAtamedInWorstCase(egg, flor, dp));
    }
}
