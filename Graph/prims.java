import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class prims {
    public static class Edge {
        int src;
        int nbr;
        int wt;
        public Edge(int src,int nbr, int wt){
            this.src=src;
            this.nbr=nbr;
            this.wt=wt;
        }
        
    }
    public static class Pair implements Comparable<Pair>{
        int wt;
        int src;
        int edg;
        public Pair(int src,int edg,int wt){
            this.wt=wt;
            this.edg=edg;
            this.src=src;
        }
        @Override
        public int compareTo(Pair o){
           return this.wt-o.wt;
        }
    }
    public static void prims_cl(ArrayList<Edge> [] graph){
        PriorityQueue<Pair> pq =new PriorityQueue<>();
        boolean [] visited=new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i]=false;
        }
        // pq.add(new Pair(graph[0].get(0), -1, graph[0].get(0).wt));
        pq.add(new Pair(graph[0].get(0).src, -1, graph[0].get(0).wt));
        while(pq.size()>0){
            Pair s=pq.remove();
            if (s.edg!=-1 && !visited[s.src]) {
                System.out.println(s.src+"-"+s.edg+"@"+s.wt);
            }
            if (!visited[s.src]) {
                visited[s.src]=true;
                for (Edge e : graph[s.src]) {
                    if (!visited[e.nbr]) {
                        pq.add(new Pair(e.nbr, e.src, e.wt));
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Edge> [] graph=new ArrayList[7];
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 3, 40));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));

        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, 10));
        // graph[2].add(new Edge(2, 5, 10));

        graph[3].add(new Edge(3, 0, 25));
        graph[3].add(new Edge(3, 2, 10));
        graph[3].add(new Edge(3, 4, 2));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 6, 8));
        
        // graph[5].add(new Edge(5, 2, 3));
        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));

        graph[6].add(new Edge(6, 4, 8));
        graph[6].add(new Edge(6, 5, 3));

        prims_cl(graph);
    }
}
