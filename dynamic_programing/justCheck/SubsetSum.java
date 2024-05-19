package justCheck;
public class SubsetSum{
    public static int checkSubset(int [] arr, int sum){
        int n=arr.length;
        int [][]t=new int[n+1][sum+1];
        for(int i=0; i<n+1;i++){
            for (int j = 0; j < sum+1; j++) {
                if(i==0){
                    t[i][j]=0;
                }   
                if(j==0){
                    t[i][j]=1;
                }   
            }
        }
        for(int i=1; i<n+1;i++){
            for (int j = 1; j < sum+1; j++) {
                if(arr[i-1]<=j){
                    if(t[i-1][j-arr[i-1]]==1){
                        t[i][j]=t[i-1][j-arr[i-1]];
                    }
                    else if(t[i-1][j]==1){
                        t[i][j]=t[i-1][j];
                    }
                    else if(t[i-1][j]==0){
                        t[i][j]=t[i-1][j];
                    }
                    
                }
                else{
                    t[i][j]=t[i-1][j];
                }   
                   
            }
        }
        
        return t[n][sum];
    }
    public static void main(String [] args){
        int [] arr={2,3,7,8,10};
        int sum=12;
        int x=checkSubset(arr, sum);
        if(x==1){
            System.out.println("Yes subset is present...");
        }
        else{
           System.out.println("No subset is not! present"); 
        }
        System.out.println("thanks for using me!");

    }
    
}