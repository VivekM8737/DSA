public class printMazepathWithJump {
    public static void PJpMaze(int ir, int ic , int dr,int dc ,String path){
        if(ir==dr && ic==dc){
            System.out.print(path+" ");
            return;
        }
        for(int h=1; h<=dc-ic; h++){
            PJpMaze(ir,ic+h,dr,dc,path+"h"+h);
        }

        for(int v=1; v<=dr-ir; v++){
            PJpMaze(ir+v,ic,dr,dc,path+"v"+v);
        }
    
        for(int d=1; d<=dr-ir && d<=dc-ic; d++){
            PJpMaze(ir+d,ic+d,dr,dc,path+"d"+d);
        }
        
    }
    public static void main(String[] args) {
        PJpMaze(1, 1, 3, 3, "");
    }
}
