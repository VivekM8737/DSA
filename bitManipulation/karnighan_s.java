import java.util.Scanner;

public class karnighan_s {
    public static void main(String[] args) {
        System.out.println("Enter the number: ");
        Scanner s= new Scanner(System.in);
        int x=s.nextInt();
        int temp=x;
        int n_1=0;
        while(x!=0){
            int mask=x&(-x);
            x=(x&(-(mask<<1)));
            n_1++;
        }
        System.out.println("BY me: "+n_1);
        n_1=0;
        x=temp;
        while(x!=0){
            int mask=x&(-x);
            x-=mask;
            n_1++;
        }
        System.out.println("BY sir:"+n_1);
    }
}
