import java.util.Scanner;

public class copySetBitInRange {
    public static void byme(int a,int b,int x,int y){
        int m=(1<<(x))-1;
        m=m&(~(1<<(y)));
        m=(m&a);
        b=b|m;
        System.out.println(b);
    }
    public static void bysir(int a, int b,int x, int y){
        int m=(1<<(x-y+1))-1;
            m=(m<<(y-1));
            m=a&m;
            b=(b|m);
            System.out.println(b);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ether the value of a b x y respectively: ");
        int a=s.nextInt();
        int b=s.nextInt();
        int x=s.nextInt();
        int y=s.nextInt();
        if (x<y) {
            System.out.println("not possible");
            return;
        }
        byme(a, b, x, y);
        bysir(a, b, x, y);
        
        


    }
}
