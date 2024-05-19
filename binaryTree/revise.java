import java.util.Stack;

public class revise {
    public static class Pair {
        Node node;
        int n_ch;

        public Pair(Node node, int n_ch) {
            this.n_ch = n_ch;
            this.node = node;
        }

    }

    public static class Node {
        int data;
        Node lch;
        Node rch;

        public Node(int data, Node lch, Node rch) {
            this.data = data;
            this.lch = lch;
            this.rch = rch;
        }

    }

    public static Node creat_bt(Integer[] arr){
        Stack<Pair> st=new Stack<>();
        Node rt=new Node(arr[0], null, null);
        st.push(new Pair(rt,0));
        int i=0;
        while (st.size()>0) {
            Pair p=st.peek();
            if (p.n_ch==0) {
                i++;
                if (arr[i]!=null) {
                
                    Node l_ch=new Node(arr[i], null, null);
                    p.node.lch=l_ch;
                    st.push(new Pair(l_ch, 0));
                    p.n_ch++;

                }
                else{
                    p.n_ch++;

                }
            }
            else if (p.n_ch==1) {
                i++;
                if (arr[i]!=null) {
                    Node r_ch=new Node(arr[i], null, null);
                    p.node.rch=r_ch;
                    st.push(new Pair(r_ch, 0));
                    p.n_ch++;

                }
                else{
                    p.n_ch++;
                }
            }
            else{
                    st.pop();
            }
            
        }
        return rt;
    }

    public static void print(Node n) {
        if (n == null) {
            return;
        }
        if (n.lch != null && n.rch != null) {
            System.out.println(n.lch.data + "<-" + n.data + "->" + n.rch.data);
        } else if (n.lch != null && n.rch == null) {
            System.out.println(n.lch.data + "<-" + n.data + "->" + ".");
        } else if (n.lch == null && n.rch != null) {
            System.out.println("." + "<-" + n.data + "->" + n.rch.data);
        } else {
            System.out.println("." + "<-" + n.data + "->" + ".");

        }
        print(n.lch);
        print(n.rch);

    }

    public static void print1(Node n) {
        if (n == null) {
            return;
        }
        if (n.lch != null) {

            System.out.print(n.lch.data);
        } else {
            System.out.print(".");
        }
        System.out.print("<-" + n.data + "->");
        if (n.rch != null) {

            System.out.print(n.rch.data);
        } else {
            System.out.print(".");
        }
        System.out.println();
        print(n.lch);
        print(n.rch);
    }

    public static void main(String[] args) {
        // Integer[] arr1 = { 50,10,5,null, null,20,null,null,70 ,null, null,null};
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null, null };
        Node root = creat_bt(arr);
        print1(root);
        System.out.println();
    }
}
