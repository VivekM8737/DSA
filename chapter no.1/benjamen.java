import java.util.Scanner;

public class benjamen {
    public static void main(String[] agrs){
        System.out.println("Enter the num: ");
        Scanner s=new Scanner(System.in);
        int x=s.nextInt();
        int count=0;
        for(int i=1; i*i<=x; i++){
            System.out.println(i*i);
        }
    }
}
