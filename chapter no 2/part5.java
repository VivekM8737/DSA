import java.util.Scanner;

public class part5 {
    public static void main(String[] a){
        System.out.println("Enter the num: ");
        Scanner s= new  Scanner(System.in);
        int x= s.nextInt();
        int spc=1;
        int str=(x/2);
        for(int i=0;i<x;i++){
        
            for(int j=0; j<=str;j++){
                System.out.print("* ");
            }
            for(int j=0; j<spc;j++){
                System.out.print("  ");
            }
            for(int j=0; j<=str;j++){
                System.out.print("* ");
            }System.out.println("");
            if(i<(x/2)){
                spc=spc+2;
                str--;
            }
            else{
                spc=spc-2;
                str++;
            }
        }
    }
}
