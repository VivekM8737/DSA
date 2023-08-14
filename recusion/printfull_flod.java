public class printfull_flod {
    public static void fill_flod(int arr1[][],int n,int m, String ans){
        if(n<0 || m<0 || n==arr1.length || m==arr1[0].length || arr1[n][m]==1){
            return;
        }
        if(n==arr1.length-1 && m==arr1[0].length-1){
            System.out.println(ans);
            return;
        }
        arr1[n][m]=1;
        fill_flod(arr1, n-1, m, ans+"t");
        fill_flod(arr1, n+1, m, ans+"d");
        fill_flod(arr1, n, m+1, ans+"r");
        fill_flod(arr1, n-1, m, ans+"l");
        arr1[n][m]=0;
            
        

    }
    public static void main(String[] args) {
        int arr[][]={{0,1,1},{0,0,0},{1,0,0},{0,1,0}};
        int row=4;
        int col=3;
        fill_flod(arr, 0, 0, "");

    }
}
