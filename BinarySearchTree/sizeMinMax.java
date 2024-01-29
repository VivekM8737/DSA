public class sizeMinMax {
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
    public static int sum(Node node){
        if (node==null) {
            return 0;
        }
        int ls=sum(node.lch);
        int rs=sum(node.rch);
        int summ=ls+rs+node.data;
        return summ;
    }
    public static int size(Node node){
        if (node==null) {
            return 0;
        }
        int ls=size(node.lch);
        int rs=size(node.rch);
        int sizes=ls+rs+1;
        return sizes;
    }
    public static int min(Node node){
        if (node==null) {
            return Integer.MAX_VALUE;
        }
        int lm=min(node.lch);
        int minn=Math.min(node.data, lm);
        return minn;
    }
    public static int max(Node node){
        if (node==null) {
            return Integer.MIN_VALUE;
        }
        int lm=max(node.rch);
        int max=Math.max(node.data, lm);
        return max;
    }
    public static int maxx(Node node){
        if (node.rch!=null) {
            return max(node.rch);
        }else{
            return node.data;
        }
    }
    public static int minn(Node node){
        if (node.lch!=null) {
            return minn(node.lch);
        }else{
            return node.data;
        }
    }
    public static boolean find(Node node,int data){
        if (node==null) {
            return false;
        }
        if (node.data<data) {
            return find(node.rch, data);
        }
        else if(node.data>data){
            return find(node.lch, data);
        }
        else {
            return true;
        }
    }


    public static void main(String[] args) {
        int [] arr={12,25,37,50,60,75,87};
        Node root=cBST(arr, 0, arr.length-1);
        print(root);
        System.out.println(sum(root));
        System.out.println(size(root));
        System.out.println(min(root));
        System.out.println(max(root));
        System.out.println(minn(root));
        System.out.println(maxx(root));
       
        System.out.println( find(root, 12));
    }
}
