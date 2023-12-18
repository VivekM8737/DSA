import java.util.ArrayList;

public class LCS {
    static int [][] t=new int[100][100]; 
    public static int lcs_len(String x,String y,int xlen,int ylen){
        if(xlen==0 || ylen==0){
            return 0;
        }
        if(t[xlen][ylen]!=-1){
            return t[xlen][ylen];
        }
        if(x.charAt(xlen-1)==y.charAt(ylen-1)){
            return t[xlen][ylen]=1+lcs_len(x, y,xlen-1,ylen-1);
        }
        else{
            return t[xlen][ylen]=Math.max(lcs_len(x, y,xlen-1,ylen),lcs_len(x, y, xlen, ylen-1));
        }
    }
    // this code it know as top down aproch of dp and upper one is called memoization version ... 
    public static int lcs_len2(String x,String y,int xlen,int ylen){
        int [][] dpt=new int[xlen+1][ylen+1];
        for (int i = 0; i < xlen+1; i++) {
            for (int j = 0; j < ylen+1; j++) {
                dpt[i][j]=0;
            }
        }
        
        for (int i = 1; i < xlen+1; i++) {
            for (int j = 1; j < ylen+1; j++) {
                if(x.charAt(i-1)==y.charAt(j-1)){
                    dpt[i][j]=1+dpt[i-1][j-1];
                }
                else{
                    dpt[i][j]=Math.max(dpt[i-1][j],dpt[i][j-1]);
                }
            }
        }
        return dpt[xlen][ylen];
        
    }
    public static void main(String[] args) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t.length; j++) {
                t[i][j]=-1;
            }
        }
        String x="ABCBD";
        String y="BDCA";
        System.out.println(lcs_len2(x, y, x.length(), y.length()));
    }
}
