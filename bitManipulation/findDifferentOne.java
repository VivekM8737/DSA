import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class findDifferentOne {
    public static void main(String[] args) {

        Scanner s= new Scanner(System.in);
        System.out.println("Enter the length: ");
        int len=s.nextInt();
        int [] arr=new int[len];

        int n3=Integer.MAX_VALUE;
        int n3_1=0;
        int n3_2=0;
        HashMap<Integer,Integer> hs = new HashMap<>();
        System.out.println("Enter the element of arr: ");
        for(int i=0; i<arr.length; i++){
            arr[i]=s.nextInt();
            int c3n=(n3&arr[i]);
            int c3n_1=(n3_1&arr[i]);
            int c3n_2=(n3_2&arr[i]);
            n3_1=(c3n|n3_1);
            n3_2=(c3n_1|n3_2);
            n3=(c3n_2|n3);
            n3_1=((~c3n_1)&n3_1);
            n3_2=((~c3n_2)&n3_2);
            n3=((~c3n)&n3);

        }
        System.out.println(n3_1);
    }
}
