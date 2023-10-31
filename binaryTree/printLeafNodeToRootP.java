import java.util.ArrayList;
import java.util.Stack;

public class printLeafNodeToRootP {
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
    public static void showpath(Node node,Node root){
        if(node==null){
            return;
        }
        if(node.lt==null && node.rt==null){
            path =new ArrayList<>();
            find(root, node.data);
            System.out.println(path);
        }
        showpath(node.lt,root);
        showpath(node.rt,root);

    }
    public static void leaftohead(Node node,int hi,int low, int sum, String path){
        if(node==null){
            return;
        }
        if(node.lt==null && node.rt==null){
            sum+=node.data;
            if(sum>low && sum<hi ){
                System.out.println(path+node.data);
            }
            return;
        }
        leaftohead(node.lt, hi, low, sum+node.data, path+node.data+" ");
        leaftohead(node.rt, hi, low, sum+node.data, path+node.data+" ");
    }
    public static void main(String [] arg){
        Integer[] arr = { 50, 25, 12,11, null,null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
            null, null };
        Node root=crTree(arr);
        display(root);
        leaftohead(root, 500, 0, 0, "");
        // showpath(root,root);
    }
}
