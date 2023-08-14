import java.util.*;
public class mergeList {
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
    public static linkList merge(linkList x1, linkList x2){
        linkList l3 = new linkList();
        Node n1 = new Node();
        n1=x1.head();
        Node n2 = new Node();
        n2=x2.head();
        System.out.println(x1.head().data +" "+ x2.head().data);

       while(n1!=null && n2!=null){ 
            if(n1.data<=n2.data){
                l3.addlast(n1.data);
                n1=n1.next;
                // System.out.println("1");
            }
            else{
                l3.addlast(n2.data);
                n2=n2.next;
                // System.out.println("2");
            }
        }
        while(n1!=null){
            l3.addlast(n1.data);
            n1=n1.next;
            // System.out.println("3");

        }
        while(n2!=null){
            l3.addlast(n2.data);
            n2=n2.next;
            // System.out.println("4");

        }
        return l3;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
        linkList l1 = new linkList();
        linkList l2 = new linkList();
        l1.addhead(10);
        l1.addlast(14);
        l1.addlast(18);
        l1.addlast(25);
        l1.addlast(66);
        l2.addlast(6);
        l2.addlast(15);
        l2.addlast(20);
        l2.addlast(24);
        l2.addlast(28);
        l2.addlast(32);
        l2.addlast(38);
        l1.disp();
        l2.disp();
        System.out.println(l1.head().data +" "+ l2.head().data);
        linkList li3=new linkList();

        li3=merge(l1, l2);
        li3.disp();
        
    }
}
