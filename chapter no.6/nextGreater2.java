import java.util.Scanner;
import java.util.Stack;

public class nextGreater2 {
    public static int[] bystack(int[] arr){
        int [] ngc = new int[arr.length];
        Stack<Integer> st =new Stack<>();
        st.push(0);
        for(int i=1; i<arr.length ; i++){

            while(st.size() > 0 && arr[i]>=arr[st.peek()]){
                int x = st.peek();
                ngc[x]=arr[i];
                st.pop();
            }
            st.push(i);
        }
        while(st.size() > 0){
            int x = st.peek();
            ngc[x]=-1;
            st.pop();
        }
        for (int i = 0; i < ngc.length; i++) {
            System.out.print(ngc[i]+" ");
        }
        return ngc;
    }
    public static void main(String[] args) {
        System.out.print("Enter the length of arr: ");
        Scanner s =new Scanner(System.in);
        int x= s.nextInt();
        int [] arr= new int [x];
        System.out.print("Enter the element of arr: ");
        for(int i=0; i<arr.length; i++){
            arr[i]=s.nextInt();
        }
        System.out.println(" ");
        bystack(arr);
    }
}
