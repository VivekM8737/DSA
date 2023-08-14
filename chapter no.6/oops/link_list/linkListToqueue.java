import java.util.LinkedList;

public class linkListToqueue {
    public static class que{
        LinkedList<Integer> l1;
        // int size=0;
        que(){
            l1= new LinkedList<>();
        }
        int size(){
            return l1.size();
        }
        void add(int x){
            l1.addLast(x);
        }
        void remove(){
            if(size()==0){
                System.out.println("Queue is underflow!");
            }
            else{

                l1.removeFirst();
                
            }
        }
        void peek(){
            if(size()==0){
                System.out.println("Queue is underflow!");
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
        que q1 = new que();
        q1.add(5);
        q1.add(6);
        q1.add(7);
        q1.add(8);
        q1.add(9);
        q1.peek();
        q1.disp();
        q1.remove();
        q1.disp();
    }
}
