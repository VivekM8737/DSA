import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class topologicalSort {
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
    public static void sort(ArrayList<Edge>[] graph,int src,boolean[]visited,Stack<Integer>st ){
        if (visited[src]) {
            return;
        }
        visited[src]=true;
        
        for(Edge e :graph[src]){
            if (visited[e.to]) {
                sort(graph, e.to, visited, st);
            }
        }
        st.push(src);
    }
    public static void main(String[] args) {
         ArrayList<Edge>[] graph=new ArrayList[7];
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 3, 25));
    

        // graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));

        // graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, 10));
        // graph[2].add(new Edge(2, 5, 10));

        // graph[3].add(new Edge(3, 0, 40));
        // graph[3].add(new Edge(3, 2, 10));
        // graph[3].add(new Edge(3, 4, 2));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 6, 8));

        // graph[5].add(new Edge(5, 2, 3));
        // graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));

        // graph[6].add(new Edge(6, 4, 8));
        // graph[6].add(new Edge(6, 5, 3));
        boolean [] visited = new boolean[graph.length];
        Arrays.fill(visited, false);
        Stack<Integer> asn=new Stack<>();
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                sort(graph, i, visited, asn);
            }
        }
        while (asn.size()>0) {
            System.out.println(asn.pop());
            
        }

    }
}
