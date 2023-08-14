import java.util.Scanner;

public class printPermutation {
    public static void pPermt(String que,String ans){
        if(que.length()==0){
            System.out.println(ans+" ");
            return;
        }
        int k=0;
        for(int i=0; i<que.length(); i++){
            char x= que.charAt(i);
            String nst = (que.substring(0, i))+ (que.substring(i+1));
            pPermt(nst, ans+x);
        }

    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the String: ");
        String st= sc.nextLine();
        pPermt(st, "");
    }
}
