import java.util.HashMap;

public class check {
    public static int countBit(int x){
        int c=0;
        while(x!=0){
            int mask=(x&(-x));
            x-=mask;
            c++;
        }
        return c;
    }
    
    public static void main(String[] args) {
        HashMap<Integer,Integer> st =new HashMap<>();
        st.put(1, 10);
        // System.out.println((Integer.toBinaryString(1177)));
        // int x=(1<<10)+(1<<7)+(1<<6)+(1<<3)+(1<<4)+(1<<2)+(1<<0);
        // int x=(1<<10)+(1<<8)+(1<<6)+(1<<4)+(1<<2)+(1<<0);
        // System.out.println(x);
        // if((false ||true) && true){
        //     System.out.println('a');
        // }
        System.out.println(countBit(536870911));
        // System.out.println(countBit(56));
        // System.out.println(countBit(67));
        // System.out.println(countBit(65^56));
        // System.out.println(countBit(65^67));
    }
}
