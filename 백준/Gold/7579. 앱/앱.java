import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    private static int[][] dp = new int[104][10004];
    private static int n;
    private static int m;
    private static int[] memories;
    private static int[] costs;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        memories = new int[n];
        costs = new int[n];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            memories[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=n;i++){
            int memory = memories[i-1];
            int cost = costs[i-1];
            for(int j=0;j<10001;j++){
                if(j-cost>=0){
                    dp[i][j] = Math.max(dp[i-1][j-cost]+memory,dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }

                if(dp[i][j]>=m){
                    result = Math.min(result, j);
                }

            }
        }
        System.out.println(result);
    }


}
