public class SortestCommonSuperSeq {
    public static int scsSequence(String s1, String s2, int s1len,int s2len, int [][]dp){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i==0 || j==0) {
                    dp[i][j]=0;
                }
                else if (s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[i][j]=1+dp[i-1][j-1];

                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return s1len+s2len-dp[s1len][s2len];
    }
    public static void main(String[] args) {
        String s1="aggtab";
        String s2="gxtxayb";
        int [][]dp=new int[s1.length()+1][s2.length()+1];
        System.out.println(scsSequence(s1, s2, s1.length(), s2.length(), dp));
    }
}
