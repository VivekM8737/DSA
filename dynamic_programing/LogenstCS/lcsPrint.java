public class lcsPrint {

    public static String printlcs(String s1, String s2, int s1len, int s2len, int [][]dp){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i==0 || j==0) {
                    dp[i][j]=0;
                    
                }else{
                    if (s1.charAt(i-1)==s2.charAt(j-1)) {
                        dp[i][j]=1+dp[i-1][j-1];
                    }
                    else{
                        dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
    
        }
        int i=s1len;
        int j=s2len;
        String res_="";
        while (i>0 && j>0) {
            if (s1.charAt(i-1)==s2.charAt(j-1)) {
                res_+=s1.charAt(i-1);
                i--;j--;
            }else{
                if (dp[i-1][j]< dp[i][j-1]) {
                    j--;
                }else{
                    i--;
                }
            }
        }
        String res="";
        for (int k = res_.length()-1; k >=0 ; k--) {
            res+=res_.charAt(k);
        }
        return res;
    }
    public static void main(String[] args) {
        String s1="adbcfgde";
        String s2="abfgd";
        int [][] dp= new int[s1.length()+1][s2.length()+1];
        System.out.println(printlcs(s1, s2, s1.length(), s2.length(), dp));
    }
}
