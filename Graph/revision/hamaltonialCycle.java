import java.util.ArrayList;
import java.util.HashSet;

public class hamaltonialCycle {
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
    public static void cycleAndPath(ArrayList<Edge>[] graph,int src,int start,HashSet<Integer> hs,String path){
        if (hs.size()==graph.length-1) {
            char x='.';
            for(Edge e: graph[src]){
                if (e.to==start) {
                    x='@';
                    break;
                    
                }
            }
            System.out.println(path+x);
            return;
        }
        hs.add(src);
        for(Edge e: graph[src]){
            if (!hs.contains(e.to)) {
                cycleAndPath(graph, e.to,start, hs, path+e.to);
            }
        }
        hs.remove(src);

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
        graph[2].add(new Edge(2, 5, 10));

        graph[3].add(new Edge(3, 0, 40));
        graph[3].add(new Edge(3, 2, 10));
        graph[3].add(new Edge(3, 4, 2));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 6, 8));

        graph[5].add(new Edge(5, 2, 3));
        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));

        graph[6].add(new Edge(6, 4, 8));
        graph[6].add(new Edge(6, 5, 3));
        HashSet<Integer> hs=new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            // if (!hs.contains(i)) {
                cycleAndPath(graph, i,i, hs, i+"");
                
            // }
            
        } 
    }
}
