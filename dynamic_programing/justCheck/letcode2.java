package justCheck;

public class letcode2 { 
    public static int myAtoi(String s) {
        if(s.length()==0){
            return 0;
        }
        String x=s.replaceAll(" ","");
        if(!Character.isDigit(x.charAt(0)) && x.charAt(0)!='-' && x.charAt(0)!='+'){
            return 0;
        }
        else if(x.charAt(0)=='-'){
            int y=0;
            System.out.print("yes");
            for(int i=1; i<x.length();i++){
                if(Character.isDigit(x.charAt(i))){
                    y=(y*10)+(x.charAt(i)-'0');
                    if(y>=Integer.MAX_VALUE/10){
                        return -Integer.MAX_VALUE-1;
                    }
                }
                else{
                    break;
                }
            }
            return -y;
        }else{
            int y=0;
            int ind=0;
            if(x.charAt(0)=='+'){
                ind=1;
            }
            for(int i=ind; i<x.length();i++){
                if(Character.isDigit(x.charAt(i))){
                    y=(y*10)+(x.charAt(i)-'0');
                    if(y>=Integer.MAX_VALUE/10){
                        return Integer.MAX_VALUE;
                    }
                }
                else{
                    break;
                }
            }
            return y;
        }
    }
    public static void main(String[] args) {
        String x="21474836460";
        
        // System.out.println(myAtoi(x));
        System.out.println(x.charAt(0));
    }
}
