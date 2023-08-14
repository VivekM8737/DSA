import java.util.Scanner;

public class printsubSeq {
    public static void printsubSeq(String que , String ans){
        if(que.length()==0){
            System.out.println(ans);
            return;
        }
        char c= que.charAt(0);
        String nq=que.substring(1);
        printsubSeq(nq, ans+c);
        printsubSeq(nq, ans+"");
    }
    public static void main(String[] args) {
        System.out.println("Enter the String: ");
        Scanner sc= new Scanner(System.in);
        String x= sc.nextLine();
        System.out.println("The subsequence is: ");
        printsubSeq(x, "");
    }
}
