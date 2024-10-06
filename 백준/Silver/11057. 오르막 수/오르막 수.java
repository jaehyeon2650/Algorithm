import java.io.*;

public class Main {
    public static int n;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(bf.readLine());
        dp=new int[10][n+1];
        for(int i=0;i<10;i++){
            dp[i][1]=1;
        }
        for(int i=2;i<=n;i++){
            for(int j=0;j<10;j++){
                int ret=0;
                for(int k=0;k<=j;k++){
                    ret=(ret+dp[k][i-1])%10007;
                }
                dp[j][i]=ret;
            }
        }
        int sum=0;
        for(int i=0;i<10;i++){
            sum=(sum+dp[i][n])%10007;
        }
        System.out.println(sum);
    }
}
