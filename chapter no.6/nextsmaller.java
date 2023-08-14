import java.util.Scanner;
import java.util.Stack;

public class nextsmaller {
    public static int[] nse(int[] arr){
        int [] psse=new int[arr.length];
        Stack<Integer> st1 = new Stack<>();
        st1.push(arr.length-1);
        psse[arr.length-1]=-1;
        for (int i = arr.length-1; i>=0; i--) {
            while (st1.size()>0 && arr[i]<=arr[st1.peek()]) {
                st1.pop();
            }
            if(st1.size()==0)
            {
                psse[i]=-1;
            }
            else{
                psse[i]=arr[st1.peek()];
            }
            st1.push(i);
        }
        for (int i = 0; i < psse.length; i++) {
            System.out.print(psse[i]+" ");
        }
        return psse;
    }

    public static int[] bystack(int[] arr){
        int [] ngc = new int[arr.length];
        Stack<Integer> st =new Stack<>();
        st.push(0);
        for(int i=1; i<arr.length ; i++){

            while(st.size() > 0 && arr[i]<=arr[st.peek()]){
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
        nse(arr);
    }
}
