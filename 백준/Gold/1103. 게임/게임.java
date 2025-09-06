import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static int[][] dp;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int[][] graph;
    private static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n][m];
        graph = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < n; i++) {
            String line = bf.readLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                if (c == 'H') {
                    graph[i][j] = -1;
                } else {
                    graph[i][j] = c - '0';
                }
            }
        }
        int count = go(0, 0);
        if (count == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }

    private static int go(int y, int x) {
        if (visited[y][x] == 1) {
            return Integer.MAX_VALUE;
        }
        if (dp[y][x] != -1) {
            return dp[y][x];
        }
        visited[y][x] = 1;
        int maxn = Integer.MIN_VALUE;

        for (int i = 0; i < 4; i++) {
            int now = 0;
            int ny = y + (dy[i] * graph[y][x]);
            int nx = x + (dx[i] * graph[y][x]);
            if (ny < 0 || nx < 0 || ny >= n || nx >= m || graph[ny][nx] == -1) {
                now = 0;
            } else {
                now = go(ny, nx);
            }
            maxn = Math.max(maxn, now);
        }

        if (maxn == Integer.MAX_VALUE) {
            return maxn;
        }
        dp[y][x] = maxn + 1;
        visited[y][x] = 0;
        return dp[y][x];
    }
}


