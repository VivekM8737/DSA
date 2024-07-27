import java.util.Scanner;

public class josheofProblem {
    public static int power(int x){
        int i=1;
        while(i*2<=x){
            i*=2;
        }
        return i;
    }
    public static void main(String[] args) {
        System.out.println("Enter the number: ");
        Scanner s = new Scanner(System.in);
        int x=s.nextInt();
        int l=x-power(x);

        System.out.println(2*l+1);
    }
}
