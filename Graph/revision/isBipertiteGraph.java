import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class isBipertiteGraph {
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
        int level;
        public Pair(int v,String path,int level){
            this.v=v;
            this.path=path;
            this.level=level;
        }
        
    }
    static boolean flag=true;
    public static void haveCycle(ArrayList<Edge>[] graph,HashMap<Integer,Integer> visited,ArrayDeque<Pair> q){
        while (q.size()>0) {
            Pair rm=q.remove();
            if (visited.containsKey(rm.v)) {
                if (rm.level!=visited.get(rm.v)) {
                    flag=false;
                    return;
                }
            }
            visited.put(rm.v, rm.level);
            for(Edge e: graph[rm.v]){
                if (!visited.containsKey(e.to)) {
                    q.add(new Pair(e.to, rm.path+e.to,rm.level+1));
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
        graph[0].add(new Edge(0, 3, 40));
    

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));

        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, 10));

        graph[3].add(new Edge(3, 0, 40));
        graph[3].add(new Edge(3, 2, 10));
        graph[3].add(new Edge(3, 4, 2));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 6, 8));

        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));

        graph[6].add(new Edge(6, 4, 8));
        graph[6].add(new Edge(6, 5, 3));
        HashMap<Integer,Integer> visited=new HashMap<>();
        // System.out.println(q.remove().v);
        for (int i = 0; i < graph.length; i++) {
            if (!visited.containsKey(i)) {
                ArrayDeque<Pair> q=new ArrayDeque<>();
                q.add(new Pair(i, i+"",0));
                haveCycle(graph, visited, q);
                if (flag) {
                    break;
                }
            }
        }
        System.out.println(flag);
    }
}
