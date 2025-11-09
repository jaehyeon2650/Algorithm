import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static int n;
    public static int[] psums;
    public static int[][] dp;
    public static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        psums = new int[n + 1];
        dp = new int[4][n + 1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            psums[i] = psums[i - 1] + num;
        }
        k = Integer.parseInt(bf.readLine());

        for (int i = 1; i <= 3; i++) {
            for (int j = i * k; j <= n; j++) {
                dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j-k]+psums[j]-psums[j-k]);
            }
        }
        System.out.println(dp[3][n]);
    }


}
