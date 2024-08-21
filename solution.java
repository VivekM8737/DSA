import java.io.*;
import java.util.*;
import java.lang.Math;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class solution {
    static int MOD=1000000007;
    public static int get_ans(int N, int M, int K, int two, List<Integer> V, List<List<Integer>> E) {
        List<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (List<Integer> edge : E) {
            int u = edge.get(0);
            int child = edge.get(1);
            adj[u].add(child);
            adj[child].add(u);
        }
        int[][] dp = new int[N + 1][K + 1];
        int[] count = new int[N + 1];
        dfs(1, -1, adj, V, dp, count, K);
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = (ans + dp[i][K]) % MOD;
        }
        return ans;
    }

    private static void dfs(int node, int parent, List<Integer>[] adj, List<Integer> v, int[][] dp, int[] count, int k) {
        if (v.get(node - 1) <= k) {
            dp[node][v.get(node - 1)] = 1;
        }
        for (int child : adj[node]) {
            if (child == parent) continue;
            dfs(child, node, adj, v, dp, count, k);
            for (int i = 0; i <= k; i++) {
                for (int j = 0; i + j <= k; j++) {
                    dp[node][i + j] = (int) ((dp[node][i + j] + (long) dp[node][i] * dp[child][j]) % MOD);
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    
        int N = Integer.parseInt(scan.nextLine().trim());
        
        int M = Integer.parseInt(scan.nextLine().trim());
        
        int K = Integer.parseInt(scan.nextLine().trim());
        
        int two = Integer.parseInt(scan.nextLine().trim());
        
        List<Integer> V = new ArrayList<>(N);
        for(int j=0; j<N; j++) {
            V.add(Integer.parseInt(scan.nextLine().trim()));
        }
        
        List<List<Integer>> E = new ArrayList<>(M);
        for(int i=0; i<M; i++) {
            E.add(
                Arrays.asList(scan.nextLine().trim().split(" "))
                .stream().map(s -> Integer.parseInt(s)).collect(toList())
            );
        }
        int result = get_ans(N, M, K, two, V, E);
    
        System.out.println(result);
    }
}