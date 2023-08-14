import java.util.Scanner;
import java.lang.Math;
public class rotat {
    public static void main( String[] args){
        System.out.println("Enter the num: ");
        Scanner s=new Scanner(System.in);
        int x=s.nextInt();
        System.out.println("Enter the round: ");
        int y=s.nextInt();
        int a=0;
        int b=x;
        int c=1;
        int cu=1;
        for(int i=1;i<x/10;i=i*10){
            c=c*10;
            cu++;
        }
        if(y>=cu){
            y=y%cu;
        }
        for(int j=0; j<y; j++){
            a=x%10;
            x=x/10;
            b=b/10;
            b=b+a*c;


        }
        System.out.println(b);
    }
}
