import java.util.Scanner;

public class anyBasToDe {
    public static int binary(int n1, int base){
        int rv=0;
        int x=n1;
        int p=1;
        while(x>0) {
            int y=x%10;
            x/=10;
            rv+=y*p;
            p*=base;
        }
        
        return rv;
    }
    public static void main(String[] a){
        System.out.print("Enter the at given base number:" );
        Scanner s =new Scanner(System.in);
        int x= s.nextInt();
        System.out.print("Enter the base of number: " );
        int base= s.nextInt();
        System.out.println(binary(x ,base));

    }
}
