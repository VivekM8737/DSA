import java.util.Scanner;

public class printReversBinaryAndprintNo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int x=s.nextInt();
        boolean flag=false;
        int n=0;
        int j=0;
        for (int i = 31; i >=0; i--) {
            if (flag) {
                if ((x&(1<<i))!=0) {
                    System.out.print(1);
                    n=(n|(1<<j));
                    j++;
                }else{
                    System.out.print(0);
                    j++;
                }
            }
            else{
                if ((x&(1<<i))!=0) {
                    flag=true;
                    n=(n|(1<<j));
                    j++;
                    System.out.print(1);
                }else{
                    
                }
            }
        }
        System.out.println();
        System.out.println(n);
    }
}
