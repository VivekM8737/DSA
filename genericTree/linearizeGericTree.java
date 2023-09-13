import java.util.ArrayList;
import java.util.Stack;
public class linearizeGericTree {
    public static void linearise(Node node){

        for (Node n : node.children) {
            linearise(n);
        }
        while(node.children.size()>1){
            Node lc= node.children.remove(node.children.size()-1);
            Node slc= node.children.get(node.children.size()-1);
            Node slct=tail(slc);
            slct.children.add(lc);
        }
        
    }
    private static Node tail(Node node){
        while(node.children.size()==1){

            node=node.children.get(0);
        }
        return node;

    }
    public static Node linearise2(Node node){
        if(node.children.size()<=0){
            return node;
        }
        Node lkt=linearise2(node.children.get(node.children.size()-1));
        while(node.children.size()>1){
            Node lc= node.children.remove(node.children.size()-1);
            Node slc= node.children.get(node.children.size()-1);
            Node slct=linearise2(slc);
            slct.children.add(lc);
        }
        return lkt;
        
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
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node() {

        }
    }
    public static void main(String[] args) {
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };
        Node root = null;
        Stack<Node> st = new Stack<>();
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
        display(root);
        
        // linearise(root);
        // display(root);
        linearise2(root);
        display(root);
    }
}
