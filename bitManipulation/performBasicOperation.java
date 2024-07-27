import java.util.Scanner;

import javax.sound.midi.SysexMessage;

public class performBasicOperation{
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        int i=s.nextInt();
        int j=i;
        int k=i;
        int m=i;

        int onmask=(1<<i);
        int offmask=~(1<<j);
        int toggleMask=(1<<k);
        int checkMask=(1<<m);
        System.out.println((n|onmask));
        System.out.println((n&offmask));
        System.out.println((n^toggleMask));
        System.out.println((n&checkMask)==0?"off":"on");


    }
}