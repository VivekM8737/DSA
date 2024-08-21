import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class isGraphCyclic {
    public static class Edge{
        int from;
        int to;
        int cost;
        public Edge(int from, int to, int cost){
            this.from=from;
            this.to=to;
            this.cost=cost;
        }
    }
    public static class  Pair {
        int v;
        String path;
        public Pair(int v,String path){
            this.v=v;
            this.path=path;
        }
        
    }
    static boolean flag=false;
    public static void haveCycle(ArrayList<Edge>[] graph,int []visited,ArrayDeque<Pair> q){
        while (q.size()>0) {
            Pair rm=q.remove();
            if (visited[rm.v]==1) {
                flag=true;
                return;
            }
            visited[rm.v]=1;
            for(Edge e: graph[rm.v]){
                if (visited[e.to]!=1) {
                    q.add(new Pair(e.to, rm.path+e.to));
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
        // graph[0].add(new Edge(0, 3, 40));
    

        graph[1].add(new Edge(1, 0, 10));
        // graph[1].add(new Edge(1, 2, 10));

        // graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, 10));

        // graph[3].add(new Edge(3, 0, 40));
        graph[3].add(new Edge(3, 2, 10));
        // graph[3].add(new Edge(3, 4, 2));

        // graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 6, 8));

        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));

        graph[6].add(new Edge(6, 4, 8));
        graph[6].add(new Edge(6, 5, 3));
        int [] visited=new int[graph.length];
        Arrays.fill(visited, -1);
        // System.out.println(q.remove().v);
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]!=1) {
                ArrayDeque<Pair> q=new ArrayDeque<>();
                q.add(new Pair(i, i+""));
                haveCycle(graph, visited, q);
                if (flag) {
                    break;
                }
            }
        }
        System.out.println(flag);
    }
}
