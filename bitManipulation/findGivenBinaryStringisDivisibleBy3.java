import java.util.Scanner;

public class findGivenBinaryStringisDivisibleBy3 {
    // here you have a binary string (1001011010110) you have to check that is it divisible by 3?
    // solution
    // binary of 3 = 11 so if binary string is divisible by 11 then it is divisible by 3
    // if sum of  bit of even places == sum of bit of odd places the it divisible by 11
    //  mean (10101101) even =1+1+0+0 odd= 0+1+1+1 if even-odd)%11=0 then it is divisibly by 11;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String binaryString=s.nextLine();
        int even=0;
        int odd=0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (i%2==0) {
                even+=binaryString.charAt(i)+'0';  // here we change character to integer (char)1+'0'=int 1
            }
            else{
                odd+=binaryString.charAt(i)+'0';
            }

        }
        if ((even-odd)%11==0) {
            System.out.println("yes");
        }
        else{System.out.println("no");}
    }
}
