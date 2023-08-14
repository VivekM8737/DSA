import java.util.Scanner;

public class par10 {
    public static void main(String[] args) {
        System.out.println("Enter the num: ");
        Scanner s= new  Scanner(System.in);
        int x= s.nextInt();
        int spc=x/2;
        int spcw=0;
        for(int j=0; j<x; j++){
            for(int i=0; i<spc; i++){
                System.out.print(" ");
            }
            System.out.print("*");
            for(int i=1; i<=2*spcw-1; i++){
                System.out.print(" ");
            }
            if(j==0 || j==x-1){}
            else{System.out.print("*");}
            System.out.println("");
            if(j<x/2){
                spc--;
                spcw++;
            }
            else{
                spc++;
                spcw--;
            }
        }
    }
}
