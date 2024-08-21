import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PrimsAlgo {
    public static class Edge{
        int from;
        int to;
        int cost;
        public Edge(int from,int to ,int cost){
            this.from=from;
            this.to=to;
            this.cost=cost;
        }
    }
    public static class Pair implements Comparable<Pair>{
        int v;
        String path;
        int cost;
        public Pair(int v, String path, int cost){
            this.v=v;
            this.path=path;
            this.cost=cost;
        }
        public int compareTo(Pair o){
            return this.cost-o.cost;
        }
    }
    public static void getPrims(ArrayList<Edge>[] graph,boolean [] visited,PriorityQueue<Pair> pq){
        while (pq.size()>0) {
            Pair rp=pq.remove();
            if (visited[rp.v]==true) {
                continue;
            }
            visited[rp.v]=true;
            if(rp.path!="-1"){

                System.out.println(rp.v+"_"+rp.path+"@"+rp.cost);
            }
            for(Edge e: graph[rp.v]){
                if (!visited[e.to]) {
                    pq.add(new Pair(e.to, rp.v+"", e.cost));
                }
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph=new ArrayList[7];
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 3, 25));
    

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));

        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, 10));
        // graph[2].add(new Edge(2, 5, 10));

        graph[3].add(new Edge(3, 0, 40));
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
        boolean [] visited = new boolean[graph.length];
        Arrays.fill(visited, false);
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0, -1+"", 0));
        getPrims(graph, visited, pq);
    }
}

