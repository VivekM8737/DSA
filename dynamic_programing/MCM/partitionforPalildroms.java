public class partitionforPalildroms {
    public static boolean isPalidroms(String s,int l, int m){
        if (l>=m) {
            return true;
            
        }
        while (l<=m) {
            if (s.charAt(l)!=s.charAt(m)) {
                return false;
            }
            l++;
            m--;
        }
        return true;
    }
    public static int requirePartition(String s,int i , int j,int [][]dp){
        if (i>=j) {
            return 0;
        }
        if (dp[i][j]!=-1) {
            return dp[i][j];
        }
        if (isPalidroms(s,i,j)) {
            return 0;
        }
        int min=Integer.MAX_VALUE;
        for (int j2 = i; j2 <j; j2++) {
            int left=0;
            int right=0;
            if (dp[i][j2]!=-1) {
                left=dp[i][j2];
            }
            else{
                left=requirePartition(s, i, j2,dp);
            }
            if (dp[j2+1][j]!=-1) {
                right=dp[j2+1][j];
            }
            else{
                right=requirePartition(s, j2+1, j,dp);
            }
            int temp=1+left+right;
            min=Math.min(min, temp);
        }
        dp[i][j]=min;
        return min;
    }
    public static void main(String[] args) {
        String s="abab";
        int [][] dp=new int[s.length()+1][s.length()+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;                
            }
        }
        System.out.println(requirePartition(s, 0, s.length()-1,dp));
        System.out.println(isPalidroms(s,0,s.length()-2));
    }
}
