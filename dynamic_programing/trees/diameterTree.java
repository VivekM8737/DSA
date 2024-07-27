import binaryTree;
import Node;
class diameterTree{
    static int result;
    public static int diamerter(Node root,int res){
        if (root==null) {
            return 0;
        }
        int lDia=diamerter(root.left, res);
        int rDia=diamerter(root.right, res);

        int temp=1+Math.max(lDia, rDia);
        int self=1+lDia+rDia;
        res=Math.max(self, res);
        result=res;

        return temp;
    }
    public static void main(String[] args) {
        Integer[] arr={10,7,4,null,null,8,null,null,15,12,11,null,null,13,null,null,16,null,null};
        binaryTree bt= new binaryTree();
        Node root= bt.creatBinaryTree(arr);
        bt.print(root);
        

        System.out.println(diamerter(root, 0));
        System.out.println(result);
    }
}