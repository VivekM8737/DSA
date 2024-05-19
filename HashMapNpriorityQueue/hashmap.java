import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class hashmap {
    public static void main(String[] args) {
        HashMap<Double,String> h1=new HashMap<>();
        h1.put(1.2, "2/3"); 
        h1.put(.6, "1/3");
        h1.put(.8,""+1+"/"+5); 
        int a=1;
        int b=2;
        float x=((float)a/b);
        System.out.println("x="+x);
        System.out.println(h1.get(1.2));
        PriorityQueue<Double> pq =new PriorityQueue<>(Collections.reverseOrder());
        
        pq.add(.6);
        pq.add(.8);
        System.out.println(h1.get(pq.remove()));
        System.out.println(h1.get(pq.remove()));
        // System.out.println(pq.peek());
    }
}
