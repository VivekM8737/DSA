import java.util.Scanner;

public class countTriplatesInArray {
    public static void main(String[] args) {
        System.out.println("Enter the length of arr: ");
        Scanner s= new Scanner(System.in);
        int len = s.nextInt();
        int [] arr=new int[len];
        for (int i = 0; i <len; i++) {
            arr[i]=s.nextInt();
        }
        int c=0;
        for (int i = 0; i < arr.length; i++) {
            int val=arr[i];
            for (int j = i+1; j < arr.length; j++) {
                val=(val^arr[j]);
                if (val==0) {
                    c+=(j-i);
                }
            }
        }
        System.out.println("Threre are "+c+" triplates");
    }
}
