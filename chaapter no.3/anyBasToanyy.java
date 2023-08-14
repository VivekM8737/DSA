import java.util.Scanner;

public class anyBasToanyy {
   
    public static int anyBasToDe(int n1, int bas1){
        int rv=0;
        int x=n1;
        double p=0;
        for (int i = 1; i <= n1; i++) {
            int y=x%10;
            x/=10;
            rv+=y*Math.pow(bas1,p);
            p++;
            if(x==0){
                break;
            }
        }
        
        return rv;
    }
    public static int deciToanyBas(int n1, int bas2){
        int rv=0;
        int x=n1;
        double p=0;
        for (int i = 1; i <= n1; i++) {
            int y=x%bas2;
            x/=bas2;
            rv+=y*Math.pow(10,p);
            p++;
            if(x==0){
                break;
            }
        }
        
        return rv;
    }
    public static void main(String[] a){
        System.out.print("Enter the number: " );
        Scanner s =new Scanner(System.in);
        int x= s.nextInt();
        System.out.print("Enter the base of given no.: " );
        int base1= s.nextInt();
        System.out.print("Enter the base to conver: " );
        int base2= s.nextInt();
        
        System.out.println(deciToanyBas(anyBasToDe(x,base1) ,base2));

    }
}
