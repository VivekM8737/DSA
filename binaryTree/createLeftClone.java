import java.util.Stack;

public class createLeftClone {
    public static class Node{
        int data;
        Node lt;
        Node rt;
        public Node(int data, Node lt, Node rt){
            this.data= data;
            this.rt=rt;
            this.lt=lt;
        }

    }
    public static class Pair{
        Node node;
        int n_cld;
        public Pair(Node node,int n_cld){
            this.node=node;
            this.n_cld=n_cld;
        }
    }
    public static Node cr_tree(Integer []arr){
        Node root= new Node(arr[0], null, null);
        Pair rPair=new Pair(root, 1);
        Stack<Pair> st =new Stack<>();
        st.push(rPair);
        int i=0;
        while(st.size()!=0){
            Pair top= st.peek();
            if(top.n_cld==1){
                i++;
                if(arr[i] != null){
                    Node n=new Node(arr[i], null, null);
                    Pair p=new Pair(n, 1);
                    st.push(p);
                    top.node.lt=n;
                    top.n_cld++;
                }
                else{
                    top.node.lt=null;
                    top.n_cld++;
                }

            }
            else if(top.n_cld==2){
                i++;
                if(arr[i]!=null){
                    Node n=new Node(arr[i], null, null);
                    Pair p=new Pair(n, 1);
                    st.push(p);
                    top.node.rt=n;
                    top.n_cld++;
                }
                else{
                    top.node.rt=null;
                    top.n_cld++;
                }

            }
            else {
                st.pop();
            }
        }
        return root;
    }
    public static Node leftClone(Node node){
        if(node==null){
            return null;
        }
        Node lcr=leftClone(node.lt);
        Node rcr=leftClone(node.rt);
        Node nn=new Node(node.data, lcr, null);
        node.lt=nn;
        node.rt=rcr;

        return node;
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
    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
            null, null };
    Node root=cr_tree(arr);
    // display(root);
    Node lc=leftClone(root);
    display(lc);
    }
}
