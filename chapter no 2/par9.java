import java.util.Scanner;

public class par9 {
    public static void main(String[] a){
        System.out.println("Enter the num: ");
        Scanner s= new  Scanner(System.in);
        int x= s.nextInt();
        for(int j=0;j<x;j++){
            for(int i=0; i<x; i++){
                if(i==j || i+j==x-1 ){

                    System.out.print("*");
                }
                else{System.out.print(" ");}
            }System.out.println("");
            
            

        }
    }
}
