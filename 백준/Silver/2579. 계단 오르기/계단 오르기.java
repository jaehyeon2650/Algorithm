import java.io.*;

public class Main {
    public static int n;
    public static int[] a;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(bf.readLine());
        a=new int[n+1];
        dp=new int[n+1][3];
        for(int i=0;i<n;i++){
            a[i+1]=Integer.parseInt(bf.readLine());
        }
        dp[1][1]=a[1];
        for(int i=2;i<=n;i++){
            dp[i][1]=Math.max(dp[i-2][1],dp[i-2][2])+a[i];
            dp[i][2]=dp[i-1][1]+a[i];
        }
        System.out.println(Math.max(dp[n][1],dp[n][2]));
    }
}
