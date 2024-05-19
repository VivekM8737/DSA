public class LCSubString {    
    public static int lcsString(String a, String b,int alen,int blen,int [][]dp){
        int result=0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <dp[0].length; j++) {
                if (i==0 || j==0) {
                    dp[i][j]=0;
                    
                }
                else{
                    if (a.charAt(i-1)==b.charAt(j-1)) {
                        dp[i][j]=dp[i-1][j-1]+1;
                        result=Math.max(dp[i][j], result);
                    }
                    else{
                        dp[i][j]=0;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String s1="abcde";
        String s2="ababcde";
        int [][] dp= new int[s1.length()+1][s2.length()+1];
        System.out.println(lcsString(s1, s2,s1.length(), s2.length(),dp));
    }
}
