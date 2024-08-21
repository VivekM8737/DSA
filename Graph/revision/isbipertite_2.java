import java.util.ArrayDeque;
import java.util.Arrays;

class isbipartite_2 {
    public static class Pair{
        int v;
        int step;
        public Pair(int v, int step){
            this.v=v;
            this.step=step;
        }
    }
    public static boolean forAll(int [][] graph,ArrayDeque<Pair> q,int[]visited){
        while(q.size()>0){
            Pair rm=q.remove();
            // if(q.size()==0){
            //     maxTemp=rm.step;
            // }
            if(visited[rm.v]!=-1){
                if(rm.step!=visited[rm.v]){
                    System.out.print(rm.step+" "+visited[rm.v]+" "+rm.v);
                    return false;
                }
            }
            visited[rm.v]=rm.step;
            for(int i=0; i< graph[rm.v].length; i++){
                if(visited[graph[rm.v][i]-1]==-1){
                    q.add(new Pair(graph[rm.v][i]-1,rm.step+1));
                }
            }
        }
        return true;
    }
    public static boolean isBipartite(int[][] graph) {
        int[] visited=new int [graph.length];
        Arrays.fill(visited,-1);
        for(int i=0;i<visited.length;i++){
            if(visited[i]==-1){
                ArrayDeque<Pair> q = new ArrayDeque<>();
                q.add(new Pair(i,0));
                if(!forAll(graph,q,visited)){
                    return false;
                }

            }
        }
        
        return true;
    }
    public static void main(String[] args) {
        int [][] graph={{1,2},{2,3},{3,1}};
        // [[1,2],[1,4],[1,5],[2,6],[2,3],[4,6]]
        // [[1,2],[2,3],[3,1]]
        System.out.println(isBipartite(graph));
    }
}
