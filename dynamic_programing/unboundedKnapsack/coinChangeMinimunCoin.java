public class coinChangeMinimunCoin {
    public static int miniCoin(int [] arr, int sum){
             
        int [][] dp= new int[arr.length+1][sum+1];
        
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i==0) {
                    dp[i][j]=Integer.MAX_VALUE;
                    
                }
                if (j==0) {
                    dp[i][j]=0;
                }
                
            }
            
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr[i-1]<=j) {
                    dp[i][j]=dp[i-1][j]+dp[i][j-arr[i-1]];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
            
        }
        
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i][sum]!=0) {
                return i;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int []arr={1,2,3};
        int sum=5;
        System.out.println(miniCoin(arr, sum));
    }
}
