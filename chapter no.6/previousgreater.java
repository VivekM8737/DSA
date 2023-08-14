import java.util.Scanner;
import java.util.Stack;

public class previousgreater {
    public static void bystack(int []arr){
        int []pge=new int [arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = arr.length-1; i>=0; i--) {
            while (st.size()>0 && arr[i]>=arr[st.peek()]) {
               int x= st.peek();
                pge[x]=arr[i];
                st.pop();
            }
            st.push(i);
        }
        while(st.size() > 0){
            int x = st.peek();
            pge[x]=-1;
            st.pop();
        }
        for (int i = 0; i < pge.length; i++) {
            System.out.print(pge[i]+" ");
        }
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
