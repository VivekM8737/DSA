public class XpN {
    public static int xpn(int x , int n){
        if(n==0){
            return 1;
        }
        n=n-1;
        return x*xpn(x, n);
    }
    public static void main(String[] args) {
        System.out.println(xpn(3, 5));
    }
}
