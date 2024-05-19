public class partitionforPalildroms {
    public static boolean isPalidroms(String s1){
        String s2="";
        for (int i = s1.length()-1; i >=0 ; i--) {
            s2+=s1.charAt(i)+"";
        }
        int [][] dp=new int[s1.length()+1][s1.length()+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i==0|| j==0) {
                    dp[i][j]=0;
                }
                else{
                    if (s1.charAt(i-1)==s2.charAt(j-1)) {
                        dp[i][j]=1+dp[i-1][j-1];
                    }
                    else{
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
        }
        if (dp[s1.length()][s1.length()]==s1.length()) {
            return true;
        } 
        return false;
    }
    public static int requirePartition(String s,int i , int j){
        if (i>=j) {
            return 0;
        }
        if (isPalidroms(s)) {
            return 0;
        }
        int min=Integer.MAX_VALUE;
        for (int j2 = i; j2 <j; j2++) {
            int temp=1+requirePartition(s, i, j2)+requirePartition(s, j2+1, j);
            min=Math.min(min, temp);
        }
        return min;
    }
    public static void main(String[] args) {
        String s="abab";
        System.out.println(requirePartition(s, 0, s.length()-1));
        System.out.println(isPalidroms(s));
    }
}
