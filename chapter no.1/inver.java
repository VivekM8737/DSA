import java.util.Scanner;
import java.lang.Math;


public class inver {
    public static void main(String[] args){
        System.out.println("Enter the num: ");
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int c=x;
        int z=0;
        double a=0;
        int x1=1;
        for(int i=1; i<x; i=i*10){
            z=c%10;
            c=c/10;
            a=x1 * Math.pow(10,z-1)+a;
            x1++;
            
        }
        System.out.println(a);
    }
}
