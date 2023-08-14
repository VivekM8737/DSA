import java.util.Scanner;

public class anymult {
    public static int sum(int x,int y ,int bas){
        int sum=0;
        int p=1;
        int c=0;
        int b = 0;
        int s=0;
        while(x>0 || y>0 || c>0){
            int a=x%10;
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
    public static int finnal(int x ,int y ,int bas){
        int rv=0;
        int p=1;
        int res=0;
        while(y>0){
            int a=y%10;
            y/=10;
            rv=(mul(x, a, bas))*p;
            res=sum(res,rv , bas);
            p*=10;

        }
        return res;
    }

    public static int mul(int x,int y ,int bas){
        int sum=0;
        int p=1;
        int c=0;
        int s=0;
        while(x>0 || c>0){
            int a=x%10;
            x/=10; 
            s=(a*y)+c;
            c=s/bas;
            s=s%bas;
            sum+=s*p;
            p*=10;
        }
        return sum;
    }
    public static void main(String[] a){
    
    Scanner s= new Scanner(System.in);
    System.out.println("Enter the num1: ");
    int x= s.nextInt();
    System.out.println("Enter the num2: ");
    int y= s.nextInt();
    System.out.println("Enter the bas: ");
    int bas= s.nextInt();
    System.out.println(finnal(x, y, bas));
    } 
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
}
