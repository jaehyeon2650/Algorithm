import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[][] graph;
    private static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        graph = new int[n][n];
        dp = new int[n][n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(go(0, 1, 0));

    }

    private static int go(int y, int x, int status) {
        if (dp[y][x][status] != -1) {
            return dp[y][x][status];
        }
        if (y == n - 1 && x == n - 1) {
            return 1;
        }

        int total = 0;
        if (status == 0) {
            if (canGoRight(y, x)) {
                total += go(y, x + 1, 0);
            }
            if (canGoSlash(y, x)) {
                total += go(y + 1, x + 1, 2);
            }
        }

        if (status == 1) {
            if (canGoDown(y, x)) {
                total += go(y + 1, x, 1);
            }
            if (canGoSlash(y, x)) {
                total += go(y + 1, x + 1, 2);
            }
        }

        if (status == 2) {
            if (canGoRight(y, x)) {
                total += go(y, x + 1, 0);
            }
            if (canGoDown(y, x)) {
                total += go(y + 1, x, 1);
            }
            if (canGoSlash(y, x)) {
                total += go(y + 1, x + 1, 2);
            }
        }

        dp[y][x][status] = total;

        return total;
    }

    private static boolean canGoSlash(int y, int x) {
        int[] dy = {0, 1, 1};
        int[] dx = {1, 0, 1};

        for (int i = 0; i < 3; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= n || graph[ny][nx] == 1) {
                return false;
            }
        }

        return true;
    }

    private static boolean canGoRight(int y, int x) {
        int ny = y;
        int nx = x + 1;
        if (ny < 0 || nx < 0 || ny >= n || nx >= n || graph[ny][nx] == 1) {
            return false;
        }
        return true;
    }

    private static boolean canGoDown(int y, int x) {
        int ny = y + 1;
        int nx = x;
        if (ny < 0 || nx < 0 || ny >= n || nx >= n || graph[ny][nx] == 1) {
            return false;
        }
        return true;
    }


}


