import java.util.Scanner;

public class praten3 {
    public  static void main(String[] a){
        System.out.println("Enter the num: ");
        Scanner s= new  Scanner(System.in);
        int x= s.nextInt();
        int str=1;
        int spc=x-1;
        for(int i=0;i<x;i++){
            for(int j=0; j<spc;j++){
                System.out.print("  ");
            }
            for(int j=0; j<str;j++){
                System.out.print("* ");
            }System.out.println("");
            str++;
            spc--;
        }
    }
}
