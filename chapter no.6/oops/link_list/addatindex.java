public class addatindex {
    public static class Node {
        int data;
        Node next;
    }

    public static class linkList {
        Node head;
        Node tail;
        int size = 0;

        void addhead(int x) {
            Node temp = new Node();
            temp.data = x;
            temp.next = head;
            if (size == 0) {
                head=tail = temp;
            } else {
                head = temp;
            }
            size++;
        }

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
        void addatindex(int x , int index){
            if(index==0){
                addhead(x);
                System.out.println("Add head");
            }
            else if(index==size){
                addlast(x);
                System.out.println("add last");
            }
            else if(index <0 || index > size){
                System.out.println("Invailid Index!");
            }
            else{
                System.out.println("at index: ");
                Node temp = head;
                for(int j=0; j<index; j++){
                    temp=temp.next;
                }
                Node val = new Node();
                val.data=x;
                val.next=temp.next;
                temp.next=val;
                size++;
            }
        }
    }

    public static void main(String[] args) {
        linkList l1 = new linkList();
        l1.addlast(10);
        l1.addlast(11);
        l1.addlast(12);
        l1.addhead(9);
        l1.addhead(8);
        l1.addatindex(6, 5);
        l1.disp();

    }
}
