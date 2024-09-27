import java.io.*;
import java.util.Arrays;

public class Main {
    public static int n;
    public static int k;
    public static int[][] dp=new int[204][204];
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String s=bf.readLine();
        String[] s1 = s.split(" ");
        n=Integer.parseInt(s1[0]);
        k=Integer.parseInt(s1[1]);
        dp[0][0]=1;
        for(int i=0;i<=n;i++){
            dp[1][i]=1;
        }
        for(int i=2;i<=k;i++){
            for(int j=0;j<=n;j++){
                for(int k=0;k<=j;k++){
                    dp[i][j]+=dp[i-1][j-k];
                    dp[i][j]%=1000000000;
                }
            }
        }
        System.out.println(dp[k][n]);
    }

}
