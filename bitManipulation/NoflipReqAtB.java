import java.util.Scanner;

public class NoflipReqAtB {
    public static void main(String[] args) {
        System.out.println("Enter the value of A and B:");
        Scanner s = new Scanner(System.in);
        int a=s.nextInt();
        int b=s.nextInt();

        int m=(a^b);
        int c=0;
        while (m>0) {
            m=(m>>(m&(-m)));
            c++;
        }
        System.out.println(c);

    }
}
