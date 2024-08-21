import java.util.Scanner;

public class find7nB8 {
    public static void main(String[] args) {
        // find  7n/8 without divide and multiplication
        // now 7n = 8n-n
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value of N :");
        int n=s.nextInt();
        int x=((1<<3)*n-n)>>3;// here its just return the integer part left the desimal path
        System.out.println(x);
    }
}
