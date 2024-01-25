import java.util.ArrayList;
import java.util.HashMap;

public class findMaxConsecative {
    public static void prindMaxSeq(int []arr){
        HashMap<Integer,Boolean> hm =new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], true);
        }
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(arr[i]-1)) {
                
                hm.put(arr[i], false);
            }
        }
        int stval=Integer.MIN_VALUE;
        int maxi=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(arr[i])) {
                int tl=1;
                int val=arr[i];
                while (hm.containsKey(val+tl)) {
                    tl++;
                }
                if (tl>maxi) {
                    stval=val;
                    maxi=tl;
                }            
            }
        }
        for (int i = 0; i < maxi; i++) {
            System.out.println(stval+i);
        }
        

    }
    public static void main(String[] args) {
        int [] arr={10,5,9,1,11,8,6,15,3,12,2};
        prindMaxSeq(arr);

    }
}
