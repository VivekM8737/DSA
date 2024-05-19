package justCheck;

public class leetcodepr {
    public static int reverse1(int x) {
        int y=0;
        int temp=Math.abs(x);
        while(temp>0){
            if(((y*10+x%10)*10)>=Integer.MAX_VALUE){
                return 0;
            }
            y=y*10+x%10;
            x=x/10;
            temp/=10;
        }
         return y;
     }
    public static int reverseComp(int x) {
        String y="";
        int temp=Math.abs(x);
        while(temp>0){
            y=y+temp%10;
            temp/=10;
        }
        int res=0;
         try{   
            res=Integer.parseInt(y);  
        }catch(Exception e)
        {return 0;}
        if(x<0){
            return -res;
        }
        return res;
     }
     public int reverseBest(int x) {
        int y=0;
        long c=0;
        int temp=Math.abs(x);
        while(temp>0){
            if(c*10>=Integer.MAX_VALUE){
                return 0;
            }
            y=y*10+temp%10;
            c=y;
            temp/=10;
        }
        if(x<0){
            return -y;
        }
         return y;
     }
     
     public static void main(String[] args) {
        int x=1;        
        // System.out.println(reverse1(x));
        // String y="9646324351";
        // int z=Integer.parseInt(y);
        // System.out.println(z);
        long z= 946324351;
        if(z*100>Integer.MAX_VALUE){
            System.out.println("yes");
        }
        else{
            System.out.println("NO");
        }
     }
}
