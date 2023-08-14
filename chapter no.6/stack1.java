import java.util.Stack;

public class stack1{
    public static void main(String[] args) {
        Stack<Integer> s1=new Stack<>();
        s1.push(55);
        s1.push(56);
        s1.push(57);
        s1.push(58);
        s1.push(59);
        System.out.println(s1);
        s1.pop();
        System.out.println(s1);
        s1.peek();

    }
}