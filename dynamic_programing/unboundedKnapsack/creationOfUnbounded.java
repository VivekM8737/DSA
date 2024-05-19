// It is also know as road cutting problem;
public class creationOfUnbounded {
    public static int unBounded(int [] arr,int []val,int cap){
        int [][]dp=new int[arr.length+1][cap+1];
        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < cap+1; j++) {
        //         dp[i][j]=-1;
        //     }
        // }
        for(int i=0;i<dp.length;i++){
            for (int j = 0; j < cap+1; j++) {
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else if(arr[i-1]<=j){
                    dp[i][j]=Math.max(dp[i-1][j],val[i-1]+dp[i][j-arr[i-1]]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
                
            }
        }
        return dp[arr.length][cap];

    }
    public static void main(String[] args) {
        int [] wt={1,3,4,5};
        int[] val={1,4,5,7};
        int capacity=13;
        System.out.println(unBounded(wt,val, capacity));
    }
}
