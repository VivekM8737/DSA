public class create_aqueue{
    public static class Que{
        int [] arr;
        int size;
        int fr;
        int n;
        public Que(int n){
            arr = new int[n];
            size=0;
            fr=0;
            this.n=n;
        }
        int size(){
            return size;
        }
        void add(int x){
            if(size>=n){
                System.out.println("Queue is full!");
            }
            else{
                int rear =(fr+size)%n;
                arr[rear]=x;
                size++;
            }
        }
         
        int remove(){
            if(size<=0){
                System.out.println("Queue is underflow!");
                return 0;
                
            }
            else{
                int val=arr[fr];
                fr=(fr+1)%n;
                size--;
                return val;
            }
        }
        int peek(){
            if(size==0){
                System.out.println("Queue is underflow!");
                return 0;
                
            }
            else{
                int val=arr[fr];
                return val;
            }
        }
        void diplay(){
            for (int i = 0; i < size; i++) {
                int in=(fr+i)%n;
                System.out.print(arr[in] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Que A= new Que(5);
        A.add(5);
        A.add(4);
        A.add(3);
        A.add(7);
        A.add(8);
        System.out.println(A.peek());
        A.remove();
        A.remove();
        System.out.println(A.peek());
        
        A.add(9);
        A.diplay();
    }
}