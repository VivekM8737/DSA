import java.util.ArrayList;
import java.util.PriorityQueue;

public class dijkstra {
    public static class Edge{
        int src;
        int nbr;
        int wt;
        public Edge(int src,int nbr,int wt){
            this.nbr=nbr;
            this.src=src;
            this.wt=wt;
        }
    }
    public static class Pair implements Comparable<Pair>{
        int src;
        String path;
        int wt;
        Pair(int src, String path, int wt){
            this.src=src;
            this.wt=wt;
            this.path=path;
        }
        @Override
        public int compareTo(Pair o) {
            return this.wt-o.wt;
        }
        
    }
    static Pair pp;
    public static void diktr(ArrayList<Edge> [] graph,int src,int des,int [] visited,PriorityQueue<Pair> pq){
        if (src==des) {
            pp=pq.peek();
            return;
        }if (pq.size()<=0) {
            return;
        }
        Pair x=pq.remove();
        if (visited[x.src]==-1) {
            visited[x.src]=x.src;
            for (Edge e : graph[x.src]) {
                if (visited[e.nbr]==-1) {
                    pq.add(new Pair(e.nbr, x.path+e.nbr, x.wt+e.wt));
                    diktr(graph, e.nbr, des, visited, pq);
                }
            }
        }
    }

    public static Pair dijsktraA(ArrayList<Edge> [] graph,int src,int des){
        int [] visited =new int[graph.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i]=-1;
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        Pair x=new Pair(src, src+"", 0);
        pq.add(x);
        Pair res=new Pair(src, null, des);
        while(pq.size()>0){
            Pair p=pq.remove();
            if (p.path!=null && visited[p.src]==-1) {
                System.out.println(p.src+"-"+p.path+"@"+p.wt);
            }
            if (p.src==des) {
                res=p;
                break;
                
            }
            if (visited[p.src]==-1) {
                visited[p.src]=p.src;
                for (Edge i : graph[p.src]) {
                    if (visited[i.nbr]==-1) {
                        pq.add(new Pair(i.nbr, p.path+i.nbr, p.wt+i.wt));
                    }
                }
            }
        }
        System.out.print(res.wt+" with path ");
        return res;
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
        
        Pair p=dijsktraA(graph, 0, 6);
        System.out.println(p.path);
        
        int [] visited =new int[graph.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i]=-1;
        }
        int src=0;
        int des=6;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        Pair x=new Pair(src, src+"", 0);
        pq.add(x);
        // pp=new Pair(src, null, des);
        // diktr(graph, src, des, visited,pq);
        // System.out.println(pp.path+" with weght "+pp.wt);
    }
}
