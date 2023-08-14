import java.util.Scanner;
import java.util.Stack;
public class prefixsolution {
    public static float res(float x , float y ,char z)
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
    public static void main(String[] args) {
        System.out.println("Enter the fuction: ");
        Scanner s= new Scanner(System.in);
        String s1 = s.nextLine();
        Stack<Float> si = new Stack<>();
        Stack<Character> so = new Stack<>();
        
        for (int i = 0; i < s1.length(); i++) {
            char ch=s1.charAt(i);
            if(ch=='('){
                so.push(ch);
            }
            else if(ch==')'){
                while(so.peek()!='('){
                    float x=si.pop();
                    float y=si.pop();
                    char z= so.pop();
                    float ress =res(x, y, z);
                    si.push(ress);
                }
                so.pop();
            }
            else if(Character.isDigit(ch)){
                si.push((float)(ch-'0'));
                
            }
            else if(ch=='+' || ch=='-' || ch=='/' || ch=='*'){

                while(so.size()>0 && resp(so.peek())>=resp(ch) && so.peek() != '('){
                    float x=si.pop();
                    float y=si.pop();
                    char z= so.pop();
                    float ress =res(x, y, z);
                    si.push(ress);
                }
                so.push(ch);
                
            }

        }
        while(so.size()>0){
            float x=si.pop();
            float y=si.pop();
            char z= so.pop();
            float ress =res(x, y, z);
            si.push(ress);
        }
        System.out.println(si.pop());
    }
}
