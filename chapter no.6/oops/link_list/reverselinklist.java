import javax.xml.crypto.Data;

public class reverselinklist {

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
            int x=0;
            if (size == 0) {
                System.out.println("List is empty!");
            }
            else {
                Node s = head;
                while (x<size) {
                    System.out.print(s.data + " ");
                    s = s.next;
                    x++;
                }
                System.out.println();
            }
        }
        void reverse(){
            Node temp=head;
            Node t1=head;
            Node t2=head;
            int j=size;
            for (int i = 0; i < (size/2); i++) {
                int jj=0;
                do{
                    t1=t1.next;
                    jj++;
                    // System.out.println(t1.data);
                }while(jj<j-1);
                int c=t2.data;
                temp.data=t1.data;
                t1.data=c;
                temp=temp.next;
                t1=temp;
                t2=t2.next;
                j=j-2;
            }
        }
        private Node getatindex(int x){
            if(x>=size || x<0){
                System.out.println("Invailid Index!");
                return null;
            }
            else{Node temp = head;
            for(int i=0; i<x;i++){
                temp=temp.next;
            }
            return temp;}
        }
        void reversel(){
            int li=0;
            int la=size-1;
            for(int i=0; i<size/2; i++){
                Node z=getatindex(li);
                Node x =getatindex(la);
                int temp=z.data;
                z.data=x.data;
                x.data=temp;
                li++;
                la--;
            }
        }
        void reversebyne(){
            int la=size-1;
            int li=size-2;
            // Node z=getatindex(li);
            // Node x =getatindex(la);
            // x.next=z;
            for(int i=0; i<size-1; i++){
                Node x=getatindex(li);
                // System.out.println(x.data);
                Node y =getatindex(la);
                // System.out.println(y.data);
                y.next=x;
                li--;
                la--;
                if(la==0){
                    x.next=null;
                }
            }
            head=tail;
        }

    }

    public static void main(String[] args) {
        lList x = new lList();
        x.addlast(10);
        x.addlast(20);
        x.addlast(30);
        x.addlast(40);
        x.addlast(50);
        x.addlast(60);
        x.addlast(70);
        x.addlast(80);
        x.disp();                           
        // x.removeId(5);
        // x.reversebyne();
        x.reversel();
        // x.removelast();
        x.disp();
    }

}
