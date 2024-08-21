import java.util.Scanner;

public class findMissingAndDublicateIn1_nArray {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the length of array: ");
        int len = s.nextInt();
        int[] arr=new int[len];

        System.out.println("Enter the element of array:");
        int x=0;
        int ele=1;
        for (int i = 0; i < arr.length; i++) {
            arr[i]=s.nextInt();
            x=(x^arr[i]^ele);
            ele++;
        }
        int rmMask=(x&(-x));
        int fch=0;
        int snd=0;
        ele=1;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i]&rmMask)!=0) {
                fch=(fch^arr[i]);
            }
            else{
                snd=(snd^arr[i]);
            }
            if ((ele&rmMask)!=0) {
                fch=(fch^ele);
            } 
            else{
                snd=(snd^ele);
            }
            ele++;
        }

        System.out.println(snd);
        System.out.println(fch);

    }
}
