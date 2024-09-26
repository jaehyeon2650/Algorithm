import java.io.*;
import java.util.Arrays;

public class Main {
    public static int n;
    public static int[] dp=new int[5004];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        dp=new int[n+1];
        Arrays.fill(dp,5000);
        dp[0]=0;
        for(int i=3;i<=n;i++){
            if(i-3>=0) dp[i]=Math.min(dp[i],dp[i-3]+1);
            if(i-5>=0) dp[i]=Math.min(dp[i],dp[i-5]+1);
        }
        if(dp[n]==5000) System.out.println(-1);
        else System.out.println(dp[n]);
    }
}
