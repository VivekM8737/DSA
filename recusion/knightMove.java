import java.util.Scanner;

public class knightMove {
    public static void printkp(int [][]chess,int row, int col,int move){
        if(row<0 || col<0 || row>=chess.length || col>=chess.length || chess[row][col]>0 ){
            return;
        }
        else if(move==chess.length*chess.length){
            chess[row][col]=move;
            show(chess);
            chess[row][col]=0;
            return;
        }
        chess[row][col]=move;
        printkp(chess, row-2, col+1, move+1);
        printkp(chess, row-1, col+2, move+1);
        printkp(chess, row+1, col+2, move+1);
        printkp(chess, row+2, col+1, move+1);
        printkp(chess, row+2, col-1, move+1);
        printkp(chess, row+1, col-2, move+1);
        printkp(chess, row-1, col-2, move+1);
        printkp(chess, row-2, col-1, move+1);
        chess[row][col]=0;
    }
    public static void show(int[][]arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        System.out.println("Enter the size of arr: ");
        int x=sn.nextInt();
        System.out.println("Enter the position of knight in row: ");
        int r=sn.nextInt();
        System.out.println("Enter the position of knight in column: ");
        int c=sn.nextInt();
        int [][]chess=new int[x][x];
        printkp(chess, r,c,1);
    }
}
