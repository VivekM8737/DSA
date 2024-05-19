import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class bfs {
    public static class Edge {
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
        public Pair(int v, String path){
            this.path=path;
            this.v=v;
        }
    }
    public static void bfs_(ArrayList<Edge>[] gph,boolean[] visited,ArrayDeque<Pair> que){
        if (que.size()<=0) {
            return;
        }
        Pair x=que.remove();
        // System.out.println(x.src);
        if (!visited[x.v]) {
            visited[x.v]=true;
            System.out.println(x.v+"@"+x.path+x.v);
            for (Edge edge : gph[x.v]) {
                if (!visited[edge.nbr]) {
                        que.add(new Pair(edge.nbr,x.path+x.v));
                }
                
            }
            
        }
        bfs_(gph, visited, que);
    }
    public static void bfs1(ArrayList<Edge>[] graph,int src){
        boolean [] visited =new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i]=false;
        }
        ArrayDeque<Pair> q=new ArrayDeque<>();
        q.add(new Pair(graph[src].get(0).src, graph[src].get(0).src+""));
        while (q.size()>0) {
            Pair p=q.remove();
            if (!visited[p.v]) {
                visited[p.v]=true;
                System.out.println(p.v+"@"+p.path);
                for (Edge e : graph[p.v]) {
                    if (!visited[e.nbr]) {
                        q.add(new Pair(e.nbr, p.path+e.nbr));
                    }
                }
            }
        }
    }
    public static void main(String [] args){
        ArrayList<Edge>[] graph=new ArrayList[7];
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,3,10));

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
        ArrayDeque<Pair> q =new ArrayDeque<>();
        boolean [] visited =new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i]=false;
        }
        q.add(new Pair(2,""));
        bfs_(graph, visited, q);
        System.out.println("By second one");
        bfs1(graph, 2);
    }
}
