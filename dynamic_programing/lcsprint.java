public class lcsprint {
    public static String lcs_len2(String x,String y,int xlen,int ylen){
        String [][] dpt=new String[xlen+1][ylen+1];
        for (int i = 0; i < xlen+1; i++) {
            for (int j = 0; j < ylen+1; j++) {
                dpt[i][j]="-1";
            }
        }
        
        for (int i = 1; i < xlen+1; i++) {
            for (int j = 1; j < ylen+1; j++) {
                if(x.charAt(i-1)==y.charAt(j-1)){
                    if(dpt[i-1][j-1]!="-1"){

                        dpt[i][j]=x.charAt(i-1)+dpt[i-1][j-1];
                    }
                    else{
                         dpt[i][j]=x.charAt(i-1)+"";
                    }
                }
                else{
                    if(dpt[i-1][j]!="-1"){

                        dpt[i][j]=dpt[i-1][j];
                    }
                    else if(dpt[i][j-1]!="-1"){
                        dpt[i][j]=dpt[i][j-1];
                    }
                }
            }
        }
        return dpt[xlen][ylen];
        
    }
    public static void main(String[] args) {
        String x="ABCBD";
        String y="BDCA";
        System.out.println(lcs_len2(x, y, x.length(), y.length()));
    }
}
