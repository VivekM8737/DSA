import java.util.ArrayList;
import java.util.Scanner;

public class keyPad {
    static String[] code = {".;","abc","edf","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList<String> key(String srt){
         if (srt.length()==0) {
            ArrayList<String> bst = new ArrayList<>();
            bst.add(srt);
            return bst;
        }
        char x= srt.charAt(0);//a
        ArrayList<String> fst = key(srt.substring(1));//bc
        ArrayList<String> r_st = new ArrayList<>();
        String codeof = code[x-'0'];
        for (int i = 0; i < codeof.length(); i++) {
            char ch =codeof.charAt(i);
            for (String string : fst) {
                r_st.add(ch+string);
            }
        }
        return r_st;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Code");
        String st = sc.nextLine();
        System.out.println(key(st));
        

    }
}
