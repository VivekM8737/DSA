import java.util.Scanner;

public class suduco {
    public static void solve(int[][] arr,int [] rows,int[] col,int [][] grid, int i, int j){
        if(i==arr.length){
            print(arr);
            return;
        }
        if (arr[i][j]>0) {
            solve(arr, rows, col, grid,j==arr[0].length-1?i+1:i, j==arr[0].length-1?0:j+1);
        }else{
            for (int num = 1; num <=9; num++) {
                if ((rows[i]&(1<<num))==0 && (col[j]&(1<<num))==0 && (grid[i/3][j/3]&(1<<num))==0 ) {
                    arr[i][j]=num;
                    rows[i]^=(1<<num);
                    col[j]^=(1<<num);
                    grid[i/3][j/3]^=(1<<num);
                    solve(arr, rows, col, grid,j==arr[0].length-1?i+1:i, j==arr[0].length-1?0:j+1);
                    arr[i][j]=0;
                    rows[i]^=(1<<num);
                    col[j]^=(1<<num);
                    grid[i/3][j/3]^=(1<<num);
                }
            }
        }
    }
    public static void print(int [][]arr){
        System.out.println(" Solution is: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        int [][] arr=new int[9][9];
        int [] rows=new int[9];
        int [] col=new int[9];
        int [][] grid=new int[3][3];
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < col.length; j++) {
                arr[i][j]=s.nextInt();
                rows[i]|=(1<<arr[i][j]);
                col[j]|=(1<<arr[i][j]);
                grid[i/3][j/3]=(1<<arr[i][j]);
            }
        }
        solve(arr, rows, col, grid,0,0);
    }
}
