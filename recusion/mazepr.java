import java.util.ArrayList;

public class mazepr {
    public static ArrayList<String> mz(int sr, int sc, int dsr ,int dsc){
        if (sr==dsr && sc==dsc) {
            ArrayList<String> bst= new ArrayList<>();
            bst.add("");
            return bst;
        }
        ArrayList<String> cst=new ArrayList<>();
        ArrayList<String> hst=new ArrayList<>();
        if(sr<dsr){
           
            cst = mz(sr+1, sc, dsr, dsc);
            
        }
        if(sc<dsc){
            hst = mz(sr, sc+1, dsr, dsc);
            
        }
        ArrayList<String> r_st =new ArrayList<>();
        for (String st : cst) {
            r_st.add("v"+st);
        }
        for (String st : hst) {
            r_st.add("h"+st);
        }
        return r_st;
    }
    public static void main(String[] args) {
        System.out.println(mz(1, 1, 3, 3));
    }
}
