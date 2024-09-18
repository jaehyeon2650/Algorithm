import java.io.*;
import java.util.Arrays;

public class Main {
    public static int n;
    public static int[] a;
    public static int[][] dp=new int[2001][2001];
    public static int m;
    public static void main(String[] args) throws IOException {
        for(int i=0;i<2001;i++){
            Arrays.fill(dp[i],-1);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb=new StringBuffer();
        n=Integer.parseInt(br.readLine());
        a=new int[n+1];
        String s=br.readLine();
        String[] s1 = s.split(" ");
        for(int i=0;i<n;i++){
            a[i+1]=Integer.parseInt(s1[i]);
        }
        for(int i=1;i<=n;i++){
            dp[i][i]=1;
        }
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                if(dp[i][j]==-1) go(i,j);
            }
        }
        m=Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            s=br.readLine();
            s1 = s.split(" ");
            sb.append(dp[Integer.parseInt(s1[0])][Integer.parseInt(s1[1])]+"\n");
        }
        System.out.println(sb);
    }

    public static int go(int x,int y){
        if(dp[x][y]!=-1) return dp[x][y];
        int ret=1;
        if(a[x]!=a[y]) ret=0;
        else{
            if(x+1<=y-1) ret=go(x+1,y-1);
        }
        dp[x][y]=ret;
        return ret;
    }

}
