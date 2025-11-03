import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static class City {
        int cost;
        int num;

        public City(final int cost, final int num) {
            this.cost = cost;
            this.num = num;
        }
    }

    private static int n;
    private static int m;
    private static int[] dp;
    private static List<City> cites = new ArrayList<>();
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n + 101];
        Arrays.fill(dp, 99999999);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            cites.add(new City(cost, num));
        }
        dp[0] = 0;
        for (int i = 1; i <= n + 100; i++) {
            for (City city : cites) {
                if (i - city.num >= 0 && dp[i - city.num] != 99999999) {
                    dp[i] = Math.min(dp[i], dp[i - city.num] + city.cost);
                }
            }

            if (i >= n) {
                if (dp[i] != 0) {
                    result = Math.min(dp[i], result);
                }
            }
        }
        System.out.println(result);
    }
}
