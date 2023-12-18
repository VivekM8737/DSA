import java.util.Scanner;

public class countStairPath {
    public static int path(int x){
        if(x==0){
            return 1;
        }
        if(x<0){
            return 0;
        }
        int p1=path(x-1);
        int p2=path(x-2);
        int p3=path(x-3);
        return p1+p2+p3;
    }
    // memoization way...
    public static int pathdp(int x,int[]dp){
        if(x==0){
            return 1;
        }
        if(x<0){
            return 0;
        }
        if(dp[x]!=0){
            return dp[x];
        }
        int p1=path(x-1);
        int p2=path(x-2);
        int p3=path(x-3);
        dp[x]=p1+p2+p3;
        return dp[x];
    }
    public static int pathdp2(int x,int dp[]){
        dp[0]=1;
        for (int i = 1; i <= x; i++) {
            if(i==1){
                dp[i]=dp[i-1];
            }
            else if(i==2){
                dp[i]=dp[i-1]+dp[i-2];
            }
            else{
                dp[i]=dp[i-2]+dp[i-1]+dp[i-3];
            }
        }
        return dp[x];
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the number of stairs: ");
        int x=s.nextInt();
        System.out.println(path(x));
        System.out.println(pathdp(x,new int[x+1]));
        System.out.println(pathdp2(x,new int[x+1]));
    }
}
