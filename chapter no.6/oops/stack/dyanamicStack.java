import java.util.Stack;

public class dyanamicStack{
    public static class Customstack{
        int []arr;
        int top;
        public Customstack(int len )
        {
         arr=new int [len];
         top=-1;   
        }
        void push(int ele){
            if(top==arr.length-1){
               int [] arr2 = new int[2*arr.length];
               for(int i=0; i<arr.length; i++){
                arr2[i]=arr[i];
               }
               arr=arr2;
               top++;
               arr[top]=ele;
            }
            else{top++;
            arr[top]=ele;}
        }
        int size(){
            return top+1;
        }
        void pop(){
            if(top==-1){
                System.out.println("Sack is underflow!");
            }
            else{top--;}
        }
        int peek(){
            if(top>=0){

                return arr[top];
            }
            else{
                System.out.println("Stack empty :(");
                return 0;
            }
        }
    }
    public static void main(String[] args) {
        Customstack st;
        st = new Customstack(3);
        st.push(55);
        st.push(56);
        st.push(58);
        st.push(59);
        // st.pop();
        // st.pop();
        // st.pop();
        System.out.println(st.size());
        System.out.println(st.peek()); 
    }
}