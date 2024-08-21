import java.util.ArrayList;
import java.util.Scanner;

public class getCloseFriend {
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
    public static void paths(ArrayList<Edge>[] graph,int src,int [] visited, ArrayList<Integer> temp){
        visited[src]=1;
        temp.add(src);
        for(Edge e :graph[src]){
            if (visited[e.to]!=1) {
                paths(graph, e.to, visited,temp);
            
            }
        }
    }
    public static int no_pair(ArrayList<Edge>[] graph){
        int [] visited=new int[graph.length];
        ArrayList<ArrayList<Integer>> connectedComponent=new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]!=1) {
                ArrayList<Integer> temp=new ArrayList<>();
                paths(graph, i,visited,temp);
                connectedComponent.add(temp);

            }
            
        }
        int count =0;
        for (int i = 0; i < connectedComponent.size(); i++) {
            for (int j = i+1; j < connectedComponent.size(); j++) {
                count+=connectedComponent.get(i).size()*connectedComponent.get(j).size();
            }
        }
        return count;

    }
    public static void main(String[] args) {
        System.out.println("Enter the number of node in graph: ");
        Scanner s =new Scanner(System.in);
        int n_node=s.nextInt();
        ArrayList<Edge>[] graph=new ArrayList[n_node];
        for (int i = 0; i < n_node; i++) {
            graph[i]=new ArrayList<>();
        }
        System.out.println("Enter the number of edge in graph: ");
        int n_edge=s.nextInt();
        System.out.println("Enter the first friends and second friends: ");
        for (int i = 0; i < n_edge; i++) {
            int f1=s.nextInt();
            int f2=s.nextInt();
            graph[f1].add(new Edge(f1, f2,10));
            graph[f2].add(new Edge(f2, f1,10));
        }
        System.out.println(no_pair(graph));
        
        

    }
}
