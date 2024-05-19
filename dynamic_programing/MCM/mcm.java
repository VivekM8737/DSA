public class mcm{

    public static int minimumMultiplication(int[] arr,int i,int j,int [][]dp ){
        if(i>=j){
            return 0;
        }
        if (dp[i][j]!=-1) {
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int temp=minimumMultiplication(arr, i, k,dp)+minimumMultiplication(arr, k+1, j,dp)+(arr[i-1]*arr[k]*arr[j]);
            if (temp<min) {
                min=temp;
            }
        }
        dp[i][j]=min;
        return min;

    }
    public static void main(String[] args) {
        int []arr={10,20,30,40};
        int [][] dp=new int[arr.length+1][arr.length+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j]=-1;
            }
            
        }
        System.out.println(minimumMultiplication(arr, 1, arr.length-1,dp ));
    }
}