import java.util.ArrayList;
import java.util.Stack;

public class itretivePreNPost {
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
    public static class Pair{
        Node  node;
        int stage;
        public Pair(Node node,int st){
            this.node=node;
            this.stage=st;
        }
    }

    public static void priNpos(Node node){
        Stack<Pair> st=new Stack<>();
        st.push(new Pair(node,-1));
        String preOrder="";
        String posOrder="";
        while(st.size()>0){
            Pair top=st.peek();
            if(top.stage==-1){
                preOrder+= top.node.data +" ";
                top.stage++;
            }
            else if(top.stage==top.node.children.size()){
                posOrder+= top.node.data +" ";
                st.pop();
            }
            else{
                Pair cp=new Pair(node.children.get(top.stage), -1);
                st.push(cp);
                top.stage++;
            }
        }
        System.out.println(preOrder);
        System.out.println(posOrder);
    }
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    private static Node creatGenericTree(int[] arr) {
        Stack<Node> st = new Stack<>();
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];
                if (st.size() == 0) {
                    root = t;
                } else {
                    st.peek().children.add(t);
                }
                st.push(t);

            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, -50, -1, -60, 61, -1, -1, -1, 30, -70, -1, 80, -110, 111, -1, -1, 120, -1, -1, 90, -1, -1,
                40, -100, -1, -1,
                -1 };
        Node t1 = creatGenericTree(arr);
        display(t1);
        System.out.println("");
        priNpos(t1);

    }
}
