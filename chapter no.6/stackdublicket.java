import java.util.Scanner;
import java.util.Stack;

public class stackdublicket {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        String str=s.nextLine();
        Stack<Character> s1= new Stack<>();
        for(int i=0; i<str.length();i++){
            char ch = str.charAt(i);
            if(ch==')'){
                if(s1.peek()=='('){
                    System.out.println("Dublicasy");
                    return;
                }
                else{
                    while(s1.peek()!='('){
                        s1.pop();
                    }
                    s1.pop();
                }
            }
            else
            {
                s1.push(ch);
            }
        }
        System.out.println("No dublicasy");
    }
}
