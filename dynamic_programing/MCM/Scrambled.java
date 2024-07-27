import java.util.HashMap;

public class Scrambled {
    static int z=1;
    static HashMap<String,Boolean> hs=new HashMap<>();
    public static boolean isScrambled(String a, String b){
        if(a==b){
            return true;
        }
        if (a.length()<=1) {
            return false;
        }
        if (hs.containsKey(a+" "+b)) {
            return true;
        }
        
        boolean flag=false;
        int n=a.length();
        System.out.println(z);
        z++;
        for(int i=1; i<=n-1; i++){
            if ((isScrambled(a.substring(0,i), b.substring(n-i))==true && isScrambled(a.substring(i), b.substring(0,n-i))==true) 
            ||
            (isScrambled(a.substring(0,i), b.substring(0,i))==true && isScrambled(a.substring(i), b.substring(i))==true)) 
            {   
                hs.put(a+" "+b, true);
                flag=true;
                break;
            }
        }
        return flag;
    }
    public static void main(String[] args) {
        String a="great";
        String b="ategr";
        System.out.println(isScrambled(a, b));
    }
}
