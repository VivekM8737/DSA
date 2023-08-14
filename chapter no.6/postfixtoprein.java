import java.util.Scanner;
import java.util.Stack;

public class postfixtoprein {
    public static float result(float x , float y ,char z)
    {
        if(z =='+'){
            return y+x;
        }
        else if (z == '-')
        {
            return y-x;
        }
        else if (z == '*')
        {
            return y*x;
        }
        else if (z == '/')
        {
            return y/x;
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println("Enter the fuction: ");
        Scanner s= new Scanner(System.in);
        String s1 = s.nextLine();
        Stack<Float> so = new Stack<>();
        Stack<String> inp = new Stack<>();
        Stack<String> pre = new Stack<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch=s1.charAt(i);
            if(Character.isDigit(ch)){
                so.push((float)(ch-'0'));
                inp.push(ch+"");
                pre.push(ch+"");
            }
            else if(ch=='/' || ch=='*' || ch=='-' || ch=='+'){
                float x=so.pop();
                float y=so.pop();
               so.push( result(x, y, ch));
               String x2=inp.pop();
               String x1=inp.pop();
               String res = '('+x1+ch+x2+')';
               inp.push(res);
               String y2=pre.pop();
               String y1=pre.pop();
               String ress = ch+y1+y2;
               pre.push(ress);            
                
            }
            
        }
        System.out.println(inp.pop());
        System.out.println(pre.pop());
        System.out.println(so.pop());


    }
}
