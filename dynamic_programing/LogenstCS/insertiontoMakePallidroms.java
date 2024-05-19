public class insertiontoMakePallidroms {
    public static int NoOfinsetion(String s1, int s1len, int [][]dp){
        String s2="";
        for (int i = s1.length()-1;i>=0; i--) {
            s2+=s1.charAt(i);
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else{
                    if (s1.charAt(i-1) == s2.charAt(j-1)) {
                        dp[i][j]=1+dp[i-1][j-1];
                    }
                    else{
                        dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
        return s1len-dp[s1len][s1len];
    }
    public static void main(String[] args) {
        String a="agbcba";
        int [][]dp=new int[a.length()+1][a.length()+1];
        System.out.println(NoOfinsetion (a, a.length(), dp));
    }
}
