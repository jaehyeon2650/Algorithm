import java.io.*;
import java.util.Arrays;

public class Main {
    public static int n;
    public static int[][] dp;
    public static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(bf.readLine());
        a=new int[n+1];
        dp=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        String s=bf.readLine();
        String[] s1 = s.split(" ");
        for(int i=0;i<n;i++){
            a[i+1]=Integer.parseInt(s1[i]);
        }
        System.out.println(dfs(0,0));
    }

    public static int dfs(int count,int sum){
        if(sum==n) return 0;
        if(sum>n) return Integer.MIN_VALUE;
        if(dp[count][sum]!=-1) return dp[count][sum];

        int ret=0;
        for(int i=1;i<=n;i++){
            ret=Math.max(ret,dfs(count+1,sum+i)+a[i]);
        }
        dp[count][sum]=ret;
        return ret;
    }

}
