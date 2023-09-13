import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

public class orderOfTree {
    public static void display(Node node) {
        String str = node.data + "-->";
        for (Node n : node.children) {
            str += n.data + " ";
        }
        System.out.println(str + ".");
        for (Node n : node.children) {
            display(n);
        }
    }

    public static void order(Node node) {
        System.out.println("Node pre " + node.data);
        for (Node n : node.children) {
            System.out.println("edge pre " + node.data + "-" + n.data);
            order(n);
            System.out.println("edge post " + node.data + "-" + n.data);
        }
        System.out.println("Node post " + node.data);
    }

    public static void levelswise(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while (q.size() > 0) {
            node = q.remove();
            System.out.println(node.data);
            for (Node n : node.children) {
                q.add(n);
            }
        }
    }

    public static void levelswiseinline(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        Queue<Node> cq = new ArrayDeque<>();
        q.add(node);
        while (q.size() > 0 || cq.size() > 0) {
            if (q.size() == 0) {
                System.out.println();
                q = cq;
                cq = new ArrayDeque<>();
            }
            node = q.remove();
            System.out.print(node.data + " ");
            for (Node n : node.children) {
                cq.add(n);
            }
        }
    }

    public static void levelswiseinline2(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);

        q.add(new Node(-1));
        while (q.size() > 0) {
            node = q.remove();
            if (node.data == -1) {
                if (q.size() > 0) {
                    q.add(new Node(-1));
                    System.out.println();
                }
            } else {
                System.out.print(node.data + " ");
                for (Node n : node.children) {
                    q.add(n);
                }
            }
        }
    }

    public static void levelswiseinline3(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while (q.size() > 0) {
            int x=q.size();
            for (int i = 0; i < x; i++) {
                node = q.remove();
                System.out.print(node.data + " ");
                for (Node n : node.children) {
                    q.add(n);
                }
            }
            System.out.println();

        }
    }
    public static class Pair{
        Node node;
        int level;
        Pair(){

        }
        Pair(Node node,int level){
            this.node=node;
            this.level=level;
        }
    }
    public static void levelswiseinline4(Node node) {
        Queue<Pair> q = new ArrayDeque<>();
        int level=1;
        q.add(new Pair(node, level));
        while (q.size() > 0) {
            Pair k= q.remove();
            if(k.level>level){
                level=k.level;
                System.out.println();
            }
            System.out.print(k.node.data+" ");
            for(Node n:k.node.children)
            q.add(new Pair(n, k.level+1));


        }
    }
    public static void removeleafNode(Node node){
        for(int i=node.children.size()-1; i>=0;i--){
            Node c=node.children.get(i);
            if(c.children.size()==0){
                node.children.remove(c);
            }
        }
        for(Node n: node.children){
            removeleafNode(n);
        }
    }
    public static void mirror(Node node){
        for(Node n: node.children){
            mirror(n);
        }
        Collections.reverse(node.children);
    }

    public static void levelswiseinZigZagline(Node node) {
        Stack<Node> q = new Stack<>();
        Stack<Node> cq = new Stack<>();
        int i = 0;
        q.add(node);
        while (q.size() > 0 || cq.size() > 0) {
            if (q.size() == 0) {
                System.out.println();
                i++;
                q = cq;
                cq = new Stack<>();
            }
            node = q.pop();
            System.out.print(node.data + " ");
            if (i % 2 != 0) {
                for (int j = node.children.size() - 1; j >= 0; j--) {
                    cq.add(node.children.get(j));
                }
            } else {
                for (int j = 0; j < node.children.size(); j++) {
                    cq.add(node.children.get(j));
                }
            }
        }
    }
    // this is made by me but its have some error
    // public static void levelswisebyMe(Node node,int i){
    // if(i==0){
    // System.out.println(node.data);
    // i++;
    // }
    // for(Node n: node.children){
    // System.out.println(n.data);
    // }
    // for(Node n: node.children){
    // levelswisebyMe(n,i);
    // }

    // }
    // public static void levelswisebyMeinLine(Node node,int i){
    // if(i==0){
    // System.out.println(node.data);
    // i++;
    // }
    // int x=0;//it is added for removing unwanted line change
    // for(Node n: node.children){
    // System.out.print(n.data+" ");
    // x=1;
    // }
    // if(x==1){

    // System.out.println();
    // }
    // for(Node n: node.children){
    // levelswisebyMeinLine(n,i);
    // }

    // }
    // public static void levelswisebyMeinZigZagLine(Node node,int i){
    // if(i==0){
    // System.out.println(node.data);
    // i++;
    // }
    // int x=0;//it is added for removing unwanted line change
    // if(i%2!=0){
    // for(int s=node.children.size()-1; s>=0 ;s--){
    // System.out.print(node.children.get(s).data+" ");
    // x=1;

    // }
    // i++;
    // }
    // else{

    // for(Node n: node.children){
    // System.out.print(n.data+" ");
    // x=1;
    // }
    // i++;
    // }
    // if(x==1){

    // System.out.println();
    // }
    // for(Node n: node.children){
    // levelswisebyMeinZigZagLine(n,i);
    // }

    // }
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node() {

        }

        Node(int data) {
            this.data = data;

        }
    }

    public static void main(String[] args) {
        // int [] arr ={10,20,-1,30,50,-1,60,-1,-1,40,-1};
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };
        Node root = null;
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];
                if (st.size() == 0) {
                    root = t;
                } else {
                    st.peek().children.add(t);

                }
                st.push(t);
            }
        }

        display(root);
        // order(root);
        levelswise(root);
        System.out.println();
        // levelswisebyMe(root, 0);//you just have to pass one extra value for printing
        // the root data and 'i' must be always zero
        levelswiseinline(root);
        System.out.println();
        levelswiseinline2(root);
        System.out.println();
        levelswiseinline3(root);
        System.out.println("d");
        levelswiseinline4(root);
        System.out.println();
        levelswiseinZigZagline(root);
        System.out.println();
        // mirror(root);
        // display(root);
        removeleafNode(root);
        levelswiseinline4(root);
        System.out.println();
        // levelswisebyMeinZigZagLine(root,0);

    }
}
