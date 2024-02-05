import java.util.ArrayList;
import java.util.Scanner;

public class perfectFriendPr {
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
    public static void getConnected(ArrayList<Edge> [] graph,int s,ArrayList<Integer> comb,boolean[] visited){
        visited[s]=true;
        comb.add(s);
        for (Edge e : graph[s]) {
            if (!visited[e.nbr]) {
                getConnected(graph, e.nbr, comb, visited);
            }
        }
    }
    public static class Pair{
        int m1;
        int m2;
        public Pair(int m1,int m2){
            this.m1=m1;
            this.m2=m2;
        }
    }
    public static ArrayList<Pair> perfectFr(ArrayList<ArrayList<Integer>> s){
        int outer=s.size();
        ArrayList<Pair> ps=new ArrayList<>();
        for (int i = 0; i < outer-1; i++) {
            for (int j = i+1; j < outer; j++) {
                for (int j2 = 0; j2 < s.get(i).size(); j2++) {
                    for (int k = 0; k < s.get(j).size(); k++) {
                        ps.add(new Pair(s.get(i).get(j2), s.get(j).get(k)));
                    }
                }
            }
        }
        return ps;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the number of verteces: ");
        int nver=s.nextInt();
        ArrayList<Edge> [] graph=new ArrayList[nver];
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        System.out.println("Enter the number of Edges: ");
        int nedge=s.nextInt();
        for (int i = 0; i < nedge; i++) {
            System.out.println("Enter the src: ");
            int src=s.nextInt();
            System.out.println("Enter the neighbour: ");
            int nbr=s.nextInt();
            graph[src].add(new Edge(src, nbr, 10));
            graph[nbr].add(new Edge(nbr, src, 10));
        }
        ArrayList<ArrayList<Integer>> l=new ArrayList<>();
        boolean[] visited =new boolean[nver];
        for (int i = 0; i < visited.length; i++) {
            visited[i]=false;
        }
        for (int i = 0; i < graph.length; i++) {
            ArrayList<Integer> comb=new ArrayList<>();
            if (!visited[i]) {
                getConnected(graph,i,comb,visited);
                l.add(comb);
            }
        }
        System.out.println(l);
        ArrayList<Pair> p= perfectFr(l);
        for (int i = 0; i < p.size(); i++) {
            System.out.println(p.get(i).m1+" "+p.get(i).m2);
        }
        System.out.println();
    }
}
