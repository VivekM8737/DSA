import java.util.ArrayDeque;
import java.util.ArrayList;

public class SpredDecise {
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
    public static class Pair{
        int v;
        String path;
        int level;
        public Pair(int v,String path,int level){
            this.v=v;
            this.path=path;
            this.level=level;
        }
    }
    public static void infected(ArrayList<Edge>[] graph,int [] visited,int time,ArrayDeque<Pair> q ){
        // System.out.println(q.peek().v+"->"+q.peek().level);
        if (q.peek().level>time) {
            q.remove();
            return;
        }
        if (q.size()<=0) {
            return;
        }
        Pair x=q.remove();
        if (visited[x.v]==-1) {
            visited[x.v]=x.v;
            for (Edge e : graph[x.v]) {
                if (visited[e.nbr]==-1 ) {
                    // System.out.println(x.v+"->"+e.nbr+"->"+x.level);
                    q.add(new Pair(e.nbr, x.path+e.nbr, x.level+1));
                    infected(graph, visited, time, q);
                }
            }
        }

    }
    public static int sirInfected(ArrayList<Edge>[] graph,int time,int start){
        int[] visited =new int[graph.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i]=-1;
        }
        ArrayDeque<Pair> que=new ArrayDeque<>();
        que.add(new Pair(start, start+"", 1));
        int count=0;
        while (que.size()>0) {
            Pair p=que.removeFirst();
            if (p.level>time) {
                break;
            }
            if (visited[p.v]==-1) {
                visited[p.v]=p.level;
                for (Edge e : graph[p.v]) {
                    if (visited[e.nbr]==-1) {
                        que.add(new Pair(e.nbr, p.path+e.nbr, p.level+1));
                        count++;
                    }
                }
                
            }

        }
        return count;
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
        graph[4].add(new Edge(4, 6, 8));
        
        // graph[5].add(new Edge(5, 2, 3));
        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));

        graph[6].add(new Edge(6, 4, 8));
        graph[6].add(new Edge(6, 5, 3));
        ArrayDeque<Pair> q =new ArrayDeque<>();
        int [] visited =new int[graph.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i]=-1;
        }
        int start=6;
        q.add(new Pair(start, start+"", 0));
        infected(graph, visited, 3, q);
        int i=0;
        int count=0;
        while(visited.length>i){
            if (visited[i]!=-1) {
                count++;
                System.out.println(visited[i]);
            }
            i++;
        }
        System.out.println("this are "+count+" Infected");
        System.out.println(sirInfected(graph, 3,start));


       
    }
}
