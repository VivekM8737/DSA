import java.util.*;
public class printpar1{
    public static void main(String[] a){
        System.out.println("Enter the num: ");
        Scanner s= new  Scanner(System.in);
        int x= s.nextInt();
        for(int i=0;i<x;i++){
            for(int j=0; j<=i;j++){
                System.out.print("* ");
            }System.out.println("");
        }
        
    }
}