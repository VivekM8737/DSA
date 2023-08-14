import java.util.Scanner;

public class par2 {
    public static void main(String[ ] a){
        System.out.println("Enter the num: ");
        Scanner s= new  Scanner(System.in);
        int x= s.nextInt();
        for(int i=x;i>0;i--){
            for(int j=0; j<i;j++){
                System.out.print("* ");
            }System.out.println("");
        }
    }
}
