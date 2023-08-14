import java.util.ArrayList;

public class jumpInMazePathh {
    public static ArrayList<String> mp(int sc, int sr, int dsc, int dsr){
        ArrayList<String> fpt = new ArrayList<>();
        if(sc==dsc && sr==dsr)
        {
            ArrayList<String> bst =new ArrayList<>();
            bst.add("");
            return bst;

        }
        ArrayList<String> hpt = new ArrayList<>();
        ArrayList<String> vpt = new ArrayList<>();
        ArrayList<String> dpt = new ArrayList<>();
        for(int h=1; h<=dsc-sc;h++){
            hpt=mp(sc+h, sr, dsc, dsr);
            for (String s: hpt ) {
                fpt.add("h"+h+s);
        }
        }
        for(int v=1; v<=dsr-sr; v++){
            vpt=mp(sc, sr+v, dsc, dsr);
            for (String s: vpt ) {
            fpt.add("v"+v+s);
            }
        }
        for(int d=1; d<=dsr-sr && d<=dsc-sc; d++){
            dpt=mp(sc+d, sr+d, dsc, dsr);
            for (String s: dpt ) {
            fpt.add("d"+d+s);
            }
        }
        // if(sc<dsc){
        // }
        // if(sr<dsr){
            
        // }
        
        
        return fpt;
    

    }
    public static void main(String[] args) {
        System.out.println(mp(1, 1, 4, 4));
        
    }
}
