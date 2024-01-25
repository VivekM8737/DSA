import java.util.PriorityQueue;

public class kSortedArray{
    public static void sort(int [] arr, int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            if (pq.size()<=k) {
                pq.add(arr[i]);
                
            }
            else{ 
                System.out.println(pq.remove());
                pq.add(arr[i]);
            }
        }
        while (pq.size()>0) {
            System.out.println(pq.remove());
        }

    }
    public static void main(String[] args) {
        int [] arr={2,3,1,4,6,7,5,8,9};
        sort(arr, 2);

    }
}