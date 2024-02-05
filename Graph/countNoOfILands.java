import java.util.Scanner;

public class countNoOfILands {
    public static void connectes(int [][] arr,int i,int j,boolean[][]visited){
        if (i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]==1 || visited[i][j]==true ) {
            return;
        }
        visited[i][j]=true;
        connectes(arr, i-1,j,visited);
        connectes(arr, i,j+1,visited);
        connectes(arr, i-1,j,visited);
        connectes(arr, i+1,j,visited);
    }
    public static void main(String[] args) throws Exception {
        Scanner s1 =new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int nrow=s1.nextInt();
        System.out.println("Enter the number of columns: ");
        int ncols=s1.nextInt();
        int [][] arr=new int[nrow][ncols];
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncols; j++) {
                arr[i][j]=s1.nextInt();
            }
        }
        boolean [][] visited =new boolean[nrow][ncols];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                
                visited[i][j]=false;
            }
        }
        int count=0;
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (visited[i][j]==false && arr[i][j]==0) {
                    connectes(arr, i,j,visited);
                    count++;
                }
            }
        }
        System.out.println(count);


    }
}
