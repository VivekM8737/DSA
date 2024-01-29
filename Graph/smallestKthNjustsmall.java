import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class smallestKthNjustsmall {
     public static class Edge{
        int src;
        int nbr;
        int wt;
        public Edge(int src,int nbr, int wt){
            this.nbr=nbr;
            this.src=src;
            this.wt=wt;
        }
    }
    public static class Pair implements Comparable<Pair>{
        int wt;
        String path;
        public Pair(int wt,String path){
            this.path=path;
            this.wt=wt;
        }
        @Override
        public int compareTo(smallestKthNjustsmall.Pair o) {
            return this.wt-o.wt;
        }
    }
    static int mc;
    static String sp;
    static PriorityQueue<Integer> pq;
    static  HashMap<Integer,String> hm;
    static PriorityQueue<Integer> pqs;
    static  HashMap<Integer,String> hms;
    static int cealofk;
    static String cealpath;
    static int floorofk;
    static String floorPath;
    static PriorityQueue<Pair> pq2;

    public static void printPath(ArrayList<Edge>[] gph,int src,int des,boolean[] visited, String pth ,int minP,int kth,int critarea){
        if (src==des) {
            if (pq.size()<kth) {
                pq.add(minP);
                pq2.add(new Pair(minP, pth));
                hm.put(minP, pth);
                pqs.add(minP);
                hms.put(minP, pth);
            }
            else{
                if (pqs.peek()>minP) {
                    hms.remove(pqs.remove());
                    hms.put(minP, pth);
                    pqs.add(minP);
                }
                if (pq.peek()<minP) {
                    hm.remove(pq.remove());
                    hm.put(minP, pth);
                    pq.add(minP);
                }
                if (pq2.peek().wt<minP) {
                    pq2.remove();
                    pq2.add(new Pair(minP, pth));
                }
            }
            if (mc>minP) {
                mc=minP;
                sp=pth;
            }
            if (critarea<minP && cealofk>minP) {
                cealofk=minP;
                cealpath=pth;
            }
            if (critarea>minP && floorofk<minP) {
                floorofk=minP;
                floorPath=pth;
            }
            // System.out.println(pth);
            return;
        }
        visited[src]=true;
        for (Edge b : gph[src]) {
            if (!visited[b.nbr]) {
                printPath(gph, b.nbr, des, visited, pth+b.nbr,minP+b.wt,kth,critarea);
            }
        }
        visited[src]=false;

    }

    public static void main(String[] args) {
         ArrayList<Edge> [] gph= new ArrayList[7];
        for (int i = 0; i < gph.length; i++) {
            gph[i]=new ArrayList<>();
        }
        gph[0].add(new Edge(0, 1, 10));
        gph[0].add(new Edge(0, 3, 40));

        gph[1].add(new Edge(1, 0, 10));
        gph[1].add(new Edge(1, 2, 10));

        gph[2].add(new Edge(2, 1, 10));
        gph[2].add(new Edge(2, 3, 10));

        gph[3].add(new Edge(3, 0, 40));
        gph[3].add(new Edge(3, 2, 10));
        gph[3].add(new Edge(3, 4, 2));

        gph[4].add(new Edge(4, 3, 2));
        gph[4].add(new Edge(4, 5, 3));
        gph[4].add(new Edge(4, 6, 8));
        
        gph[5].add(new Edge(5, 6, 3));
        gph[5].add(new Edge(5, 4, 3));
        gph[6].add(new Edge(6, 5, 3));
        gph[6].add(new Edge(6, 4, 8));
        boolean [] visited =new boolean[gph.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i]=false;
        }
        mc=Integer.MAX_VALUE;
        sp="";
        pq=new PriorityQueue<>();
        hm = new HashMap<>();
        pqs=new PriorityQueue<>(Collections.reverseOrder());
        hms = new HashMap<>();
        pq2=new PriorityQueue<>();
        cealofk=Integer.MAX_VALUE;
        cealpath="";

        floorofk=Integer.MIN_VALUE;
        floorPath="";
        int kth=2;
        int k=42;
        printPath(gph, 0, 6, visited, 0+"",0, kth,k);
        System.out.println("Smalest Path cost "+mc);
        System.out.println("Smalest Path "+sp);
        int x=pq.remove();
        System.out.println("Kth largest path cost "+x);
        System.out.println("Kth largest path "+hm.remove(x));
        x=pqs.remove();
        System.out.println("Kth smalest path cost "+x);
        System.out.println("Kth smalest path "+hms.remove(x));
        System.out.println("ceal of "+k+" is "+cealofk);
        System.out.println("ceal path of "+k+" is "+cealpath);
        System.out.println("floor of "+k+" is "+floorofk);
        System.out.println("floor path of "+k+" is "+floorPath);
        System.out.println("Second way to find the kth lastgest path");
        Pair klarge=pq2.remove();
        System.out.println("Kth largest cost "+klarge.wt);
        System.out.println("Kth largest path "+klarge.path);

    }
}
