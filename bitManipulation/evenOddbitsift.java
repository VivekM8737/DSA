import java.util.Scanner;

public class evenOddbitsift {
    public static void main(String[] args) {
        // int max1=0b10101010101010101010101010101010;
        int max1=0xAAAAAAAA;

        // int max2=0b01010101010101010101010101010101;
        int max2=max1>>1;
        
        System.out.println("Enter the num: ");
        Scanner s = new Scanner(System.in);
        int x=s.nextInt();

        int even=(x&max2);

        int odd=(x&max1);
        even=(even<<1);
        odd=(odd>>1);
        x=(even|odd);
        System.out.println(x);

    }
    
}