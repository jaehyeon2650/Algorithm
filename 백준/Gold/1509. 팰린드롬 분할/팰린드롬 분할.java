import java.io.*;
import java.util.Arrays;

public class Main {
    public static int n;
    public static int[][] dp=new int[2501][2501];
    public static int[] dp2=new int[2501];
    public static String s;
    public static int mimm=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s=br.readLine();
        n=s.length();
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        Arrays.fill(dp2,-1);
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                go(i,j);
            }
        }
        Arrays.fill(dp2,99999999);
        System.out.println(go2(0));
    }
    public static int go(int x,int y){
        if(dp[x][y]!=-1) return dp[x][y];
        if(s.charAt(x)!=s.charAt(y)){
            dp[x][y]=0;
            return 0;
        }
        int ret=1;
        if(x+1<=y-1) ret=go(x+1,y-1);
        dp[x][y]=ret;
        return ret;
    }
    public static int go2(int here){
        if(here>=n) return 0;
        if(dp2[here]!=99999999) return dp2[here];
        int ret=dp2[here];
        for(int i=here;i<n;i++){
            if(dp[here][i]==1) ret=Math.min(ret,go2(i+1)+1);
        }
        dp2[here]=ret;
        return ret;
    }
}
