import java.io.*;

public class Main {
    public static int n;
    public static int[] a;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(bf.readLine());
        a=new int[n+1];
        dp=new int[n+1];
        for(int i=0;i<n;i++){
            a[i+1]=Integer.parseInt(bf.readLine());
        }
        dp[1]=a[1];
        if(n>=2){
            dp[2]=dp[1]+a[2];
        }
        for(int i=3;i<=n;i++){
            dp[i]=Math.max(dp[i-2],dp[i-3]+a[i-1])+a[i];
            dp[i]=Math.max(dp[i],dp[i-1]);
        }
        System.out.println(dp[n]);
    }
}
