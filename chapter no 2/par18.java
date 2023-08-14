import java.util.Scanner;

public class par18 {
    public static void main(String[] a){
        System.out.println("Enter the num: ");
        Scanner s= new  Scanner(System.in);
        int x= s.nextInt();
        int str=x;
        int spc=0;
        for(int i=0;i<x;i++){
            for(int j=1; j<=spc;j++){
 
                System.out.print("  ");
            }

            for(int j=1; j<=str;j++){
                if( i!=0 && i<x/2 && j>1 && j<str){
                    System.out.print("  ");
                    
                }
                else{
                    System.out.print("* ");

                }

            }
            System.out.println("");
            if(i<x/2){
                spc++;
                str-=2;
            }
            else{
                spc--;
                str+=2;
            }
        }
        
    }
}
