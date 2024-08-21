import java.util.ArrayList;

public class isGraphConnected {
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
    public static void connected(ArrayList<Edge>[] graph,int src,int [] visited,ArrayList<Integer> temp){
        visited[src]=1;
        temp.add(src);
        for(Edge e :graph[src]){
            if (visited[e.to]!=1) {
                connected(graph, e.to, visited,temp);
            }
        }
        

    }
    public static boolean isConnected(ArrayList<Edge>[]graph){
        int [] visited=new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            visited[i]=-1;
        }
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            ArrayList<Integer> temp=new ArrayList<>();
            if (visited[i]!=1) {
                connected(graph, i, visited, temp);
                ans.add(temp);

            }
    
        }if (ans.size()>1) {
            return false;
        }
        else{
            return true;
        }
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
        graph[0].add(new Edge(0, 3, 40));
    

        graph[1].add(new Edge(1, 0, 10));
        // graph[1].add(new Edge(1, 2, 10));

        // graph[2].add(new Edge(2, 1, 10));
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
        
       
        System.out.println(isConnected(graph));
                

    }
}
