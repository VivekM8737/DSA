import java.util.ArrayList;
import java.util.Stack;

public class sumPair {
    public static class Node{
        int data;
        Node rch;
        Node lch;
        public Node(int data,  Node lch,Node rch                                                               ){
            this.data=data;
            this.lch=lch;
            this.rch=rch;
        }
    }
    public static Node cBST(int []arr ,int si,int li){
        if (si>li) {
            return null;
        }
        int mid=(si+li)/2;
        int data=arr[mid];
        Node root = new Node(data, cBST(arr, si, mid-1), cBST(arr, mid+1,li));
        return root;
    }
    public static void print(Node n) {
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
    public static boolean find(Node node,int data){
        if (node==null) {
            return false;
        }
        if (node.data<data) {
            return find(node.rch, data);
        }
        else if(node.data>data){
            return find(node.lch, data);
        }
        else {
            return true;
        }
    }
    // space=O(h) and time=O(nh)
     public static void pair(Node node,Node mn,int sum){
        if (node==null) {
            return;
        }
        pair(node.lch,mn, sum);
        if (mn.data<(sum-node.data)) {
            if(find(mn, (sum-node.data))){
                System.out.println(node.data+ " "+(sum-node.data) );
            }
        }
        pair(node.rch, mn, sum);
        return;
     }
     public static ArrayList<Integer> vals(Node node,ArrayList<Integer> arr){
        if (node==null) {
            return new ArrayList<>();
        }
        vals(node.lch, arr);
        arr.add(node.data);
        vals(node.rch, arr);
        return arr;

     }
    //  space=O(n) and time= O(n)
     public static void parisum(Node node,int sum){
        ArrayList<Integer> a=new ArrayList<>();
        a=vals(node, a);
        int hi=a.size()-1;
        int  lo=0;
        while (lo<hi) {
            if ((a.get(lo)+a.get(hi))<sum) {
                lo++;
            }
            else if ((a.get(lo)+a.get(hi))>sum) {
                hi--;
            }
            else{
                System.out.println(a.get(lo)+" "+a.get(hi));
                hi--;
                lo++;
            }
        }
     }
    //  this code looks quite messi but it is efficient one int term of space and time both (O(hight) and O(n))
     public static class Pair{
        Node node;
        int state;
        public Pair(Node node, int state){
            this.node=node;
            this.state=state;
        }
     }
     public static Node leftNodes(Stack<Pair> st){
        while (st.size()>0) {
            Pair top=st.peek();
            if (top.state==0) {
                if (top.node.lch!=null) {
                    st.push(new Pair(top.node.lch, 0));
                }
                top.state++;
            }
            else if (top.state==1) {
                if (top.node.rch!=null) {
                    st.push(new Pair(top.node.rch, 0));
                }
                top.state++;
                return top.node;
            }
            else{
                st.pop();
            }
        }
        return null;
     }
     public static Node rightNodes(Stack<Pair> st){
        while (st.size()>0) {
            Pair top=st.peek();
            if (top.state==0) {
                if (top.node.rch!=null) {
                    st.push(new Pair(top.node.rch, 0));
                }
                top.state++;
            }
            else if (top.state==1) {
                if (top.node.lch!=null) {
                    st.push(new Pair(top.node.lch, 0));
                }
                top.state++;
                return top.node;
            }
            else{
                st.pop();
            }
        }
        return null;
     }
     public static void pairsum(Node node, int sum){
        Stack<Pair> ls=new Stack<>();
        Stack<Pair> rs=new Stack<>();
        ls.push(new Pair(node, 0));
        rs.push(new Pair(node, 0));
        Node left=leftNodes(ls);
        Node right=rightNodes(rs);
        while (left.data<right.data) {
            if ((left.data+right.data)<sum) {
                right=rightNodes(rs);
            }
            else if((left.data+right.data)>sum){
                left=leftNodes(ls);
            }
            else{
                System.out.println(left.data+" "+right.data);
                right=rightNodes(rs);
                left=leftNodes(ls);
            }

        }
     }
    public static void main(String[] args) {
        int [] arr={12,25,40,50,60,75,88};
        Node root=cBST(arr, 0, arr.length-1);
        print(root);
        // noderesplace(root);
        pair(root, root, 100);
        // ArrayList<Integer> a=new ArrayList<>();
        System.out.println();
        // System.out.println(vals(root,a));
        parisum(root, 100);
        System.out.println();
        pairsum(root, 100);
        
       
        
    }
}
