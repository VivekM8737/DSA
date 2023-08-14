import java.util.Scanner;

public class printkeycombiantion {
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
        String st= sc.nextLine();

        St(st,"");
        // System.out.println(res);
    }
}
