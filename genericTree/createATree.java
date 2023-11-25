import java.util.ArrayList;
import java.util.Stack;

public class createATree {
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
    
    public static int size(Node node) {
        int x = 0;
        for (Node n : node.children) {
            int cs = size(n);
            x = x + cs;
            // System.out.println(x);
        }
        x = x + 1;
        return x;
    }

    public static int max_(Node node) {
        int mx = Integer.MIN_VALUE;

        for (Node n : node.children) {
            int cx = max_(n);
            mx = Math.max(mx, cx);// this is inbuild method to find the greater number
        }
        mx = Math.max(mx, node.data);

        return mx;
    }
    public static int height(Node node){
        int h=-1;
        
        for(Node n:node.children){
           int hm=height(n);
            h=Math.max(h, hm);
        }
        h=h+1;
        return h;
    }
    public static void order(Node node){
        System.out.println("Node pre "+node.data);
        for(Node n: node.children){
            System.out.println("edge pre "+node.data+"-"+n.data);
            order(n);
            System.out.println("Node post "+node.data);
        }
    }
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }


    public static void main(String[] args) {
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110,106,-1, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
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
        // System.out.println(size(root));
        // System.out.println(max_(root));
        // size(root);
        System.out.println(height(root));
        order(root);
    }
}