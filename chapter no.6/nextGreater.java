import java.util.Scanner;
import java.util.Stack;


public class nextGreater{
    public static void byLoop(int[] arr){
        int [] arr1=new int[arr.length];
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                if(arr[i]<arr[j]){
    
                    arr1[i]=arr[j];
                    break;
                }
                else{
                    arr1[i]=-1;
                }
            }
        }
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");    
        }
        System.out.println();    
        for(int i=0; i<arr.length; i++){
            System.out.print(arr1[i]+" ");    
        }
    }
    public static void disp(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
    public static int[] bystack(int[] arr){
        int [] ngc = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr[arr.length-1]);
        ngc[arr.length-1]= -1;
        for(int i=arr.length-2; i>=0 ; i--){

            while(st.size() > 0 && arr[i]>=st.peek()){
                st.pop();
            }
            if(st.size()==0){
                ngc[i]=-1;
            }
            else{
                ngc[i]=st.peek();
            }
            st.push(arr[i]);
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

        byLoop(arr);
        System.out.println(" ");
        bystack(arr);
    }
}