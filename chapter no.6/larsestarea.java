import java.util.Scanner;
import java.util.Stack;

public class larsestarea {
    public static int[] pse(int []arr){
        int []pge=new int [arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = arr.length-1; i>=0; i--) {
            while (st.size()>0 && arr[i]<=arr[st.peek()]) {
               int x= st.peek();
                pge[x]=i;
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
            System.out.println();
            return pge;
    }
    public static int[] nse(int[] arr){
        int [] ngc = new int[arr.length];
        Stack<Integer> st =new Stack<>();
        st.push(0);
        for(int i=1; i<arr.length ; i++){

            while(st.size() > 0 && arr[i]<=arr[st.peek()]){
                int x = st.peek();
                ngc[x]=i;
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
        System.out.println();
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
        System.out.println("1 ");
        int []p1=pse(arr);
        System.out.println("2 ");
        int []p2=nse(arr);
        int maxarea=0;
        for (int i = 0; i < arr.length; i++) {
            int width= p2[i] - p1[i]-1;
            int area=width*arr[i];
            if(maxarea<area){
                maxarea=area;
            }
        }
        System.out.println(maxarea);
    }
}
