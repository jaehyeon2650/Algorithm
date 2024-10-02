import java.io.*;
import java.util.Arrays;

public class Main {
    public static int n;
    public static int t;
    public static int[][] a;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb=new StringBuffer();
        t=Integer.parseInt(bf.readLine());
        for(int i=0;i<t;i++){
            n=Integer.parseInt(bf.readLine());
            a=new int[2][n+1];
            for(int j=0;j<2;j++){
                String s=bf.readLine();
                String[] s1 = s.split(" ");
                for(int k=0;k<n;k++){
                    a[j][k]=Integer.parseInt(s1[k]);
                }
            }
            dp=new int[n+1][3];
            for(int j=0;j<=n;j++){
                Arrays.fill(dp[j],-1);
            }
            sb.append(dfs(0,0)+"\n");
        }
        System.out.println(sb);
    }
    // how는 이전꺼, col은 현재
    public static int dfs(int col,int how){
        if(col==n+1) return 0;
        if(dp[col][how]!=-1) return dp[col][how];
        int ret=0;
        if(how==1){
            ret=Math.max(dfs(col+1,0),dfs(col+1,2)+a[1][col]);
        }else if(how==2){
            ret=Math.max(dfs(col+1,0),dfs(col+1,1)+a[0][col]);
        }else{
            ret=Math.max(dfs(col+1,0),dfs(col+1,1)+a[0][col]);
            ret=Math.max(ret,dfs(col+1,2)+a[1][col]);
        }
        dp[col][how]=ret;
        return ret;
    }

}
