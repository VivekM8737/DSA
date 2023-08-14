import java.util.Scanner;

public class part7 {
    public static void main(String[] a){
        System.out.println("Enter the num: ");
        Scanner s= new  Scanner(System.in);
        int x= s.nextInt();
        int spc=0;
        for(int j=0;j<x;j++){
            for(int i=0; i<spc; i++){
                System.out.print("  ");
            }
            spc++;
            System.out.print("*");
            System.out.println("");
        }

    }
}
