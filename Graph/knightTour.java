
import java.util.Scanner;

public class knightTour {
    public static void knightPaths(int [][] bord,int i,int j,int move){
        if (i<0 || j<0 || i>=bord.length || j>=bord[0].length || bord[i][j]!=0 ) {
            return;
        }else if (move==bord.length*bord.length) {
            bord[i][j]=move;
            display(bord);
            bord[i][j]=0;
        }
        bord[i][j]=move;
        knightPaths(bord, i-2, j+1,move+1);
        knightPaths(bord, i-1, j+2,move+1);
        knightPaths(bord, i+1, j+2,move+1);
        knightPaths(bord, i+2, j+1,move+1);
        knightPaths(bord, i+2, j-1,move+1);
        knightPaths(bord, i+1, j-2,move+1);
        knightPaths(bord, i-1, j-2,move+1);
        knightPaths(bord, i-2, j-1,move+1);
        bord[i][j]=0;

    }
    public static void display(int [][] bord){
        int n=bord.length;
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(bord[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.println("Enter the size of bord: ");
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int [][] bord=new int[n][n];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                bord[i][j]=0;
            }
        }
        System.out.println("Enter the position of knight: ");
        int x=s.nextInt();
        int y=s.nextInt();
        knightPaths(bord,x, y,1);

    }
}
