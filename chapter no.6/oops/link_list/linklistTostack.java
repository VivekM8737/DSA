import java.util.LinkedList;
public class linklistTostack {
    public static class stk{
        LinkedList<Integer> l1;
        // int size=0;
        stk(){
            l1= new LinkedList<>();
        }
        int size(){
            return l1.size();
        }
        void push(int x){
            l1.addFirst(x);
        }
        void pop(){
            if(size()==0){
                System.out.println("Stack is underflow!");
            }
            else{

                l1.removeFirst();
                
            }
        }
        void top(){
            if(size()==0){
                System.out.println("Stack is underflow!");
            }
            else{

            
                System.out.println(l1.getFirst());
            }
        }
        void disp(){
            System.out.print("linklist is: "+ l1+"\n");
        }


    }
    public static void main(String[] args) {
        stk s1= new stk();
        s1.pop();
        s1.push(15);
        s1.push(16);
        s1.push(17);
        s1.push(18);
        s1.push(19);
        s1.disp();
        s1.top();
        System.out.println(s1.size());
        s1.pop();
        System.out.println(s1.size());
        s1.disp();
    }
}
