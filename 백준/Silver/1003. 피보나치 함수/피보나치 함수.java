import java.io.*;

public class Main {
    public static int n;
    public static int t;
    public static int[][] dp=new int[41][2];
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb=new StringBuffer();
        t=Integer.parseInt(bf.readLine());
        dp[0][0]=1;
        dp[0][1]=0;
        dp[1][0]=0;
        dp[1][1]=1;
        for(int i=2;i<41;i++){
            dp[i][0]=dp[i-1][0]+dp[i-2][0];
            dp[i][1]=dp[i-1][1]+dp[i-2][1];
        }
        for(int i=0;i<t;i++){
            n=Integer.parseInt(bf.readLine());
            sb.append(dp[n][0]+" "+dp[n][1]+"\n");
        }
        System.out.println(sb);
    }

}
