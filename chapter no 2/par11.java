import java.util.Scanner;

public class par11 {
    public static void main(String[] a){
        System.out.println("Enter the num: ");
        Scanner s= new  Scanner(System.in);
        int x= s.nextInt();
        int n=1;
        for(int i=0;i<x;i++){
            for(int j=0; j<=i;j++){
                System.out.print(n+" ");
                n++;
            }System.out.println("");
        }
        
    }
}
