public class caseToggle {
    public static void main(String[] args) {
        StringBuilder s= new StringBuilder("hELLO mY nAME iS vIVEK");
        int  x='a'-'A';
        for(int i=0;i<s.length(); i++){
           char y=s.charAt(i);
           if(y>='a' && y<='z'){
                y-=x;
           }
           else if(y>='A' && y<='Z'){
            y+=x;
           }
           s.setCharAt(i, y);
        }
        //B-A=b-a+A
        // char s='B';
        // char z='b';
        // s+=x;
        // z-=x;
        System.out.println(s);
    }
}
