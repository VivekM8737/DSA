import java.util.Scanner;

public class queenSafe {
    public static void show(int [][] arr,String ans,int row ){
        if(row==arr.length){
            System.out.println(ans);
            return;
        }
        for (int col = 0; col < arr.length; col++) {
            if(isItsafe(arr, row, col)==true){
                arr[row][col]=1;
                show(arr, ans+" "+row+"-"+col+",", row+1);
                arr[row][col]=0;
            }
        }   

    }
    public static boolean isItsafe(int [][] arr,int row,int col){
        for(int i=row-1; i>=0; i--){
            if(arr[i][col]==1){
                return false;
            }
        }
        for(int i=col-1,j=row-1; i>=0&& j>=0; i--,j--){
            if(arr[j][i]==1){
                return false;
            }
        }
        for(int i=row-1,j=col+1; i>=0 && j<arr.length; i--,j++){
            if(arr[i][j]==1){
                return false;
            } 
        }
        return true;
    
    }
    public static void main(String[] args) {
        // int [][] chess={{0,0,0},{0,0,0},{0,0,0}};
        // int [][]chess={{0,0},{0,0}};
        
        Scanner sn = new Scanner(System.in);
        int x=sn.nextInt();
        int [][]chess=new int[x][x];
        show(chess, "", 0);   
    }
}
