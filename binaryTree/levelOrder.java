import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class levelOrder {
    public static class Pair {
        Node node;
        int child;

        public Pair(Node node, int child) {
            this.node = node;
            this.child = child;
        }
    }

    public static class Node {
        int data;
        Node rt;
        Node lt;

        public Node(int data, Node rt, Node lt) {
            this.data = data;
            this.rt = rt;
            this.lt = lt;
        }
    }

    public static Node crTree(Integer[] arr) {
        Node rn = new Node(arr[0], null, null);
        Pair rpt = new Pair(rn, 1);
        Stack<Pair> st = new Stack<>();
        st.push(rpt);
        int i = 0;
        while (st.size() != 0) {
            Pair top = st.peek();
            if (top.child == 1) {
                i++;
                if (arr[i] != null) {
                    Node lc = new Node(arr[i], null, null);
                    Pair lcp = new Pair(lc, 1);
                    top.node.lt = lc;
                    top.child++;
                    st.push(lcp);
                } else {
                    top.node.lt = null;
                    top.child++;
                }
            } else if (top.child == 2) {
                i++;
                if (arr[i] != null) {
                    Node rc = new Node(arr[i], null, null);
                    Pair rcp = new Pair(rc, 1);
                    top.node.rt = rc;
                    top.child++;
                    st.push(rcp);
                } else {
                    top.node.rt = null;
                    top.child++;
                }
            } else if (top.child == 3) {
                st.pop();
            }
        }
        return rn;

    }

    public static void display(Node node) {
        if (node == null) {
            return;

        }
        String st = "";
        st += node.lt == null ? "." : node.lt.data + " ";
        st += "<-" + node.data + "->";
        st += node.rt == null ? "." : node.rt.data + " ";
        System.out.println(st);
        display(node.lt);
        display(node.rt);
    }

    public static void levewise(Node node){
        Queue<Node> nq=new ArrayDeque<>();
        Queue<Node> cq=new ArrayDeque<>();
        nq.add(node);
        while(nq.size()>0 || cq.size()>0){
            if(nq.size()==0){
                System.out.println();
                nq=cq;
                cq=new ArrayDeque<>();
            }
            node=nq.remove();
            System.out.print(node.data+" ");
            if(node.lt!=null){
                cq.add(node.lt);
            }
            if(node.rt!=null){
                cq.add(node.rt);
            }
        }

        
    }
    public static void levewise2(Node node){
        Queue<Node> nq=new ArrayDeque<>();
        nq.add(node);
        while(nq.size()>0 ){
            int count=nq.size();
            for (int i = 0; i < count; i++) {
                node=nq.remove();
                System.out.print(node.data+" ");
                if(node.lt!=null){
                    nq.add(node.lt);
                }
                if(node.rt!=null){
                    nq.add(node.rt);
                }
            }
            System.out.println();
        }

        
    }

    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null, null };
        Node root = crTree(arr);
        display(root);
        levewise(root);
        System.out.println();
        levewise2(root);
        

    }
}
