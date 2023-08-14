import java.util.Scanner;

public class febbo {
    public static void main(String[] args){
        System.out.println("Enter the num: ");
        Scanner s= new Scanner(System.in);
        int x= s.nextInt();
        int a=0;
        int b=1;
        int x1=0;
        for(int i=0; i<10; i++){
            System.out.print(a + " " );
            x1=a+b;
            a=b;
            b=x1;
        }
    }
}
