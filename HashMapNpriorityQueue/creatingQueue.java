public class creatingQueue {
    public static class Node{
        int data; 
        Node lch;
        Node rch;
        public Node(int data, Node lch, Node rch){
            this.data=data;
            this.lch=lch;
            this.rch=rch;
        }
    }
    
    public static Node addNode(Node node,int data){
        if (node==null) {
            return new Node(data, null, null);
        }
        else if (node.data>=data) {
            node.lch= addNode(node.lch, data);
        }
        else {
            node.rch= addNode(node.rch, data);
        }
        return node;        
    }
    public static class Pair{
        int data;
        Node node;
        public Pair(int data, Node node){
            this.data=data;
            this.node=node;
        }
    }
    static int x;
    public static Pair deletNode(Node node){
        if (node.lch==null) {
            if (node.rch!=null) {
                x=node.data;
                return new Pair(x, node.rch);
            }
            x=node.data;
            return new Pair(x, null);
        }
        else{
            node.lch=deletNode(node.lch).node;

        }
        return new Pair(x, node);
    }
    public static int peeked(Node node){
        if (node.lch==null) {
            return node.data;
        }
        else{
            return peeked(node.lch);

        }
    }
    public static int sizes(Node root){
        if (root==null) {
            return 0;
        }
        int ls=sizes(root.lch);
        int rs=sizes(root.rch);
        return ls+rs+1;
    }
    public static class Pqueue{
        Node root;
        public Pqueue(){
            root=new Node(-1, null, null);
        }
        void add(int data){
            if (root.data==-1) {
                root.data=data;
            }
            else{

                root=addNode(root ,data );
            }
        }
        int remove(){
            Pair rp=deletNode(root);
            root=rp.node;
            return rp.data;
        }
        int size(){
            return sizes(root);
        }
        int peek(){
            return peeked(root);
        }
    }
    public static void main(String[] args) {
        Pqueue pq=new Pqueue();
        pq.add(12);
        pq.add(37);
        pq.add(25);
        pq.add(60);
        pq.add(50);
        pq.add(75);
        System.out.println(pq.peek());
        System.out.println(pq.size());
        System.out.println(pq.remove());
        System.out.println(pq.peek());
        System.out.println(pq.size());
    }
}
