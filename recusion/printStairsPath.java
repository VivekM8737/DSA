public class printStairsPath {
    
    public static void pStair(int n,String path)
    {
        if(n==0){
            System.out.print(path+" ");
            return;
        }
        else if(n<0){
            return;
        }
        pStair(n-1, path+'1');
        pStair(n-2, path+'2');
        pStair(n-3, path+'3');

    }
    public static void main(String[] args) {
        pStair(4, "");
    }
}
