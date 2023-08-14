import java.util.Scanner;

public class par20 {
    public static void main(String[] a){
        System.out.println("Enter the num: ");
        Scanner s = new Scanner(System.in);
        int x= s.nextInt();
        for (int i = 1; i <= x; i++) {
            for (int k = 1; k <= x; k++) {
                
                    
                if (k==1 ||  k==x) {
                    System.out.print("* ");
                }
                else if(i>x/2 && (i==k || i+k==x+1)){
                    System.out.print("* ");
                }
                
                else{
                    
                    System.out.print("  ");

                }
                
            }
            System.out.println("");
        }
    }
}
