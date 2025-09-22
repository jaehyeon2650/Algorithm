import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    private static int n;
    private static long dp[][] = new long[22][102];
    private static int a[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        a = new int[n + 1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<22;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(go(a[0],1));

    }

    private static long go(int now, int ind){
        if(ind==n-1) {
            if (now == a[n - 1])
                return 1;
            else
                return 0;
        }
        if(dp[now][ind]!=-1) return dp[now][ind];;
        long total = 0;
        if(now-a[ind]>=0 && now-a[ind]<=20){
            total+=go(now-a[ind],ind+1);
        }
        if(now+a[ind]>=0 && now+a[ind]<=20){
            total+=go(now+a[ind],ind+1);
        }

        dp[now][ind]=total;
        return total;
    }
}
