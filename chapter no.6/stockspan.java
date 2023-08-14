import java.util.Scanner;
import java.util.Stack;

public class stockspan {
    public static void byarr(int []arr){
        int [] span= new int [arr.length];
        Stack<Integer> sp=new Stack<>();
        sp.push(0);
        span[0]=1;
        for (int i = 1; i < arr.length; i++) {
            while(sp.size() > 0   && arr[i]>arr[sp.peek()]){
                
                sp.pop();
               
            }
            if(sp.size()==0){
                span[i]=i+1;
            }
            
            else{
                span[i]=i-sp.peek();
                // System.out.println(sp.peek());
            }
            sp.push(i);
        }
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i]+" ");
        }
    }
    public static void main(String[] args) {
        System.out.print("Enter the length of arr: ");
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int []arr= new int[x];
        System.out.print("Enter the element of arr: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i]= s.nextInt();
        }
        byarr(arr);
    }
}
