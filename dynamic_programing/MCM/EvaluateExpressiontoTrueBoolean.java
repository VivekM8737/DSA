import java.util.HashMap;

public class EvaluateExpressiontoTrueBoolean {
    static int z=0;
    public static int ways(String s,int i , int j , boolean istrue,HashMap<String,Integer> dp){
        if (i>j) {
            return 0;
        }
        if (i==j) {
            if (s.charAt(i)=='T' && istrue) {
                return 1;
            }
            else if(s.charAt(i)=='F' && !istrue){
                return 1;
            }
            else{
                return 0;
            }
        }
        String key=i+""+j+""+istrue;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        z++;
        int ans=0;
        for (int k = i+1; k < j; k+=2) {
            int lt=ways(s, i, k-1, true,dp);
            int lf=ways(s, i, k-1, false,dp);
            int rt=ways(s, k+1,j, true,dp);
            int rf=ways(s, k+1,j, false,dp);
            if (s.charAt(k)=='&') {
                if (istrue) {
                    
                    ans+=(lt*rt);
                }
                else{
                    ans+=((lt*rf)+(lf*rt)+(lf*rf));
                }
            }
            else if(s.charAt(k)=='|'){
                if (istrue) {
                    
                    ans+=((lt*rf)+(lf*rt)+(lt*rt));
                }
                else{
                    ans+=(lf*rf);
                }
            }
            else if(s.charAt(k)=='^'){
                if (istrue) {
                    ans+=((lt*rf)+(lf*rt));
                    
                }else{
                    ans+=((lf*rf)+(lt*rt));
                }
            }
        }
        dp.put(key, ans);
        return ans;
    }
    public static void main(String[] args) {
        String s="T&F^T|F";
        HashMap<String,Integer> dp=new HashMap<>();
        System.out.println(ways(s, 0, s.length()-1, true,dp));
        System.out.println(z);
    }
}
