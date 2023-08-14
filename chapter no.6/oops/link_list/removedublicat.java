public class removedublicat {
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
        Node remove(){
            if(size==0){
                System.out.println("List is empty!");
                return null;
            }
            else if(head==tail){
                head.data=0;
                head.next=null;
                size--;
                return null;
            }
            else{
                Node x =head;
                head=head.next;
                size--;
                return x;
            }
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
    }
    public static linkList remodub(linkList l1){
        linkList l2 = new linkList();
        Node head = l1.head();
        while(head!=null){
           int x= l1.head.data;
           l1.remove();
           if(l2.size==0){
                l2.addlast(x);
            }
            else if(x!=l2.tail.data){
               l2.addlast(x);

           }
           head=head.next;
        }
        return l2;

    }
    public static void main(String[] args) {
        linkList l1 = new linkList();
        l1.addlast(14);
        l1.addlast(14);
        l1.addlast(14);
        l1.addlast(14);
        l1.addlast(18);
        l1.addlast(25);
        l1.addlast(25);
        l1.addlast(25);
        l1.addlast(66);

        linkList l2 = new linkList();
        l2=remodub(l1);
        l2.disp();
    }
}
