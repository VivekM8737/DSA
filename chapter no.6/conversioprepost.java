import java.util.Scanner;
import java.util.Stack;

public class conversioprepost {
   
        public static int resp(char z)
    {
        if(z =='+'){
            return 1;
        }
        else if (z == '-')
        {
            return 1;
        }
        else if (z == '*')
        {
            return 2;
        }
        else if (z == '/')
        {
            return 2;
        }
    
        return 0;
    }
    public static void proccess(Stack<String> pre, Stack<String> pos, Stack<Character> so){
        String x=pos.pop();
        String y=pos.pop();
        char z= so.pop();
        String ress=y+x+z;
        pos.push(ress);
        String x1=pre.pop();
        String y1=pre.pop();
        String ress1 =z+y1+x1;
        pre.push(ress1);
    }
        public static void main(String[] args) {
            System.out.println("Enter the fuction: ");
            Scanner s= new Scanner(System.in);
            String s1 = s.nextLine();
            Stack<Character> so = new Stack<>();
            Stack<String> pos = new Stack<>();
            Stack<String> pre = new Stack<>();
            
            for (int i = 0; i < s1.length(); i++) {
                char ch=s1.charAt(i);
                if(ch=='('){
                    so.push(ch);
                }
                else if(ch==')'){
                    while(so.peek()!='('){
                        proccess(pre, pos, so);
                    }
                    so.pop();
                }
                else if((ch>='0' && ch<='9') || (ch>='a' && ch<='z') || (ch>='A' && ch<='Z')){
                    pos.push(ch+"");
                    pre.push(ch+"");
                    
                }
                else if(ch=='+' || ch=='-' || ch=='/' || ch=='*'){
    
                    while(so.size()>0 && resp(so.peek())>=resp(ch) && so.peek() != '('){
                        proccess(pre, pos, so);
                    }
                    so.push(ch);
                    
                }
    
            }
            while(so.size()>0){
                proccess(pre, pos, so);
            }
            while (pos.size()>0 && pre.size()>0 ) {
                
                System.out.println(pos.pop());
                System.out.println(pre.pop());
            }
        }
}
