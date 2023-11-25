import java.util.ArrayList;
import java.util.Stack;

public class ceilAndFloar {
    static int ceil;
    static int floar;
    public static void findCeilFloar(Node node, int data){
        if(data<node.data && ceil>node.data){
            ceil=node.data;
        }
        if(data>node.data && floar<node.data){
            floar=node.data;
        }
        for(Node n:node.children){
            findCeilFloar(n, data);
        }


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
        int[] arr = { 10, 20, 50, -1,60,-1 -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
            -1 };
        Node t1=creatGenericTree(arr);
        
        display(t1);
        System.out.println("");
        ceil=Integer.MAX_VALUE;
        floar=Integer.MIN_VALUE;
        findCeilFloar(t1, 65);
        System.out.println("Ceil = "+ceil+" floar = "+floar);
        
        

    }
}
