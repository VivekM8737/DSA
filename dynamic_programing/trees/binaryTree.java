import java.util.Stack;
import Node;

public class binaryTree {
    // public static class Node{
    //     int data;
    //     Node left;
    //     Node right;
    //     public Node(int data,Node left, Node right){
    //         this.data=data;
    //         this.left=left;
    //         this.right=right;
    //     }
    // }
    public static class Pair {
        Node node;
        int n_cld;
        public Pair(Node n,int n_cld){
            this.node=n;
            this.n_cld=n_cld;
        }
        
    }
     public static Node creatBinaryTree(Integer[] arr){
        Stack<Pair> st=new Stack<>();
        Node root=new Node(arr[0], null, null);
        st.push(new Pair(root, 0));
        int i=0;
        while (st.size()>0) {
            Pair top=st.peek();
            if (top.n_cld==0) {
                i++;
                if (arr[i]!=null) {
                    Node temp=new Node(arr[i], null, null);
                    top.node.left=temp;
                    top.n_cld++;
                    st.push(new Pair(temp, 0));
                }else{
                    top.node.left=null;
                    top.n_cld++;
                }
            }
            else if(top.n_cld==1){
                i++;
                if (arr[i]!=null) {
                    Node temp=new Node(arr[i], null, null);
                    top.node.right=temp;
                    top.n_cld++;
                    st.push(new Pair(temp, 0));
                }else{
                    top.node.right=null;
                    top.n_cld++;
                }
            }else{
                st.pop();
            }
        }
        return root;
    }
    public static void print(Node root){
        if (root==null) {
            return;
        }
        if (root.left!=null && root.right!=null) {
            System.out.println(root.left.data+"<-"+root.data+"->"+root.right.data);
        }
        else if (root.left==null && root.right!=null) {
            System.out.println("."+"<-"+root.data+"->"+root.right.data);
        }
        else if (root.left!=null && root.right==null) {
            System.out.println(root.left.data+"<-"+root.data+"->"+".");
        }
        else{
            System.out.println("."+"<-"+root.data+"->"+".");
        }
        print(root.left);
        print(root.right);
    }
    public static void main(String[] args) {
        // Node n=new Node();
        Integer[] arr={10,7,4,null,null,8,null,null,15,12,11,null,null,13,null,null,16,null,null};
        Node root=creatBinaryTree(arr);
        print(root);
    }
}
