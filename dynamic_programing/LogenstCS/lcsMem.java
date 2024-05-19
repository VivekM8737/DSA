class lcsMem{
    public static int lcs(String s1,String s2,int [][] dp,int s1len,int s2len){
        if (s1len==0 || s2len==0) {
            return 0;
        }
        if (dp[s1len][s2len]!=-1) {
            return dp[s1len][s2len];
        }
        else{
            if (s1.charAt(s1len-1)==s2.charAt(s2len-1)) {
                dp[s1len][s2len]=1+lcs(s1, s2, dp,s1len-1,s2len-1);
                return dp[s1len][s2len];
                
            }
            else{
                dp[s1len][s2len]=Math.max(lcs(s1, s2, dp,s1len,s2len-1),
                lcs(s1, s2, dp,s1len-1,s2len));
                return dp[s1len][s2len];

                
            }
        }
        
    }
    public static int lcs1(String s1,String s2,int [][] dp,int s1len,int s2len){
        for (int i = 1; i < dp.length; i++) {
             for (int j = 1; j < dp[0].length; j++) {
                
                 if(s1.charAt(i-1)==s2.charAt(j-1)){
                     dp[i][j]=1+dp[i-1][j-1];
                 }
                 else{
                     dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                 }
             
             }
         }
         return dp[s1len][s2len];
         
         
     }
   
    public static void main(String[] args) {
        String s1="abcfgde";
        String s2="abfgd";
        int [][] dp= new int[s1.length()+1][s2.length()+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=0;
            }
        }
        System.out.println(lcs1(s1, s2, dp, s1.length(), s2.length()));
    }
}