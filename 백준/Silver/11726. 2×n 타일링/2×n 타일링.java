import java.io.*;

public class Main {
    public static int n;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(bf.readLine());
        dp=new int[1004];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%10007;
        }
        System.out.println(dp[n]);
    }

}
