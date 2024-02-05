import java.util.ArrayList;

public class getConnected {
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
    public static void connectes(ArrayList<Edge>[] gph,int src,boolean [] visited,ArrayList<Integer> c){
        visited[src]=true;
        c.add(src);
        for(Edge e:gph[src]){  
            if (!visited[e.nbr]) {
                connectes(gph, e.nbr,visited,c);
            }
        }

    }

    public static void main(String[] args) {
        ArrayList<Edge>[] gph=new ArrayList[7];
        for(int i=0;i<gph.length;i++){
            gph[i]=new ArrayList<>();
        }
        gph[0].add(new Edge(0, 1, 10));
        // gph[0].add(new Edge(0, 3, 40));

        gph[1].add(new Edge(1, 0, 10));
        // gph[1].add(new Edge(1, 2, 10));

        // gph[2].add(new Edge(2, 1, 10));
        gph[2].add(new Edge(2, 3, 10));

        // gph[3].add(new Edge(3, 0, 40));
        gph[3].add(new Edge(3, 2, 10));
        // gph[3].add(new Edge(3, 4, 2));

        // gph[4].add(new Edge(4, 3, 2));
        gph[4].add(new Edge(4, 5, 3));
        gph[4].add(new Edge(4, 6, 8));
        
        gph[5].add(new Edge(5, 6, 3));
        gph[5].add(new Edge(5, 4, 3));

        gph[6].add(new Edge(6, 5, 3));
        gph[6].add(new Edge(6, 4, 8));
        boolean [] visited =new boolean[gph.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i]=false;
        }
        ArrayList<ArrayList<Integer>> ls=new ArrayList<>();
        for (int i = 0; i < gph.length; i++) {
            ArrayList<Integer> comb=new ArrayList<>();
            if (!visited[i]) {
                connectes(gph,i,visited,comb);
                ls.add(comb);
            }
            
        }
        System.out.println(ls);

    }
}
