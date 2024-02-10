import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class isPertiteGraph {
    public static class Edge{
        int src;
        int wt;
        int nbr;
        public Edge(int src,int nbr, int wt){
            this.nbr=nbr;
            this.src=src;
            this.wt=wt;
        }
    }
    public static class Pair{
        int v;
        String path;
        int level;
        public Pair(int src,String path,int level){
            this.path=path;
            this.v=src;
            this.level=level;
        }
    }
    static boolean oddcycle;
    static HashSet<Integer> st1;
    static HashSet<Integer> st2;
    public static boolean haveoddcycle(ArrayList<Edge>[] graph,int [] visited,ArrayDeque<Pair> q){
        if (q.size()<=0) {
            return false;
        }
        Pair x=q.remove();
        if (x.level%2==0) {
            st1.add(x.v);
        }
        else{
            st2.add(x.v);
        }
        if (visited[x.v]==-1) {
            visited[x.v]=x.level;
            for (Edge e : graph[x.v]) {
                if (visited[e.nbr]==-1) {
                        q.add(new Pair(e.nbr, x.path+e.nbr,x.level+1));
                }
                    
            }
            
        }else{
            System.out.println(x.path);
            if (visited[x.v]!=x.level) {
                oddcycle =true;
                
            }
        }
        haveoddcycle(graph, visited, q);
        
        return oddcycle;
    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph=new ArrayList[7];
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 3, 10));
        
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
        // graph[4].add(new Edge(4, 6, 8));
        
        // graph[5].add(new Edge(5, 2, 3));
        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));

        // graph[6].add(new Edge(6, 4, 8));
        graph[6].add(new Edge(6, 5, 3));
        ArrayDeque<Pair> q =new ArrayDeque<>();
        st1=new HashSet<>();
        st2=new HashSet<>();
        int [] visited =new int[graph.length];
        oddcycle=false;
        for (int i = 0; i < visited.length; i++) {
            visited[i]=-1;
        }
        for (int i = 0; i < graph.length; i++) {
            if (visited[i]==-1) {
                q.add(new Pair(i,i+"",0));
                haveoddcycle(graph, visited, q);
            }
        }
        if (!oddcycle && st1.size()+st2.size()==graph.length ) {
            System.out.println(oddcycle);
            System.out.println("Yes");
            System.out.println(st1);
            System.out.println(st2);
        }
        else{
            System.out.println(oddcycle);
            System.out.println("No");
            System.out.println(st1);
            System.out.println(st2);
        }


    }
}
