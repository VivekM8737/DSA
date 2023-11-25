import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class kthLargestNo {
    static int floar;
    public static void floarVal(Node node, int data){
        if(data>node.data && floar<node.data){
            floar=node.data;
        }
        for(Node n:node.children){
            floarVal(n, data);
        }


    }
    public static int kth(Node node,int k){
        floar =Integer.MIN_VALUE;
        int max=Integer.MAX_VALUE;
        
        for (int i = 0; i <k; i++) {
            floarVal(node, max);
            max=floar;
            floar =Integer.MIN_VALUE;
        }
        return max;
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
        Scanner sn=new Scanner(System.in);
        System.out.println("Enter the kth: ");
        int k=sn.nextInt();
        System.out.println(kth(t1, k));
        
        
        

    }
}
