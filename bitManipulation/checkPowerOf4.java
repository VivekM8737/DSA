import java.util.Scanner;

public class checkPowerOf4 {
    public static void main(String[] args) {
        int m=0b01010101010101010101010101010101;
        // the binary of  4's power 100(4) or 10000(16) or 100000000(64) so all 1 come at even point if we find the m&number then it is always greater than 0 so first check that is no is power of 2 are not then do & operation so if both condition satisfy than it is power of 4..
        
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int x= s.nextInt();
        System.out.println( x>0 && (x&(x-1))==0 && (m&x)>0);
    }
}
