public class printMazePath {
    public static void pMaze(int ir,int ic,int dr,int dc,String path){
        if(ir==dr && ic==dc){
            System.out.print(path +" ");
            return;
        }if(ir<dr){

            pMaze(ir+1,ic,dr,dc,path+"v");
        }
        if(ic<dc){

            pMaze(ir,ic+1,dr,dc,path+"h");
        }
    }
    public static void main(String[] args) {
        pMaze(1, 1, 3, 4, "");
    }
}
