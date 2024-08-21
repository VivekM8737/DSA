import java.util.Scanner;

public class XOROfsumOfAllParesOfArr {
    public static int xorOfsumofpares(int [] arr){
        int res=0;
        for (int i = 0; i < arr.length; i++) {
            res=(res^(arr[i]));
        }
        return res<<1;
    }
    public static void main(String[] args) {
        System.out.println("Enter the len of arr: ");
        Scanner s = new Scanner(System.in);
        int len= s.nextInt();
        int res=0;
        int []arr= new int[len];
        for (int i = 0; i < len; i++) {
            int x=s.nextInt();
            arr[i]=x;
        }
        System.out.println(xorOfsumofpares(arr));
    }
}
