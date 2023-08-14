public class printEncoding {
    // a=97
    public static void preco(String que, String ans){
        if(que.length()==0){
            System.out.println(ans);
            return;
        }
        else if(que.length()==1){
            char x=que.charAt(0);
            if (x=='0') {
                return;

            }
            else{
                int z=x-'0'+96;
                char y=(char)z;
                System.out.println(ans+y);
            }
        }
        else{
            char x=que.charAt(0);
            String ns= que.substring(1);
            if (x=='0') {
                return;

            }
            else{
                int z=x-'0'+96;
                char y=(char)z;
                preco(ns, ans+y);
            }
            String ch12 = que.substring(0,2);
            int codech12= Integer.parseInt(ch12);
            String st = que.substring(2);
            if(codech12<=26){
                int z=codech12+96;
                char y=(char)z;
                preco(st, ans+y);
            }
            
        }
    }
    public static void main(String[] args) {

        preco("123", "");
    }
}
