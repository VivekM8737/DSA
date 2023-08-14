import java.util.Scanner;

public class par16 {
    public static void main(String[] a){
        System.out.println("Enter the num: ");
        Scanner s= new  Scanner(System.in);
        int x= s.nextInt();
        System.out.println("");
        int spc=2*x-3;
        for(int i=1;i<=x;i++){
            for(int j=1; j<=i;j++){
                System.out.print(j+" ");
            }
            for(int j=0; j<spc;j++){
                System.out.print("  ");
            }
            spc=spc-2;
            int n=0;
            if(i==x){
                n=1;
            }
            for(int j=1; j<=i;j++){
                if(j!=x){
                    System.out.print(i-n+" ");
                }
                n++;
            }
            System.out.println("");
        }
        
    }
}
