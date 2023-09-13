import java.util.ArrayList;
import java.util.Stack;

public class aresemetric {
    private static boolean checkmirror(Node node,Node node2){
        if(node.children.size()!=node2.children.size()){
            return false;
        }
        for(int i=0; i<node.children.size();i++){
            Node n1=node.children.get(i);
            Node n2=node2.children.get((node.children.size()-1)-i);
            
            if(!checkmirror(n1, n2)){
                return false;
            }
        }   
        return true;
    }
    private static boolean semitric(Node node){
        
        return checkmirror(node, node);
    }
    public static void display(Node node) {
        String str = node.data + "-->";
        for (Node n : node.children) {
            str += n.data + " ";
        }
        System.out.println(str + ".");
        for (Node n : node.children) {
            display(n);
        }
    }
    private static class Node{
        int data;
        ArrayList<Node> children =new ArrayList<>();
    }
    private static Node creatGenericTree(int []arr){
        Stack<Node> st=new Stack<>();
        Node root=null;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==-1){
                st.pop();
            }
            else{
                Node t= new Node();
                t.data=arr[i];
                if(st.size()==0){
                    root=t;
                }
                else{
                    st.peek().children.add(t);
                }
                st.push(t);

            }
        }
        return root;
    }
    public static void main(String[] args) {
        int[] arr = { 10, 20, 50, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
            -1 };
        Node t1=creatGenericTree(arr);
        
        display(t1);
        System.out.println("");
     
        System.out.println(semitric(t1));
        

    }
}
