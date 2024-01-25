import java.util.ArrayList;
import java.util.PriorityQueue;

public class mergeSortList {
    public static class Pair implements Comparable<Pair>{
        int li;
        int di;
        int val;
        public Pair(int li,int di, int val){
            this.di=di;
            this.li=li;
            this.val=val;
        }
        public int compareTo(Pair o){
            return this.val-o.val;
        }
    } 
    public static ArrayList<Integer> kSortedLists(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> rl=new ArrayList<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for (int i = 0; i < lists.size(); i++) {
            Pair p1=new Pair(i, 0, lists.get(i).get(0));
            pq.add(p1);
        }
        while (pq.size()>0) {
            Pair p=pq.remove();
            rl.add(p.val);
            p.di++;
            if (p.di<lists.get(p.li).size()) {
                p.val=lists.get(p.li).get(p.di);
                pq.add(p);
            }
        }
        return rl;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> l1=new ArrayList<>();
        ArrayList<Integer> l2=new ArrayList<>();
        ArrayList<Integer> l3=new ArrayList<>();
        l1.add(10);
        l1.add(20);
        l1.add(30);
        l1.add(40);
        l1.add(50);
        l2.add(5);
        l2.add(7);
        l2.add(9);
        l2.add(11);
        l2.add(51);
        l2.add(57);
        l3.add(1);
        l3.add(2);
        l3.add(3);
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        System.out.println(kSortedLists(lists));
    }
}
