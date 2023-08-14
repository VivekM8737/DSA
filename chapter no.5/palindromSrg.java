public class palindromSrg {
    public static boolean pali(String s){
        int  i=0;
        int j= s.length()-1;
        while(i<=j){
            char c1=s.charAt(i);
            char c2=s.charAt(j);
            if(c1!=c2){
                return false;
            }
            else{
                i++;
                j--;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String name ="vivek";
        for (int i = 0; i<name.length(); i++) {
                for(int j=i+1; j<=name.length();j++){
                    String ss=name.substring(i, j);
                    if(pali(ss)==true)
                    {System.out.println(ss);}
                }
            }
    }
}
