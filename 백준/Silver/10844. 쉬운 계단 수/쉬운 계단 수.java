import java.io.*;

public class Main {
    public static int n;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(bf.readLine());
        dp=new int[n+1][10];
        for(int i=0;i<10;i++){
            dp[1][i]=1;
        }
        dp[1][0]=0;
        for(int i=2;i<=n;i++){
            for(int j=0;j<10;j++){
                if(j-1>=0) dp[i][j]=(dp[i][j]+dp[i-1][j-1])%1000000000;
                if(j+1<10) dp[i][j]=(dp[i][j]+dp[i-1][j+1])%1000000000;
            }
        }
        int sum=0;
        for(int i=0;i<10;i++){
            sum+=dp[n][i];
            sum%=1000000000;
        }
        System.out.println(sum);
    }

}
