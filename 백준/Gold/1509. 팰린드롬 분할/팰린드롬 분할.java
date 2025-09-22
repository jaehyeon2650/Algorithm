import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    private static int[][] pals;
    private static int[] dp;
    private static int n;
    private static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        input = bf.readLine();
        n = input.length();
        dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        pals = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (pals[i][j] == 0) {
                    go(i, j);
                }
            }
        }
        System.out.println(go2(0));
    }

    public static int go(int x, int y) {
        if (x > y) {
            return 2;
        }
        if (pals[x][y] != 0) {
            return pals[x][y];
        }
        if (input.charAt(x) != input.charAt(y)) {
            pals[x][y] = 1;
            return 1;
        }
        int result = go(x + 1, y - 1);
        pals[x][y] = result;
        return result;
    }

    public static int go2(int now) {
        if(now>=n) return 0;
        if(dp[now]!=Integer.MAX_VALUE) return dp[now];
        int result = dp[now];
        for(int i=now;i<n;i++){
            if(pals[now][i]==2) result = Math.min(result,go2(i+1)+1);
        }
        dp[now]=result;
        return result;
    }
}
