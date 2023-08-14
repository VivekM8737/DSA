import java.util.Scanner;

public class par15 {
    public static void main(String[] a){
        System.out.println("Enter the num: ");
        Scanner s= new  Scanner(System.in);
        int x= s.nextInt();
        int spc=x/2;
        int str=1;
        int n=1;
        for(int i=0;i<x;i++){
            for(int j=0; j<spc;j++){
                System.out.print("   ");
            }
            for(int j=0; j<str;j++){
                System.out.print(" "+(n+j)+" ");
            }if(i<x/2){
                spc--;
                str=str+2;
                n++;
            }
            else{
                spc++;
                str=str-2;
                n--;
            }
            
            System.out.println("");
        }
     }
}
