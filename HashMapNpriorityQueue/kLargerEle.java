import java.util.Collections;
import java.util.PriorityQueue;

public class kLargerEle {
    public static void kEle(int [] arr,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for (int i =0;i<arr.length;i++) {
            if (pq.size()==k && pq.peek()>arr[i]) {
                pq.remove();
                pq.add(arr[i]);
            }
            else if(pq.size()<k){

                pq.add(arr[i]);
            }

        }
        System.out.println(pq.remove());
        System.out.println();
        while (pq.size()>0) {
                System.out.println(pq.remove());
            
        }
    }
    public static void main(String[] args) {
        int[] arr={2,10,5,17,7,18,6,4};
        kEle(arr, 3);
    }
}
