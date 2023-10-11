import java.util.Stack;

public class triversel {
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
    
    public static void pre(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.data+" ");
        pre(node.lt);
        pre(node.rt);
    }
    public static void In(Node node){
        if(node==null){
            return;
        }

        In(node.lt);
        System.out.print(node.data+" ");
        In(node.rt);
    }
    public static void pos(Node node){
        if(node==null){
            return;
        }
        pos(node.lt);
        pos(node.rt);
        System.out.print(node.data+" ");
    }
    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null, null };
        Node root=crTree(arr);
        display(root);
        System.out.print("pre ");
        pre(root);
        System.out.println();
        System.out.print("In ");
        In(root);
        System.out.println();
        System.out.print("pos ");
        pos(root);
    }
}
