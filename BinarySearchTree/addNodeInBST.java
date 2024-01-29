public class addNodeInBST {
    public static class Node{
        int data;
        Node rch;
        Node lch;
        public Node(int data,  Node lch,Node rch                                                               ){
            this.data=data;
            this.lch=lch;
            this.rch=rch;
        }
    }
    public static Node cBST(int []arr ,int si,int li){
        if (si>li) {
            return null;
        }
        int mid=(si+li)/2;
        int data=arr[mid];
        Node root = new Node(data, cBST(arr, si, mid-1), cBST(arr, mid+1,li));
        return root;
    }
    public static void print(Node n) {
        if (n == null) {
            return;
        }
        if (n.lch != null) {

            System.out.print(n.lch.data);
        } else {
            System.out.print(".");
        }
        System.out.print("<-" + n.data + "->");
        if (n.rch != null) {

            System.out.print(n.rch.data);
        } else {
            System.out.print(".");
        }
        System.out.println();
        print(n.lch);
        print(n.rch);
    }
    public static void addnode(Node node, int data){
        if (node.data<data) {
            if (node.rch==null) {
                
                Node n =new Node(data, null, null);
                node.rch=n;
                return;
            }
            else{
                addnode(node.rch,data);
            }
        }
        else if (node.data>=data) {
            if (node.lch==null) {
                Node n = new Node(data, null, null);
                node.lch=n;
                return;
            }
            else{

                addnode(node.lch,data);
            }
        }
    }
        public static Node addnode1(Node node , int data){
            if (node==null) {
                Node n = new Node(data, null,null);
                return n;
            }
            if (node.data>data) {
                node.lch=addnode1(node.lch, data);
            }
            else if (node.data<data) {
                node.rch=addnode1(node.rch, data);
            }
            return node;
        }
    public static void main(String[] args) {
        int [] arr={12,25,37,50,60,75,87};
        Node root=cBST(arr, 0, arr.length-1);
        print(root);
        // addnode(root, 10);
        addnode1(root, 11);
        System.out.println();
        print(root);
    }
}
