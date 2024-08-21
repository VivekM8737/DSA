import java.util.Scanner;

public class check2_p {

     public static void main(String[] args) {
        System.out.println("Enter the number: ");
        Scanner s = new Scanner(System.in);
        int x= s.nextInt();
        System.out.println((x&(x-1))==0);
     }
}