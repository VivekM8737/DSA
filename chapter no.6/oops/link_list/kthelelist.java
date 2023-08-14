import java.util.LinkedList;
import java.util.Stack;

public class kthelelist {
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

        int remove() {
            if (size == 0) {
                System.out.println("List is empty!");
                return 0;
            } else if (head == tail) {
                head.data = 0;
                head.next = null;
                tail = head;
                size--;
                return 0;
            } else {
                head = head.next;
                size--;
            }
            return 0;
        }

        int removelast() {
            if (size == 0) {
                System.out.println("List is empty!");
                return 0;
            }
            else if (head == tail) {
                int val=head.data;
                head.data = 0;
                head.next = null;
                tail = head;
                size--;

                return val;
            } 
            else {
                Node temp = head;
                while (temp.next.next != null) {
                    temp = temp.next;
                }
                int val=temp.next.data;
                temp.next = null;
                tail = temp;
                size--;
                return val;
            }
        }

        int removeId(int idx) {
            Node temp = head;
            if (idx < 0 || idx >= size) {
                System.out.println("Invailid Index!");
                return 0;
            } else if (idx == 0) {
                remove();
                return 0;
            } else if (idx == size - 1) {
                removelast();
                return 0;
            }

            else {
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                size--;
            }
            // System.out.println(temp.data);

            return 0;
        }

        void kth(int k) {

            Node s = head;
            Node f = head;

            for (int i = 0; i < k; i++) {
                f = f.next;
            }
            while (f.next != null) {
                s = s.next;
                f = f.next;
            }
            s.next = s.next.next;

        }
    }
//  By me...
    public static void rekth(lList x, int k) {
        Stack<Integer> s1 = new Stack<>();
        for (int i = 0; i < k; i++) {
            s1.push(x.removelast());
        }
        System.out.println(s1.peek());
        while (s1.size() != 0) {
            x.addlast(s1.pop());
        }
    }

    public static void main(String[] args) {
        lList l1 = new lList();
        l1.addlast(10);
        l1.addlast(11);
        l1.addlast(12);
        l1.addlast(13);
        l1.addlast(14);
        l1.addlast(15);
        l1.disp();
        // l1.kth(4);
        rekth(l1, 4);
        l1.disp();

    }

}
