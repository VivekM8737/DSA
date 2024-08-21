import java.util.HashSet;

public class knightsMove {
    public static void getMoves(int[][] board,int i,int j,int move ){
        if (i>=board.length || j>=board[0].length || j<0 || i<0 ||board[i][j]>0) {
            return;
        }
        if (move==board.length*board.length-1) {
           board[i][j]=move;
           display(board);
           board[i][j]=0;
           return;
        }
        board[i][j]=move;
        getMoves(board, i-2, j+1,move+1);
        getMoves(board, i-1, j+2,move+1);
        getMoves(board, i+1, j+2,move+1);
        getMoves(board, i+2, j+1,move+1);
        getMoves(board, i+2, j-1,move+1);
        getMoves(board, i+1, j-2,move+1);
        getMoves(board, i-1, j-2,move+1);
        getMoves(board, i-2, j-1,move+1);
        board[i][j]=0;
    }
    public static void display(int[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] +" ");
                
            }
            System.out.println();
            
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int [][] board=new int[5][5];
        for (int i = 0; i <board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j]=0;
            }
        }
        getMoves(board, 2, 2, 1);

    }
}
