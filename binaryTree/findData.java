import java.util.ArrayList;
import java.util.Stack;

public class findData{
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
    static ArrayList<Integer> path;
    public static boolean find(Node node,int data){
       if(node==null){
        return false;
       }
       if(node.data==data){
            path.add(node.data);
           return true;
        }
        boolean x= false;
        x=find(node.lt, data);
        if(x){
            path.add(node.data);
            return x;
        }
        x=find(node.rt, data);
        if(x){
            path.add(node.data);
            return x;
        }
    
       return false;       

    }

    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null, null };
        Node root=crTree(arr);
        display(root);
        path =new ArrayList<>();
        System.out.println(find(root, 70));
        System.out.println(path);
    }
}