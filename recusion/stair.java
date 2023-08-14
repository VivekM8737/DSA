import java.util.ArrayList;

public class stair {
    public static ArrayList<String> str(int x){   
        if(x==0){
        ArrayList<String> bst =new ArrayList<>();
        bst.add("");
        return bst;
    }
     else if(x<0){
        
        ArrayList<String> bstt =new ArrayList<>();
        return bstt;
    }
        ArrayList<String> path1=str(x-1);
        ArrayList<String> path2=str(x-2);
        ArrayList<String> path3=str(x-3);

        ArrayList<String> r_st =new ArrayList<>();
        for (String string : path1) {
            r_st.add(1+string);
        }
        for (String string : path2) {
            r_st.add(2+string);
        }
        for (String string : path3) {
            r_st.add(3+string);
        }
        return r_st;
}

    public static void main(String[] args) {
        
        System.out.println(str(4));
    }
}
