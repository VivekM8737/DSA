public class asciivaluedeff {
    public static void main(String[] args) {
        StringBuilder s= new StringBuilder("accjiweje");
        StringBuilder s1= new StringBuilder(" ");
        s1.setCharAt(0, s.charAt(0));
        for(int i=1; i<s.length(); i++){
                int x=s.charAt(i)-s.charAt(i-1);
                s1.append(x);                
                s1.append(s.charAt(i));
        }       
        System.out.println(s1);
    }
    
}

