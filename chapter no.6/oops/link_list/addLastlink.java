public class addLastlink{
    public static class Node{
        int data;
        Node next;
    }
    public static class linkList{
        Node head;
        Node tail;
        int size=0;
        void addlast(int x){
            Node temp = new Node();
            temp.data=x;
            temp.next=null;
            if(size==0){
                head=tail=temp;
            }
            else{
                tail.next=temp;
                tail=temp;
            }
            size++;
        }
        int size(){
            return size;
        }
        void disp(){
            if(size==0){
                System.out.println("List is empty!");
            }
            else{
                Node s =head;
                System.out.println(tail.data);
            while(s!=null){
                System.out.print(s.data+" ");
                s=s.next;
            }
            System.out.println();}
        }
    }
    public static void main(String[] args) {
        linkList x = new linkList();
        x.addlast(10);
        x.addlast(20);
        x.addlast(30);
        x.addlast(40);
        x.addlast(50);
        x.disp();
    }
}