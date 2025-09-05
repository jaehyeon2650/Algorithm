import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;

    private static long[][] dp;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        graph = new int[n][n];
        dp = new long[n][1 << n];
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(go(1, 0));
    }

    private static long go(int visited, int cur) {
        if (visited == ((1 << n) - 1)) {
            if (graph[cur][0] == 0) {
                return Integer.MAX_VALUE;
            }
            return graph[cur][0];
        }
        if (dp[cur][visited] != 0) {
            return dp[cur][visited];
        }
//        if (dp[cur][visited] != -1) return dp[cur][visited];

        long maxn = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if ((visited & (1 << i)) != 0) {
                continue;
            }
            if (graph[cur][i] == 0) {
                continue;
            }
            maxn = Math.min(maxn, go(visited | (1 << i), i) + graph[cur][i]);
        }
        dp[cur][visited] = maxn;
        return dp[cur][visited];
    }
}