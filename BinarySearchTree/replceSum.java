public class replceSum {
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
    static int sum=0;
    public static void noderesplace(Node node){
        if (node==null) {
            return;
        }
        noderesplace(node.rch);
        int od=node.data;
        node.data=sum;
        sum+=od;
        noderesplace(node.lch);
    } 
    public static void main(String[] args) {
        int [] arr={12,25,37,50,60,75,87};
        Node root=cBST(arr, 0, arr.length-1);
        print(root);
        noderesplace(root);
        System.out.println();
        print(root);
    }
}
