import java.util.ArrayList;
import java.util.Scanner;

public class subsuque {
    public static ArrayList<String> sub(String srt){
        if (srt.length()==0) {
            ArrayList<String> bst = new ArrayList<>();
            bst.add(srt);
            return bst;
        }
        char x= srt.charAt(0);//a
        ArrayList<String> fst = sub(srt.substring(1));//bc
        ArrayList<String> r_st = new ArrayList<>();

        for (String string : fst) {
            r_st.add(""+string);
        }
        for (String string : fst) {
            r_st.add(x+string);
        }
        return r_st;




    }
    public static void main(String[] args) {
        Scanner sc= new Scanner( System.in);
        System.out.println(" Enter the String: ");
        String st= sc.nextLine();
        ArrayList<String> res = new ArrayList<>();
        res=sub(st);
        System.out.println(res);

    }
}
