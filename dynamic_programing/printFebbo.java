import java.util.Scanner;

public class printFebbo{
    public static int febboNormal(int x){
        if(x==0 || x==1){
            return x;
        }
        // here it run multiple time for same computation so we can save those result and reuse if it call again!!!
        System.out.println("hello"+x);
        int feb1=febboNormal(x-1);
        int feb2=febboNormal(x-2);
        return feb1+feb2;
    }
    public static int febbodp(int x, int[] dp){
        if(x==0 || x==1){
            return x;
        }
        if(dp[x]!=0){
            return dp[x];
        }
        // Now you can see that for same computation we don't do the computation again!!!
        System.out.println("hello dp"+x);
        int feb1=febbodp(x-1,dp);
        int feb2=febbodp(x-2,dp);
        dp[x]=feb1+feb2;
        return dp[x];
    }


    public static int febbodp2(int x,int [] dp){
        if (x==1 || x==0) {
            return x;
        }
        if (dp[x]!=0) {
            return dp[x];
        }

        int feb1=febbodp2(x-1, dp);
        int feb2=febbodp2(x-2, dp);
        dp[x]=feb1+feb2;
        return dp[x];
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the number: ");
        int x=s.nextInt();
        System.out.println(febboNormal(x));
        System.out.println(febbodp(x,new int[x+1]));
        System.out.println(febbodp2(x,new int[x+1]));

    }
}