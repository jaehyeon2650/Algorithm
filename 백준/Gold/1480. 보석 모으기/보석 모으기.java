import java.io.*;

public class Main {
    public static int n;
    public static int m;
    public static int k;
    public static int[] a;
    public static int[][][] dp=new int[11][21][1<<13];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        String[] s1 = s.split(" ");
        n=Integer.parseInt(s1[0]);
        m=Integer.parseInt(s1[1]);
        k=Integer.parseInt(s1[2]);
        s=br.readLine();
        s1=s.split(" ");
        a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(s1[i]);
        }
        System.out.println(go(0,k,0));
    }
    public static int go(int here,int cap,int what){
        if(here==m) return 0;
        if(dp[here][cap][what]!=0) return 0;
        int ret=0;
        ret=Math.max(ret,go(here+1,k,what));
        for(int i=0;i<n;i++){
            boolean isHere=(what&(1<<i))>0;
            boolean can=(a[i]<=cap);
            if(!isHere&&can) ret=Math.max(ret,go(here,cap-a[i],(what|(1<<i)))+1);
        }
        dp[here][cap][what]=ret;
        return ret;
    }
}
