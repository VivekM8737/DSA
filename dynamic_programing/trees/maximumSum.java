import binaryTree;
import Node;

public class maximumSum {
    static int result;
    public static int maxSum_(Node root){
        if (root==null) {
            return 0;
        }
        int lval=maxSum_(root.left);
        int rval=maxSum_(root.right);

        int temp = Math.max(root.data,root.data+Math.max(lval, rval));

        int self=Math.max(root.data+lval+rval, temp);

        result=Math.max(result, self);
        return temp;
    }
   
    public static void main(String[] args) {
        Integer[] arr={10,-7,4,null,null,-9,null,null,15,12,11,null,null,13,null,null,9,null,null};


        binaryTree bt= new binaryTree();
        Node root= bt.creatBinaryTree(arr);
        bt.print(root);
                
        System.out.println(maxSum_(root));
        System.out.println(result);


    }
}
