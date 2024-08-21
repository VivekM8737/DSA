import java.util.Scanner;

public class findNoOfOnBits {
    static int ans;
    public static void count(int n){
        if (n<=0) {
            return;
        }
        int x=0;
        while ((1<<x)<=n) {
            x++;
        }
        x=x-1;
        ans+=((x*(1<<(x-1)))+n-(1<<(x))+1);
        count(n-(1<<(x)));

    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the number: ");
        int x=s.nextInt();
        ans=0;
        count(x);
        System.out.println(ans);

    }
}
