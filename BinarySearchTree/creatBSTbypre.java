public class creatBSTbypre {
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
    }static int ind=0;
    public static Node cBSTPree(int[] arr, int lr,int rr){
        if (ind>=arr.length || arr[ind]<lr||arr[ind]>rr ) {
            // ind--;
            return null;
        }
        Node root=new Node(arr[ind], null, null);
        ind++;
        root.lch=cBSTPree(arr, lr, arr[ind-1]);
        root.rch=cBSTPree(arr, arr[ind-1], rr);
        
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

    public static void main(String[] args) {
        // int [] arr={12,25,37,50,60,75,87};
        int [] arr={30,20,10,15,25,23,39,35,42};
        // Node root=cBST(arr, 0, arr.length-1);
        ind=0;
        Node root= cBSTPree(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
        print(root);
    }
}
