public class LongestPalildroms {
    public static int LPallidroms(String s1,int slen,int [][]dp){
        String s2="";
        for (int i = slen-1; i >=0; i--) {
            s2+=s1.charAt(i);
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i==0 || j==0) {
                    dp[i][j]=0;
                }
                else{
                    if (s1.charAt(i-1)==s2.charAt(j-1)) {
                        dp[i][j]=1+dp[i-1][j-1];
                    }
                    else{
                        dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
            
        }
        return dp[slen][slen];
    }
    public static void main(String[] args) {
        String a="agbcba";
        int [][]dp=new int[a.length()+1][a.length()+1];
        System.out.println(LPallidroms(a, a.length(), dp));

    }
}
