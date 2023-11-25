import java.util.ArrayList;
import java.util.Stack;

public class radioudOfGenericTree {
    static int radious;

    private static int heightt(Node node) {
        int dch = -1;
        int sdch = -1;
        for (Node n : node.children) {
            int depth = heightt(n);
            if (depth > dch) {
                sdch=dch;
                dch=depth;
                
            } else if (depth > sdch) {
                sdch=depth;
            }
            
        }
        if(dch+sdch+2>radious){
            radious=dch+sdch+2;
        }
        dch+=1;
        return dch;

    }

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

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    private static Node creatGenericTree(int[] arr) {
        Stack<Node> st = new Stack<>();
        Node root = null;
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
        return root;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, -50, -1, -60, 61, -1, -1, -1, 30, -70, -1, 80, -110, 111, -1, -1, 120, -1, -1, 90, -1, -1,
                40, -100, -1, -1,
                -1 };
        Node t1 = creatGenericTree(arr);
        display(t1);
        System.out.println("");
        radious=Integer.MIN_VALUE;
        heightt(t1); 
        System.out.println(radious);

    }
}
