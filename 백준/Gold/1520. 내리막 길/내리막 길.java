import java.io.*;
import java.util.Arrays;

public class Main {
    public static int n;
    public static int m;
    public static int[][] dp;
    public static int[][] a;
    public static int[] dx={-1,0,1,0};
    public static int[] dy={0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String s=bf.readLine();
        String[] s1 = s.split(" ");
        n=Integer.parseInt(s1[0]);
        m=Integer.parseInt(s1[1]);
        a=new int[n][m];
        dp=new int[n][m];
        for(int i=0;i<n;i++){
            s=bf.readLine();
            s1=s.split(" ");
            for(int j=0;j<m;j++){
                a[i][j]=Integer.parseInt(s1[j]);
            }
        }
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(dfs(0,0));

    }
    public static int dfs(int y,int x){
        if(y==n-1&&x==m-1) return 1;
        if(dp[y][x]!=-1) return dp[y][x];
        dp[y][x]=0;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx<0||ny<0||nx>=m||ny>=n) continue;
            if(a[ny][nx]<a[y][x]){
                dp[y][x]+=dfs(ny,nx);
            }
        }
        return dp[y][x];
    }
}
