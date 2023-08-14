import java.util.*;
public   class disit{
    public static int cunt(int x, int num){
        int c=0;
        int z=x;
        for (int i = 1; i <= x; i*=10) {
            int y=z%10;
            z/=10;
            if(y==num){
                c++;
            }
        }
        return c;
    }

    public static void main(String[] a){
        System.out.print("Eneter the num: ");
        Scanner s= new Scanner(System.in);
        int x=s.nextInt();
        System.out.print("Eneter the disit: ");
        int disit=s.nextInt();
        System.out.println(cunt(x, disit));

    }
}