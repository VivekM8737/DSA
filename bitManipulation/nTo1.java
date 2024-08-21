import java.util.Scanner;

public class nTo1 {

    public static int solutionBySir(long x) {
        int c=0;
        while (x!=1) {
            if (x%2==0) {
                x=(x>>1);
            }
            else if ((x&3)==1) {
                x=x-1;
            }
            else if ((x&3)==3) {
                x=x+1;
            }
            else if (x==3) {
                x=x-1;
            }
            c++;
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        System.out.println("Enter the number: ");
        int x=s.nextInt();
        System.out.println("By sir:"+solutionBySir(x));
        
    }
}
