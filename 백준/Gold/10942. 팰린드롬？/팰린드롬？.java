import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    private static int n;
    private static int m;
    private static int[] arr;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = isPal(i, j);
            }
        }

        m = Integer.parseInt(bf.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(dp[start - 1][end - 1] - 1 + "\n");
        }

        System.out.println(sb);
    }

    private static int isPal(int start, int end) {
        if (start > end) {
            return 2;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        int result = 0;
        if (arr[start] != arr[end]) {
            result = 1;
        } else {
            result = 2;
            if (isPal(start+1, end-1) == 1) {
                result = 1;
            }
        }
        dp[start][end] = result;
        return dp[start][end];
    }

}
