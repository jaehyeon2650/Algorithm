import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int maxns = 0;
    private static int m;
    private static int[] dp;
    private static List<Thing> things = new ArrayList<>();

    static class Thing {
        public int weight;
        public int value;

        public Thing(final int weight, final int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new int[m + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            things.add(new Thing(weight, value));
        }

        for (int i = 0; i < things.size(); i++) {
            for (int j = m; j >= things.get(i).weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - things.get(i).weight] + things.get(i).value);
                maxns = Math.max(maxns, dp[j]);
            }
        }
        System.out.println(maxns);
    }
}
