public class deleteNode {
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
    public static int max(Node node){
        if (node.rch!=null) {
            return max(node.rch);

        }
        else{
            return node.data;
        }
    }
    public static Node delNode(Node node, int data){
        if (node==null) {
            return null;
        }
        else if (node.data<data) {
            node.rch=delNode(node.rch, data);
        }
        else if (node.data>data) {
            node.lch=delNode(node.lch, data);
        }
        else{
            if (node.lch!=null && node.rch!=null) {
                int m=max(node.lch);
                delNode(node, m);
                node.data=m;
                return node;
            }
            else if (node.lch!=null) {
                return node.lch;   
            }
            else if (node.rch!=null) { 
                return node.rch;  
            }
            else{
                return null;
            }

        }
        return node;
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
        addnode1(root, 38);
        System.out.println();
        print(root);
        delNode(root, 37);
        System.out.println();
        print(root);

    }
}
