public class removeatIndex {
    public static class Node {
        int data;
        Node next;
    }

    public static class lList {
        Node head;
        Node tail;
        int size = 0;

        void addlast(int x) {
            Node temp = new Node();
            temp.data = x;
            temp.next = null;
            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        int size() {
            return size;
        }

        void disp() {
            if (size == 0) {
                System.out.println("List is empty!");
            } else {
                Node s = head;
                while (s != null) {
                    System.out.print(s.data + " ");
                    s = s.next;
                }
                System.out.println();
            }
        }
        int remove(){
            if(size==0){
                System.out.println("List is empty!");
                return 0;
            }
            else if(head==tail){
                int val = head.data;
                head.data=0;
                head.next=null;
                tail=head;
                size--;
                return val;
            }
            else{
                int val = head.data;
                head=head.next;
                size--;
                return val;
            }
        }
        int removelast() {
            if (size == 0) {
                System.out.println("List is empty!");
                return 0;
            } else if (head == tail) {
                int val = head.data;
                head.data = 0;
                head.next = null;
                tail = head;
                size--;

                return val;
            } else {
                Node temp = head;
                while (temp.next.next != null) {
                    temp = temp.next;
                }
                int val = temp.next.data;
                temp.next = null;
                tail = temp;
                size--;
                return val;
            }
        }
        int removeId(int idx){
            Node temp=head;
            if(idx<0 || idx>=size){
                System.out.println("Invailid Index!");
                return 0;
            }
            else if(idx==0){
                
                return remove();
            }
            else if (idx==size-1){
                
                return removelast();
            }

            else{
                for (int i = 0; i < idx-1; i++) {
                    temp=temp.next;
                }
                int val = temp.next.data;
                temp.next=temp.next.next;
                size--;
                return val;
            }
            // System.out.println(temp.data);

        }
        

    }

    public static void main(String[] args) {
        lList x = new lList();
        x.addlast(10);
        x.addlast(20);
        x.addlast(30);
        x.addlast(40);
        x.addlast(50);
        x.disp();
        x.removeId(5);
        
        // x.removelast();
        x.disp();
    }
}
