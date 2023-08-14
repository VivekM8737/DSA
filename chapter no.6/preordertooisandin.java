import java.util.Scanner;
import java.util.Stack;

public class preordertooisandin {
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
        Stack<String> pro = new Stack<>();
        for (int i = s1.length()-1; i >= 0;  i--) {
            char ch=s1.charAt(i);
            System.out.println(ch);
            if(Character.isDigit(ch)){
                so.push((float)(ch-'0'));
                inp.push(ch+"");
                pro.push(ch+"");
            }
            else if(ch=='/' || ch=='*' || ch=='-' || ch=='+'){
                float y=so.pop();
                float x=so.pop();
               so.push( result(x, y, ch));
               String x1=inp.pop();
               String x2=inp.pop();
               String res = '('+x1+ch+x2+')';
               inp.push(res);
               String y1=pro.pop();
               String y2=pro.pop();
               String ress = y1+y2+ch;
               pro.push(ress);            
                
            }
            
        }
        System.out.println(inp.pop());
        System.out.println(pro.pop());
        System.out.println(so.pop());


    }

}
