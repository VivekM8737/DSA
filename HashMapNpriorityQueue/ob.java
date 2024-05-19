import java.util.Comparator;
import java.util.PriorityQueue;

public class objectPQ {
    public static class Trier{
        public int x;
        public int y;
        public double z;
        public Trier(int a, int b,double c){
            this.x=a;
            this.y=b;
            this.z=c;
        }
        
    }
    static class TComparator implements Comparator<Trier>{
             
            // Overriding compare()method of Comparator 
                        // for descending order of cgpa
            public int compare(Trier s1, Trier s2) {
                if (s1.z < s2.z){

                    return 1;
                }
                else if (s1.z > s2.z){

                    return -1;
                }
                                
                return 0;
                }
    }
    public static void main(String[] args) {
        Trier x= new Trier(10, 20, 3.40);
        Trier x1= new Trier(11, 21, 2.40);
        PriorityQueue<Trier> pq=new PriorityQueue<Trier>(new TComparator());
        pq.add(x1);
        pq.add(x);
        System.out.println(pq.peek().x);
    }
}
