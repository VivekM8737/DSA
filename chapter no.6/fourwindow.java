import java.util.Scanner;
import java.util.Stack;

public class fourwindow {
    public static int[] bystack(int[] arr){
        int [] ngc = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1);
        ngc[arr.length-1]= arr.length;
        for(int i=arr.length-2; i>=0 ; i--){
            while(st.size() > 0 && arr[i]>=arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                ngc[i]= arr.length;
            }
            else{
                ngc[i]=st.peek();
            }
            st.push(i);
        }
        for (int i = 0; i < ngc.length; i++) {
            System.out.print(ngc[i]+" ");
        }
        System.out.println();
        int j=0;
        for (int i = 0; i <= arr.length-4; i++) {
            if(j<i){ 
                j=i;
            }
            while(ngc[j]<i+4){
                j=ngc[j];
            }
            System.out.println(arr[j]);
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
