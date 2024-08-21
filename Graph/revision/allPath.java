import java.util.ArrayList;
import java.util.Scanner;

class allPath{
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
        static String all_paths;
    public static void paths(ArrayList<Edge>[] graph,int src,int des,String path,int [] visited){
        if (src==des) {
            all_paths+=path+" ";
            return;
        }
        visited[src]=1;
        for(Edge e :graph[src]){
            if (visited[e.to]!=1) {
            
                paths(graph, e.to,des, path+e.to, visited);
            }
        }
        visited[src]=-1;
        

    }
    public static void main(String[] args) {
        // System.out.println("Enter the number of node in graph: ");
        // Scanner s =new Scanner(System.in);
        // int n_node=s.nextInt();
        ArrayList<Edge>[] graph=new ArrayList[7];
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 10));
    

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 10));

        graph[2].add(new Edge(2, 0, 10));
        graph[2].add(new Edge(2, 3, 10));
        graph[2].add(new Edge(2, 4, 10));

        graph[3].add(new Edge(3, 1, 10));
        graph[3].add(new Edge(3, 2, 10));

        graph[4].add(new Edge(4, 2, 10));
        graph[4].add(new Edge(4, 5, 10));
        graph[4].add(new Edge(4, 6, 10));

        graph[5].add(new Edge(5, 4, 10));
        graph[5].add(new Edge(5, 6, 10));

        graph[6].add(new Edge(6, 4, 10));
        graph[6].add(new Edge(6, 5, 10));
        int [] visited=new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            visited[i]=-1;
        }
        all_paths="";
        paths(graph, 0, 6, "0", visited);
        System.out.println(all_paths);

                

    }
}