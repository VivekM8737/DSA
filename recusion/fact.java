public class fact{
    public static int fact_(int i){
        
        if(i==0){
            return 1;
        }
        // System.out.println(i);
        return i*fact_(i-1);
        
    }
    public static void main(String[] args) {
        System.out.println(fact_(5));
        // fact_(5);


    }
}