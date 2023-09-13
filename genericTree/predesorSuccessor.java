import java.util.ArrayList;
import java.util.Stack;

public class predesorSuccessor {
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

    static int predecessor;
    static int successor;
    static int next;
    static int pre;
    private static void preAndSuccessor(Node node,int data){
        for(Node n:node.children){
            if(n.data==data){
                predecessor=pre;
            }
            if(predecessor!=0){
                next++;
            }
            if(next==2){
                successor=n.data;
                return;
            }
            pre=n.data;
            preAndSuccessor(n,data);
        }
        
    }
    static int state;//sir used three variable and I used four
    private static void preAndSuccessorbysir(Node node,int data){
        if(state==0){
            if(node.data==data){
                state=1;
            }
            else{

                predecessor=node.data;
            }

        }
        else if(state==1){
            successor=node.data;
            state=2;
            return;
        }
        for(Node n:node.children){
            preAndSuccessorbysir(n,data);
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
        predecessor=0;
        successor=0;
        pre=0;
        next=0;
        preAndSuccessor(t2, 51);
        System.out.println(predecessor);
        System.out.println(successor);
        predecessor=0;
        successor=0;
        state=0;
        preAndSuccessorbysir(t2, 51);
        System.out.println(predecessor);
        System.out.println(successor);
       


        

    }
}
