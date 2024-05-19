import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

class iterative_bfs {
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
        int src;
        String path;
        public Pair(int src,String path){
            this.path=path;
            this.src=src;
        }
    }
    public static String it_dfs(ArrayList<Edge>[] graph,int src,int des){
        Stack<Pair> st=new Stack<>();
        boolean [] visited =new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i]=false;
        }
        String psf="";
        st.push(new Pair(src, src+""));
        while(st.size()>0){
            Pair p=st.pop();
            if (p.src==des) {
                psf=p.path;
                break;
            }
            if (!visited[p.src]) {
                visited[p.src]=true;
                for (Edge e : graph[p.src]) {
                    if (!visited[e.nbr]) {
                        st.push(new Pair(e.nbr, p.path+e.nbr));
                    }
                }
            }
        }
        return psf;
    }
    public static void main(String[] args) {
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
        System.out.println(it_dfs(graph, 0, 5));
        
    }
}
