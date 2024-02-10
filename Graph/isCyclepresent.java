import java.util.ArrayDeque;
import java.util.ArrayList;

public class isCyclepresent {
    public static class Edge{
        int src;
        int nbr;
        int wt;
        public Edge(int src, int nbr, int wt){
            this.nbr=nbr;
            this.src=src;
            this.wt=wt;
        }
    }
    public static class Pair {
        int v;
        String path;
        public Pair(int v,String path){
            this.path=path;
            this.v=v;
        }
        
    }
    static boolean cycle;
    public static boolean haveCycle(ArrayList<Edge>[] graph,boolean [] visited,ArrayDeque<Pair> q){
        if (cycle) {
            return cycle;
        }
        if (q.size()<=0) {
            return false;
        }
        Pair x=q.remove();
        if (!visited[x.v]) {
            visited[x.v]=true;
            for (Edge e : graph[x.v]) {
                if (!visited[e.nbr]) {
                        q.add(new Pair(e.nbr, ""));
                }
                    
            }
            
        }else{
            cycle =true;
            return cycle;
        }
        haveCycle(graph, visited, q);
        
        return cycle;
    }
    public static void main(String [] arg){
        ArrayList<Edge>[] graph=new ArrayList[7];
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();

        }
        graph[0].add(new Edge(0, 1, 10));
        // graph[0].add(new Edge(0, 3, 10));
       graph[1].add(new Edge(1, 0, 10));
      // graph[1].add(new Edge(1, 2, 10));

      // graph[2].add(new Edge(2, 1, 10));
      graph[2].add(new Edge(2, 3, 10));
      // graph[2].add(new Edge(2, 5, 10));

      // graph[3].add(new Edge(3, 0, 40));
      graph[3].add(new Edge(3, 2, 10));
      // graph[3].add(new Edge(3, 4, 2));

      // graph[4].add(new Edge(4, 3, 2));
      // graph[4].add(new Edge(4, 5, 3));
      graph[4].add(new Edge(4, 6, 8));
      
      // graph[5].add(new Edge(5, 2, 3));
      // graph[5].add(new Edge(5, 4, 3));
      graph[5].add(new Edge(5, 6, 3));

      graph[6].add(new Edge(6, 4, 8));
      graph[6].add(new Edge(6, 5, 3));
        ArrayDeque<Pair> q =new ArrayDeque<>();
        boolean [] visited =new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i]=false;
        }
        cycle=false;
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                
                q.add(new Pair(i,""));
                haveCycle(graph, visited, q);
            }
            if (cycle) {
                
                break;
            }
        }
        System.out.println(cycle);
    }
}

