import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class graphQuestions {
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
        static int efficientPathCost=Integer.MAX_VALUE;
        static int worstPathCost=Integer.MIN_VALUE;
        static int justLargerThan40Cost=Integer.MAX_VALUE;
        static int justSmallThan40Cost=Integer.MIN_VALUE;
        static int n_th=0;
        static HashMap<Integer,String> n_thpath=new HashMap<>();
        static String efficientPath;
        static String worstPath;
        static String justLargerThan40path;
        static String justSmallThan40path;
    public static void paths(ArrayList<Edge>[] graph,int src,int des,String path,int [] visited,int cost,PriorityQueue<Integer> pq,int n){
        if (src==des) {
            if (cost>40 && justLargerThan40Cost>cost) {
                justLargerThan40Cost= cost;
                justLargerThan40path=path+"@"+justLargerThan40Cost;
            }
            if (cost<40 && justSmallThan40Cost<cost) {
                justSmallThan40Cost= cost;
                justSmallThan40path=path+"@"+justSmallThan40Cost;
            }
            if (efficientPathCost>cost) {
                efficientPathCost=cost;
                efficientPath=path+"@"+cost;
            }
            if (worstPathCost<cost) {
                worstPathCost=cost;
                worstPath=path+"@"+cost;
            }
            all_paths+=path+"@"+cost+" ";
            if (pq.size()<n) {
                pq.add(cost);
               if (n_th!=pq.peek()) {
                    n_th=pq.peek();
               } 
               n_thpath.put(cost, path);
            }else{
                if (pq.peek()<cost) {
                    
                    n_thpath.remove(pq.remove());
                    pq.add(cost);
                    n_thpath.put(cost, path);
                    if (n_th!=pq.peek()) {
                        n_th=pq.peek();
                   } 
                }
            }
            return;
        }
        visited[src]=1;
        for(Edge e :graph[src]){
            if (visited[e.to]!=1) {
            
                paths(graph, e.to,des, path+e.to, visited,cost+e.cost,pq,n);
            }
        }
        visited[src]=-1;
        

    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the n in nth_greator number: ");
        int n=s.nextInt();
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
        int [] visited=new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            visited[i]=-1;
        }
        all_paths="";
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        paths(graph, 0, 6, "0", visited,0,pq,n);
        System.out.println(all_paths);
        System.out.println("eff "+efficientPath);
        System.out.println("worst "+worstPath);
        System.out.println("justLager "+justLargerThan40Cost);
        System.out.println("justSmaller "+justSmallThan40path);
        System.out.println(n_thpath.get(n_th)+"@"+n_th);

         HashMap<Integer,Integer> hm = new HashMap<>();
         hm.co       

    }
}
