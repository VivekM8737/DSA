import java.util.Stack;

import org.w3c.dom.Node;

public class transformbackFromleftclone {
        public static class Pair{
        Node node;
        int cldn;
        public Pair(Node node,int child){
            this.node=node;
            cldn=child;
        }
    }
    public static class Node{
        Integer data;
        Node lch;
        Node rch;
        public Node(Integer data,Node lch,Node rch){
            this.data=data;
            this.lch=lch;
            this.rch=rch;
        }

    }
    public static Node cr_tree(Integer [] arr){
        Node rt=new Node(arr[0], null, null);
        Pair prt=new Pair(rt, 1);
        Stack<Pair> st =new Stack<>();
        st.push(prt);
        int i=0;
        while(st.size()!=0){
            Pair x=st.peek();
            if(x.cldn==1){
                i++;
                if(arr[i]!=null){

                    Node ln=new Node(arr[i], null, null);
                    Pair pln=new Pair(ln, 1);
                    x.node.lch=ln;
                    st.push(pln);
                    x.cldn++;

                }
                else{
                    x.node.lch=null;
                    x.cldn++;
                }
            }
            else if(x.cldn==2){
                i++;
                if(arr[i]!=null){

                    Node rn=new Node(arr[i], null, null);
                    Pair prn=new Pair(rn, 1);
                    x.node.rch=rn;
                    st.push(prn);
                    x.cldn++;

                }
                else{
                    x.node.rch=null;
                    x.cldn++;
                }
            }
            else if(x.cldn==3){
                st.pop();
            }
        }
        return rt;
    }
    public static void print(Node n){
        if (n==null) {
            return;
        }
        if(n.lch!=null){

            System.out.print(n.lch.data);
        }else{
            System.out.print(".");
        }
        System.out.print("<-"+n.data+"->");
        if(n.rch!=null){

            System.out.print(n.rch.data);
        }else{
            System.out.print(".");
        }
        System.out.println();
        print(n.lch);
        print(n.rch);
    }
    public static Node Lclone(Node n){
        if(n==null){
            return null;
        }
        Node ln=Lclone(n.lch);
        Node rn = Lclone(n.rch);
        Node nn= new Node(n.data, ln, null);
        n.lch=nn;
        n.rch=rn;
        return n;
    }
    public static Node bypreOrderreverceToOriginal(Node n){
        if(n==null){
            return null;
        }
        if(n.lch==null){
            n.lch=null;
        }
        else{
            n.lch=n.lch.lch;
        }
        n.rch=n.rch;
        Node ln=bypreOrderreverceToOriginal(n.lch);
        Node rn = bypreOrderreverceToOriginal(n.rch);
        return n;
    }
    public static Node byPostreverceToOriginal(Node n){
        if(n==null){
            return null;
        }
        Node ln=byPostreverceToOriginal(n.lch.lch);
        Node rn = byPostreverceToOriginal(n.rch);
        n.lch=ln;
        n.rch=rn;
        return n;
    }
    public static void main(String[] args) {
     Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null, null };
        Node root=cr_tree(arr);
        print(root);
        Lclone(root);   
        // print(root);
        System.out.println();
        byPostreverceToOriginal(root);  
        print(root);
    }
}
