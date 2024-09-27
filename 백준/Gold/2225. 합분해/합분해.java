import java.io.*;
import java.util.Arrays;

public class Main {
    public static int n;
    public static int k;
    public static int[][] dp=new int[204][204];
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<204;i++){
            Arrays.fill(dp[i],-1);
        }
        String s=bf.readLine();
        String[] s1 = s.split(" ");
        n=Integer.parseInt(s1[0]);
        k=Integer.parseInt(s1[1]);
        System.out.println(go(0,0));

    }
    public static int go(int cnt,int sum){
        if(cnt==k){
            if(sum==n) return 1;
            return 0;
        }
        if(dp[cnt][sum]!=-1) return dp[cnt][sum];
        int ret=0;
        for(int i=0;i<=n;i++){
            if(sum+i<=n){
                ret+=go(cnt+1,sum+i);
                ret%=1000000000;
            }
        }
        dp[cnt][sum]=ret;
        return ret;
    }
}
