import java.util.Scanner;

public class dicrising {
    public static int d(int x){
        if(x==0){
            return 0;
        }
        System.out.println(x);
        return x+d(x-1);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the num: ");
        int x=s.nextInt();
        System.out.println(d(x));
    }
}
