import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class hamltonian {
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
    public static boolean allvisited(boolean[] visted){
        for (int i = 0; i < visted.length; i++) {
            if (!visted[i]) {
                return false;
            }
        }
        return true;
    }
    public static void printHamiltonianCycleAndPath(ArrayList<Edge>[] graph,int src,int des,HashSet<Integer>visited,String pth,int orgsrc){
        if (visited.size()==graph.length-1) {
            for(Edge e: graph[src]){
                if (orgsrc==e.nbr) {
                    System.out.println(pth+" hamltonianCycle");
                    return;
                }
            }
            System.out.println(pth+" hamltonian path");
            return;
        }
        visited.add(src);
        for(Edge e: graph[src]){
            
            if (!visited.contains(e.nbr)) {
                printHamiltonianCycleAndPath(graph, e.nbr, des, visited, pth+e.nbr,orgsrc);
            }
        }
        visited.remove(src);
    }
    
    public static void main(String[] args) { 

        ArrayList <Edge>[] graph = new ArrayList[7];
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
        boolean [] visited =new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i]=false;
        }
        HashSet<Integer> visit=new HashSet();
        printHamiltonianCycleAndPath(graph,0,6,visit,0+"",0);

    }
}
