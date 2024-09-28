import java.io.*;
import java.util.Arrays;

public class Main {
    public static int n;
    public static int[][] houses;
    public static int[][] dp=new int[1004][3];
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(bf.readLine());
        houses=new int[n][3];
        for(int i=0;i<n;i++){
            String s=bf.readLine();
            String[] s1 = s.split(" ");
            houses[i][0]=Integer.parseInt(s1[0]);
            houses[i][1]=Integer.parseInt(s1[1]);
            houses[i][2]=Integer.parseInt(s1[2]);
        }
        dp[0][0]=houses[0][0];
        dp[0][1]=houses[0][1];
        dp[0][2]=houses[0][2];
        for(int i=1;i<n;i++){
            dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+houses[i][0];
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+houses[i][1];
            dp[i][2]=Math.min(dp[i-1][1],dp[i-1][0])+houses[i][2];
        }
        int maxn=dp[n-1][0];
        maxn=Math.min(maxn,dp[n-1][1]);
        maxn=Math.min(maxn,dp[n-1][2]);
        System.out.println(maxn);
    }

}
