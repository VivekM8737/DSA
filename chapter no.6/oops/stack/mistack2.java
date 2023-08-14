import java.util.Stack;

public class mistack2 {
    public static class Minst{
        Stack<Integer> adt;
        int mdt;
        public Minst(){
            adt = new Stack<>();
        }
        int size(){
            return adt.size();
        }
        int top(){
            if(size()==0){
                System.out.println("Stact underflow!");
                return 0;
            }
            else if(adt.peek()<mdt){
                return mdt+mdt-adt.peek();
            }
            else{ return adt.peek();}
        }
        int min(){
            if(size()==0){
                System.out.println("Stact underflow!");
                return 0;
            }
            else{
                return mdt;
            }
        }
        void push(int x){
            if (size()==0) {
                mdt=x;
                adt.push(x);
                // System.out.println("y");
            }
            else if(x<mdt){
                // System.out.println("zy");
                adt.push(x+x-mdt);
                mdt=x;
            }
            else{
                // System.out.println("yz");

                adt.push(x);
            }
        }
        void pop(){
            if(size()==0){
                System.out.println("Stact underflow!");
            }
            else{
                if(adt.peek()<mdt){
                
                    mdt=mdt+mdt-adt.peek();
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
