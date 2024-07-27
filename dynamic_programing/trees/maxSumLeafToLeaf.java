import binaryTree;
import Node;
public class maxSumLeafToLeaf {
    static int res;
    public static int maxSum_(Node root){
        if (root==null) {
            return 0;
        }
        int lf_res=maxSum_(root.left);
        int rt_res=maxSum_(root.right);

        int temp;
        temp=root.data+Math.max(lf_res, rt_res);
        if (root.left==null && root.right==null) {
            temp=Math.max(root.data, temp);
        }
        int self=Math.max(root.data+lf_res+rt_res, temp);

        res=Math.max(res, self);
        return temp;
    }
    public static void main(String[] args) {
        Integer[] arr={10,-7,4,null,null,-9,null,null,15,12,11,null,null,13,null,null,8,null,null};


        binaryTree bt= new binaryTree();
        Node root= bt.creatBinaryTree(arr);
        bt.print(root);
                
        System.out.println(maxSum_(root));
        System.out.println(res);
    }
}
