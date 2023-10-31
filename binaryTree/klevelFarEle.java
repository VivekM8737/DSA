import java.util.ArrayList;
import java.util.Stack;

public class klevelFarEle {
    public static class Pair{
        Node n;
        int cnum;
        public Pair(Node n, int cnum){
            this.n=n;
            this.cnum=cnum;
        }
    } 
    public static class Node{
        int data;
        Node lt;
        Node  rt;
        public Node(int data, Node lt, Node rt){
            this.data=data;
            this.lt=lt;
            this.rt=rt;
        }
    } 
    public static Node crTree(Integer [] arr){
        Stack<Pair> st=new Stack<>();
        Node root= new Node(arr[0], null, null);
        
        st.push(new Pair(root,1));
        int i=0;
        while(st.size()>0){
            
            Pair p=st.peek();
            if(p.cnum==1){
                i++;
                if(arr[i]!=null){
                    Node c=new Node(arr[i], null, null);
                    Pair cp=new Pair(c, 1);
                    p.n.lt=c;
                    st.push(cp);
                    p.cnum++;
                }
                else{
                    p.n.lt=null;
                    p.cnum++;
                }
            }
            else if(p.cnum==2){
                i++;
                if(arr[i]!=null){
                    
                    Node c=new Node(arr[i], null, null);
                    Pair cp=new Pair(c, 1);
                    p.n.rt=c;
                    st.push(cp);
                    p.cnum++;
                }
                else{
                    p.n.rt=null;
                    p.cnum++;
                }
            }
            else{
                st.pop();
            }
        }

        return root;
    }
    static ArrayList<Node> path;
    public static boolean find(Node node,int data){
       if(node==null){
        return false;
       }
       if(node.data==data){
            path.add(node);
           return true;
        }
        boolean x= false;
        x=find(node.lt, data);
        if(x){
            path.add(node);
            return x;
        }
        x=find(node.rt, data);
        if(x){
            path.add(node);
            return x;
        }
    
       return false;       

    }
    // public static 
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
    public static void showele(Node root,int val,int k){
        path =new ArrayList<>();
        find(root, val);
        for(int i=0; i<path.size(); i++){
            knodofar(path.get(i), k-i,i==0? null:path.get(i-1));
        }

    }
    public static void knodofar(Node node, int k, Node blocker){
        if(node==null || k<0 || node==blocker){
            return;
        }
        
        if(k==0){
            
            System.out.print(node.data+" ");
        }
        knodofar(node.lt, k-1,blocker);
        knodofar(node.rt, k-1,blocker);

    }
    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12,11, null,null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null, null };
        Node root=crTree(arr);
        display(root);
        // System.out.println(find(root, 25));
        System.out.println();
        // System.out.println(path.get(1).lt.data);
        showele(root, 25, 2);

        
    }

}
