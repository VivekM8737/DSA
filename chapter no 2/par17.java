import java.util.Scanner;

public class par17 {
    public static void main(String[] a){
        System.out.println("Enter the num: ");
        Scanner s= new  Scanner(System.in);
        int x= s.nextInt();
        int str=1;
        for(int i=0;i<x;i++){
            for(int j=1; j<=(x/2);j++){
               if(i==x/2){

                   System.out.print("* ");
               }
               else{ 
                    System.out.print("  ");
                }

            }
            for(int j=1; j<=str;j++){
                System.out.print("* ");

            }System.out.println("");
            if(i<x/2){
                str++;
            }
            else{
                str--;
            }
        }
        
    }
}
