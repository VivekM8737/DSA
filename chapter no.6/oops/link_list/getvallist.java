public class getvallist {
    public static class Node {
        int data;
        Node next;
    }

    public static class linkList {
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

        int remove() {
            if (size == 0) {
                System.out.println("List is empty!");
                return 0;
            } else if (head == tail) {
                head.data = 0;
                head.next = null;
                size--;
                return 0;
            } else {
                head = head.next;
                size--;
            }
            return 0;
        }
        int getHead() {
            return head.data;
        }
        int getTail() {
            return tail.data;
        }
        int getatindex(int x){
            if(x>=size || x<0){
                System.out.println("Invailid Index!");
                return 0;
            }
            else{Node temp = head;
            for(int i=0; i<x;i++){
                temp=temp.next;
            }
            return temp.data;}
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
        System.out.println(x.getHead());
        System.out.println(x.getTail());
        System.out.println(x.getatindex(2));
        x.disp();
    }

}
