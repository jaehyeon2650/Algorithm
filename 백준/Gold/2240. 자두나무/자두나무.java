import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static int[] apples;
    private static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[2][m + 1][n + 1];
        apples = new int[n];
        for (int i = 0; i < n; i++) {
            apples[i] = Integer.parseInt(bf.readLine());
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(Math.max(go(0, 0, 0), go(1, 1, 0)));
    }

    private static int go(int cur, int count, int number) {
        if (count > m) {
            return 0;
        }
        if (number == n) {
            return 0;
        }
        if (dp[cur][count][number] != -1) {
            return dp[cur][count][number];
        }

        int maxn = 0;

        maxn = Math.max(go(cur, count, number + 1), maxn);
        maxn = Math.max(go((cur + 1) % 2, count + 1, number + 1), maxn);
        int i = (apples[number] == cur + 1 ? 1 : 0);
        dp[cur][count][number] = maxn + i;
        return dp[cur][count][number];
    }


}


