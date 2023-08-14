import java.util.Scanner;

public class par12 {
    
    public static void main(String[] a){
        System.out.println("Enter the num: ");
        Scanner s= new  Scanner(System.in);
        int x= s.nextInt();
        for(int i=0;i<x;i++){
            int d = 1;
            for(int j=0; j<=i;j++){
                System.out.print(d+" ");
                d=d*(i-j)/(j+1);
                
            }
            System.out.println("");
            
        }
        
    }
}
