import java.util.Scanner;
import java.math.*;

public class decimaltoAntBase {
    public static int binary(int n1, int base){
        int rv=0;
        int x=n1;
        double p=0;
        for (int i = 1; i <= n1; i++) {
            int y=x%base;
            x/=base;
            rv+=y*Math.pow(10,p);
            p++;
            if(x==0){
                break;
            }
        }
        
        return rv;
    }
    public static void main(String[] a){
        System.out.print("Enter the decimal number:" );
        Scanner s =new Scanner(System.in);
        int x= s.nextInt();
        System.out.print("Enter the base to conver: " );
        int base= s.nextInt();
        System.out.println(binary(x ,base));

    }
}
