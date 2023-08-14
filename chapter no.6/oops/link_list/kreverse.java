public class kreverse {
    public static class Node {
        int data;
        Node next;
    }

    public static class linkList {
        Node head;
        Node tail;
        int size = 0;

        void addfirst(int x) {
            Node temp = new Node();
            temp.data = x;
            temp.next = head;
            if (size == 0) {
                head = tail = temp;
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

        int removehead() {
            if (size == 0) {
                System.out.println("List is empty!!");
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

        Node head() {
            if (size == 0) {
                System.out.println("List is empty!!!");
                return null;
            } else {
                return head;
            }
        }

        Node tail() {
            if (size == 0) {
                System.out.println("List is empty!");
                return null;
            } else {
                return tail;
            }
        }
    }

    public static linkList kreverseList(linkList l1, int k) {
        if (l1.size() < k) {
            return l1;
        } 
        else {
            linkList pList = new linkList();
            while (l1.size()!= 0) {
                if (l1.size() >= k) {
                    // System.out.println("size=" + l1.size());
                    linkList cList = new linkList();
                    int i=0;
                    while(i<k) {
                        cList.addfirst(l1.head().data);
                        l1.removehead();
                        i++;
                    }
                    if (pList.size() == 0) {
                        pList = cList;
                    }
                    else{
                        pList.tail().next = cList.head();
                        pList.tail=cList.tail();
                        
                    }
                }
                else {
                    while(l1.size()!=0){
                        pList.addlast(l1.head().data);
                        l1.removehead();
                    }
                    return pList;
                }

            }
            return pList;
        }
    }

    public static void main(String[] args) {
        linkList l1 = new linkList();
        l1.addlast(10);
        l1.addlast(8);
        l1.addlast(15);
        l1.addlast(1);
        l1.addlast(7);
        l1.addlast(20);
        l1.addlast(30);
        l1.addlast(31);
        l1.addlast(32);
        l1 = kreverseList(l1, 3);
        l1.disp();
    }
}
