import java.util.Stack;

public  class minValinst{
    public static class Minst{
        Stack<Integer> adt;
        Stack<Integer> mdt;
        public Minst(){
            adt = new Stack<>();
            mdt = new Stack<>();
        }
        int size(){
            return adt.size();
        }
        int top(){
            if(size()==0){
                System.out.println("Stact underflow!");
                return 0;
            }
            else{
                return adt.peek();
            }
        }
        int min(){
            if(size()==0){
                System.out.println("Stact underflow!");
                return 0;
            }
            else{
                return mdt.peek();
            }
        }
        void push(int x){
            if (size()==0) {
                mdt.push(x);
            }
            else if(x<mdt.peek()){
                
                mdt.push(x);
            }
            adt.push(x);
        }
        void pop(){
            if(size()==0){
                System.out.println("Stact underflow!");
            }
            else{
                if(adt.peek()==mdt.peek()){
                
                    mdt.pop();
                }
                adt.pop();
            }

        }
       

    }
    public static void main(String[] args) {
     Minst a1 = new Minst();
     
     a1.push(10);
     a1.push(6);
     a1.push(11);
     a1.push(2);
     a1.push(5);
     a1.pop();
     a1.pop();
     int x=a1.top();
     int y=a1.min();
    System.out.println(x+" Min is: "+y);

    }
}