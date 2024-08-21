import java.util.Arrays;
import java.util.Scanner;

public class nqueen {
    
    public static void display(int [][] chess){
        for (int i = 0; i < chess.length; i++) {
            for (int k = 0; k < chess.length; k++) {
                System.out.print(chess[i][k]+" ");
                
            }
            System.out.println();
            
        }
        System.out.println();
    }
    public static void solve(int [][] chess, int i,int cb, int nd, int rd,String res ){
        if(i==chess.length){
            display(chess);
            System.out.println(res);
            return;
        }
        for (int k = 0; k < chess.length; k++) {
            if ((cb &(1<<k))==0 && (nd &(1<<(i+k)))==0 && (rd &(1<<(i-k+chess.length-1)))==0 ) {
                chess[i][k]=1;
                cb^=(1<<k);
                nd^=(1<<(i+k));
                rd^=(1<<(i-k+chess.length-1));
                solve(chess, i+1, cb,nd,rd,res+i+"-"+k+",");
                chess[i][k]=0;
                cb^=(1<<k);
                nd^=(1<<(i+k));
                rd^=(1<<(i-k+chess.length-1));
            }
        }
        
    }
    public static void main(String[] args) {
        System.out.println("Enter the value of n: ");
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        int [][] chess=new int[n][n];
        // Arrays.fill(chess,0);

        
        solve(chess, 0 ,0,0,0,"");
        
    }
}
