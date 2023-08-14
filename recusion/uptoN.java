public class uptoN {
    public static void upto_N(int x){
        if(x==0){
            return;
        }
        System.out.println(x);
        upto_N(x-1);
        System.out.println(x);
    }
    public static void main(String[] args) {
        upto_N(5);
    }
}
