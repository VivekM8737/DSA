import java.util.ArrayList;
import java.util.Scanner;

public class numberOfIland {
    public static void countLand(int [][] matrix,int i,int j,ArrayList<String> temp){
        temp.add(i+""+j);
        matrix[i][j]=-1;
        if (i<matrix.length-1 && j<matrix[0].length-1 && matrix[i+1][j+1]==0) {
            countLand(matrix, i+1, j+1, temp);
        }
        if (i>0 && j>0 && matrix[i-1][j-1]==0) {
            countLand(matrix, i-1, j-1, temp);
        }
        if (i<matrix.length-1 && matrix[i+1][j]==0) {
            countLand(matrix, i+1, j, temp);
        }
        if ( j<matrix[0].length-1 && matrix[i][j+1]==0) {
            countLand(matrix, i, j+1, temp);
        }
    }
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        System.out.println("Enter the length of row and column: ");
        int row=s.nextInt();
        int col=s.nextInt();

        int [][] matrix=new int[row][col];
        System.out.println("Enter the element of matrix: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j]=s.nextInt();
            }
        }
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {
                ArrayList<String> temp=new ArrayList<>();

                if (matrix[i][j]==0) {
                    countLand(matrix,i,j,temp);
                    ans.add(temp);
                }
            }
        }
        System.out.println(ans);
        System.out.println("There are "+ans.size()+" lands");
    }
}
