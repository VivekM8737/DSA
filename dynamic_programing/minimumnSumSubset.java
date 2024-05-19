import java.util.ArrayList;

public class minimumnSumSubset {


    public static ArrayList<Integer> SubsetList(int []arr,int sum,boolean [][] dp){
        int n=arr.length;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i==0) {
                    dp[i][j]=false;
                }
                if (j==0) {
                    dp[i][j]=true;
                }

            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j>=arr[i-1]) {
                    dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }

            }
        }
        ArrayList<Integer> n1=new ArrayList<>();
        for (int i = 0; i <= sum/2; i++) {
                if (dp[n][i]) {
                    n1.add(i);
                }
        }
        return n1;
    }
    public static int countMinSum(int []arr){
        int range=0;
        for (int i = 0; i < arr.length; i++) {
            range+=arr[i];
        }
        boolean [][] dp =new boolean[arr.length+1][range+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=false;   
            }
        }
        ArrayList<Integer> x=SubsetList(arr, range, dp);
        int min=Integer.MAX_VALUE;
        // System.out.println(x);
        for (int i = 0; i < x.size(); i++) {
           min = Math.min(min,range-2*x.get(i));
        }
       return min;
    }
    public static void main(String [] args){
        int [] arr={1,2,7};
        System.out.println( countMinSum(arr));
        
    }
}

