import java.util.*;
public class additionAtaynBAs {

    public static int sum(int x,int y ,int bas){
        int sum=0;
        int p=1;
        int c=0;
        int a=0;
        int b = 0;
        int s=0;
        while(x>0 || y>0 || c>0){
            a=x%10;
            b=y%10;
            x/=10; 
            y/=10;
            s=a+b+c;
            if(s>=bas){
                s=s%bas;
                c=1;
            }else{
                c=0;
            }
            sum+=s*p;
            p*=10;
        }
        return sum;
    }
    public static void main(String[] a){
    
    System.out.println("Enter the num1: ");
    Scanner s= new Scanner(System.in);
    int x= s.nextInt();
    System.out.println("Enter the num2: ");
    int y= s.nextInt();
    System.out.println("Enter the bas: ");
    int bas= s.nextInt();
    System.out.println(sum(x, y, bas));
    } 
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
}
