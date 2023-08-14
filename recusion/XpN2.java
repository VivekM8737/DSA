public class XpN2 {
    public static int xpn(int x, int n){
        if(n==0){
            return 1;
        }
        else if(n%2==0){
            return xpn(x, n/2)*xpn(x, n/2);
        }
        else{
            return xpn(x, n/2)*xpn(x, n/2)*x;

        }
    }
    public static void main(String[] args) {
        System.out.println(xpn(2, 3));
    }
}
