import java.util.ArrayList;
import java.util.Stack;

public class getSizeHightMInMax {
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

    static int size;
    static int min;
    static int max;
    static int height;

    private static void multitasker(Node node,int depth){
        size++;
        min=Math.min(node.data, min);
        max=Math.max(node.data, max);
        height=Math.max(height, depth);
        for(Node n:node.children){
            multitasker(n, depth+1);
        }
        
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
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
            -1 };
        int[] arr2 = { 5, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40,51,-1, -1,
            -1 };
        Node t1=creatGenericTree(arr);
        Node t2=creatGenericTree(arr2);
        
        display(t1);
        System.out.println("");
        display(t2);
        System.out.println("");
        size=0;
        min=Integer.MAX_VALUE;
        max=Integer.MIN_VALUE;
        height=0;
        multitasker(t1, height);
        // multitasker(t1, height);
        System.out.println(min);
        System.out.println(max);
        System.out.println(height);
        System.out.println(size);


        

    }
}
