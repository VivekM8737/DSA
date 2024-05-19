public class printSCS {
    public static String scs(String s1,String s2, int s1len,int s2len, int [][] dp){
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
        String res="";
        while (i>0 && j>0) {
            if (s1.charAt(i-1)==s2.charAt(j-1)) {
                res+=s1.charAt(i-1);
                i--;j--;
            }
            else{
                if (dp[i][j-1]<dp[i-1][j]) {
                    res+=s1.charAt(i-1);
                    i--;
                }
                else{
                    res+=s2.charAt(j-1);
                    j--;
                }
            }
        }
        while (i>0) {
            res+=s1.charAt(i-1);
            i--;
        }
        while (j>0) {
            res+=s2.charAt(j-1);
        }
        System.out.println(res);
        String res_="";
        for (int k = res.length()-1; k >=0 ; k--) {
            res_+=res.charAt(k);
        }
        return res_;
    }
    public static void main(String[] args) {
        String s1="aggtab";
        String s2="gxtxayb";
        int [][]dp=new int[s1.length()+1][s2.length()+1];
        System.out.println(scs(s1, s2, s1.length(), s2.length(), dp));
    }
}
