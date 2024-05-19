public class repeatedLCS {
    public static int repLCS(String s1,int s1len, int [][]dp){
        String s2=s1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (i==0 || j==0) {
                    dp[i][j]=0;
                }
                else if (s1.charAt(i-1)==s2.charAt(j-1) && i!=j) {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[s1len][s1len];
    } 
    public static void main(String[] args) {
        String s="AABEBCDD";
        int [][] dp = new int[s.length()+1][s.length()+1];
        System.out.println(repLCS(s, s.length(), dp));
    }
}
