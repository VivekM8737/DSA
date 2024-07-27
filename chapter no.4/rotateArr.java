import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class rotateArr {
    public static void main(String[] args) {
        int [] ar={1,2,3,4,5};
        System.out.println("Enter the number of rotation: ");
        Scanner s =new Scanner(System.in);
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < ar.length; i++) {
            q.add(ar[i]);
        }
        int n=s.nextInt();
        while(n>0){
            int t=q.remove();
            q.add(t);
            n--;
        }
        System.out.println();
        for (int i = 0; i < ar.length; i++) {
            System.out.print(q.remove()+" ");
        }
    }
}
