import java.util.Scanner;

public class onceOccuredinArray {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the length of array: ");
        int len=s.nextInt();
        int [] arr=new int[len];
        System.out.println("Enter the element of array: ");
        int x=0;
        for (int i = 0; i < arr.length; i++) {
            arr[i]=s.nextInt();
            x=(x^arr[i]);
        }
        System.out.println(x +" is occured once.");
    }
}
