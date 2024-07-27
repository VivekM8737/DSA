import java.util.Scanner;

public class RightMostSetBitMask {
    public static int D2B(int x){
        String b="";

        while(x>0){
            int t=x%2;
            String t1=""+t;
            t1+=b;
            b=t1;
            x/=2;
        }
        
        return Integer.parseInt(b);
    }
    public static void main(String[] args) {
        System.out.println("Enter the number: ");
        Scanner s=new Scanner(System.in);
        int x=s.nextInt();
        int c_2=(x&(-x));

        System.out.println(c_2);
        System.out.println("Binary of: "+x+" is "+D2B(x));
        System.out.println("Mask is: "+(c_2)+" and in Binary: "+D2B(c_2));




    }
}
