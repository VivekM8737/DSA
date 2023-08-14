import java.util.Scanner;

public class digit {
    public static void main(String[] args) {
        System.out.println("Enter the num: ");
        Scanner s=new Scanner(System.in);
        int a=s.nextInt();
        int c=1;
        int w=a;
        for(int i=10; i<=a; i=i*10){
            c=c*10;
            // System.out.println(c);
        }
        for(int i=c; i>=1;i=i/10){
            int x=w/i;
            w=w%i;
            System.out.println(x);
        }
    }
}
