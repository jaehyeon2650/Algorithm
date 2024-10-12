import java.io.*;
import java.util.Arrays;

public class Main {
    public static int t;
    public static int n;
    public static int[] a;
    public static int[][] dp;
    public static int money;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb=new StringBuffer();
        t=Integer.parseInt(bf.readLine());
        for(int i=0;i<t;i++){
            n=Integer.parseInt(bf.readLine());
            a=new int[n];
            String s=bf.readLine();
            String[] s1 = s.split(" ");
            for(int j=0;j<n;j++){
                a[j]=Integer.parseInt(s1[j]);
            }
            money=Integer.parseInt(bf.readLine());
            dp=new int[n+1][money+1];
            for(int j=0;j<=n;j++){
                Arrays.fill(dp[j],-1);
            }

            sb.append(start(0,0)+"\n");
        }
        System.out.println(sb);
    }
    public static int start(int before,int now){
        if(now==money) return 1;
        if(now>money) return 0;
        if(dp[before][now]!=-1) return dp[before][now];
        int ret=0;
        for(int i=0;i<n;i++){
            if(before>i) continue;
            ret+=start(i,now+a[i]);
        }
        dp[before][now]=ret;
        return ret;
    }


}
