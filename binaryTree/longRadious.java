import java.util.Stack;

import org.w3c.dom.Node;

public class longRadious {
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
    public static int heightt(Node node){
        if(node==null){
            return -1;// if hight in term of edges so return -1
        }
        int hlt=heightt(node.lch);
        int hrt=heightt(node.rch);
        int mh=Math.max(hlt, hrt)+1;

        return mh;
    }
    // this technique give result in order of 'n^2' time O(n^2)
    public static int deepestdia(Node n){
        if (n==null) {
            return 0;
        }
        int ld=deepestdia(n.lch);
        int  rd=deepestdia(n.rch);
        int lrd=heightt(n.lch)+heightt(n.rch)+2;
        int dia=Integer.max(lrd,Integer.max(rd, ld));
        return dia;

    }
    // this technique give result in order of 'n' time O(n)
    public static class Diapair{
        int ht;
        int dia;
    }
    public static Diapair deepestdia1(Node node){
        if(node==null){
            Diapair n=new Diapair();
            n.dia=0;
            n.ht=-1;
            return n;
        }
        Diapair lp = deepestdia1(node.lch);
        Diapair rp = deepestdia1(node.rch);
        
        Diapair mp=new Diapair();
        mp.ht=Integer.max(lp.ht ,rp.ht)+1;

        int lrd=lp.ht+rp.ht+2;
        mp.dia=Integer.max(lrd, Integer.max(lp.dia, rp.dia));
        return mp;
    }
    public static void main(String[] args) {
     Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70,72,74,76,null,null,null,null,null, 84, null,86,
                null,88,90,92 ,null,null,null,null };
        Node root=cr_tree(arr);
        print(root);
        System.out.println();   
        System.out.println("Maximum radious = "+deepestdia(root));
        System.out.println("Maximum radious = "+deepestdia1(root).dia);
        // System.out.println("Maximum radious = "+n1+n2);
    }
}
