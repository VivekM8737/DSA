import java.util.Stack;

public class sizeMaxHeightSum {
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
    static int size;
    static int height;
    static int max;
    static int sum;
    public static void multi(Node node,int depth){
        if(node==null){
            return;
        }
        size++;
        height=Math.max(height, depth);
        max=Math.max(max, node.data);
        sum+=node.data;
        multi(node.lt, depth+1);    
        multi(node.rt, depth+1);
        // Math.max(depth, depth)    

    }
    public static  int sizee(Node node){
        if(node== null){
            return 0;
        }
        int ln=sizee(node.lt);
        int rn=sizee(node.rt);
        return ln+rn+1;
    }
    public static  int summ(Node node){
        if(node== null){
            return 0;
        }
        int sln=node.data;
        sln+=summ(node.lt);
        sln+=summ(node.rt);
        return sln;
    }
    public static int maxx(Node node){
        if(node== null){
            return Integer.MIN_VALUE;
        }
        int lm=maxx(node.lt);
        int rm=maxx(node.rt);
        int max=Math.max(Math.max(lm, rm),node.data);
        return max;
    }
    public static int heightt(Node node){
        if(node==null){
            return 0;// if hight in term of edges so return -1
        }
        int hlt=heightt(node.lt);
        int hrt=heightt(node.rt);
        int mh=Math.max(hlt, hrt)+1;

        return mh;
    }

    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null, null };

        Node root=crTree(arr);
        display(root);
        height=0;
        max=Integer.MIN_VALUE;
        size=0;
        sum=0;
        multi(root, 0);
        System.out.println("Max = "+max);
        System.out.println("Size = "+size);
        System.out.println("Hieght in term of edges = "+height);
        System.out.println("Sum = "+sum);
        System.out.println("Seonde size fuction:"+ sizee(root));
        System.out.println("Seonde sum fuction:"+ summ(root));
        System.out.println("Max="+ maxx(root));
        System.out.println("Height in term of nodes="+ heightt(root));
    }
}
