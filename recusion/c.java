import java.util.ArrayList;
import java.util.Scanner;

public class c {
    static String[] code = {".;","abc","edf","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static void St(String st,String ans ){
        if(st.length()==0){
            System.out.print(ans+" ");
            return ;
        }
        char x= st.charAt(0);
         String nq = st.substring(1 );
        String cod = code[x-'0'];
        for (int i = 0; i < cod.length(); i++) {
            char  a=cod.charAt(i);
            St(nq,ans+a);
        }

    }
    public static void main(String[] args) {
        Scanner sc= new Scanner( System.in);
        System.out.println(" Enter the String: ");
        // char x= sc.next().charAt(0);
        String st= sc.nextLine();
        int w = Integer.parseInt(st);
        // int z=w+96;
        // char y=(char)z;
        // String st= sc.nextLine();
        // String nst;
        // nst=st.substring(0, 0)+st.substring(1);


        // St(st,"");
        // System.out.println(nst);
        System.out.println(w);
    }
}
