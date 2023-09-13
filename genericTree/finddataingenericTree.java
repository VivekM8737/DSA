import java.util.ArrayList;
import java.util.Stack;

public class finddataingenericTree {
    private static boolean find(Node node,int data){
        if(node.data==data){
            return true;
        }
        for (Node n : node.children) {
            boolean fn=find(n, data);
            if(fn){
                return true;
            }
        }
        return false;
    }
    private static ArrayList<Integer> find2(Node node,int data){
        if(node.data==data){
            // System.out.println(node.data);
            ArrayList<Integer> li=new ArrayList<>();
            li.add(node.data);
            return li;
        }
        for (Node n : node.children) {
            ArrayList<Integer> fn=find2(n, data);
            if(fn.size()>0){
                // System.out.println(node.data);
                fn.add(node.data);
                return fn;
            }
        }
         
        return new ArrayList<>();
    }
    private static int lowestcommonAncestor(Node node,int c1,int c2){
        ArrayList<Integer> fca=find2(node, c1);
        ArrayList<Integer> sca=find2(node, c2);
        int i=fca.size()-1;
        int j=sca.size()-1;
        
        while(i>0 && j>0 &&fca.get(i)==sca.get(j)) {
            j--;
            i--;
        }
        i++;
        return fca.get(i);
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
    public static void main(String[] args) {
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
            -1 };
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
        display(root);
        // System.out.println(find(root, 100));
        System.out.println(find2(root, 110));
        // find2(root, 110);
        System.out.println(lowestcommonAncestor(root, 70, 110));

    }
}
