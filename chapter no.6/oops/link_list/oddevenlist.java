public class oddevenlist {
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
            while(s!=null){
                System.out.print(s.data+" ");
                s=s.next;
            }
            System.out.println();}
        }
        int remove(){
            if(size==0){
                System.out.println("List is empty!");
                return 0;
            }
            else if(head==tail){
                head.data=0;
                head.next=null;
                size--;
                return 0;
            }
            else{
                head=head.next;
                size--;
            }
            return 0;
        }
        Node head(){
            if(size==0){
                System.out.println("List is empty!");
                return null;
            }
            else{
                return head;
            }
        }
        Node tail(){
            if(size==0){
                System.out.println("List is empty!");
                return null;
            }
            else{
                return tail;
            }
        }
    }
    public static linkList oddEvenList(linkList l1){
        linkList odd = new linkList();
        linkList even = new linkList();
        Node x= l1.head();
        while(x!=null){
            if(x.data%2==0){
                even.addlast(x.data);
            }
            else{
                odd.addlast(x.data);
            }
            x=x.next;
        }
        if(odd.size==0){

            return even;
        }
        else if(even.size==0){
            return odd;
        }
        else{
            
            odd.tail().next=even.head();
            odd.tail=even.tail();
        }
        return odd;

    }
    public static void main(String[] args) {
            linkList l1 =new linkList();
            l1.addlast(10);
            l1.addlast(8);
            l1.addlast(15);
            l1.addlast(1);
            l1.addlast(7);
            l1.addlast(20);
            // linkList odEvList = new linkList();
            l1 = oddEvenList(l1);
            l1.disp();
    }
}
