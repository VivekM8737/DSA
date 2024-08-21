import java.util.ArrayList;
import java.util.Scanner;

public class onceOccuredOfTwoNumInArray {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the length of array: ");
        int len = s.nextInt();
        int[] arr=new int[len];

        System.out.println("Enter the element of array:");
        int x=0;
        for (int i = 0; i < arr.length; i++) {
            arr[i]=s.nextInt();
            x=(x^arr[i]);
        }
        int rmSetbitmsk=(x&(-x));
        ArrayList<Integer> al_1=new ArrayList<>();
        ArrayList<Integer> al_2=new ArrayList<>();
        int fst=0;
        int snd=0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i]&rmSetbitmsk)!=0) {
                al_1.add(arr[i]);
                fst=(fst^arr[i]);
            }
            else{
                al_2.add(arr[i]);
                snd=(snd^arr[i]);
            }
        }
        System.out.println("Asnwers:");
        System.out.println(al_1);
        System.out.println(al_2);
        System.out.println(fst<snd?fst:snd);
        System.out.println(fst>snd?fst:snd);
    }
}
