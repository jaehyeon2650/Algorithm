import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;


public class Main {
    public static int n;
    public static int k;
    public static int[] bikeTime;
    public static int[] bikeMoney;
    public static int[] walkTime;
    public static int[] walkMoney;
    public static int[][] dp=new int[102][100004];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        for(int i=0;i<102;i++){
            Arrays.fill(dp[i],-1);
        }
        String[] s1 = s.split(" ");
        n=Integer.parseInt(s1[0]);
        k=Integer.parseInt(s1[1]);
        bikeTime=new int[n];
        bikeMoney=new int[n];
        walkTime=new int[n];
        walkMoney=new int[n];
        for(int i=0;i<n;i++){
            s=br.readLine();
            s1=s.split(" ");
            walkTime[i]=Integer.parseInt(s1[0]);
            walkMoney[i]=Integer.parseInt(s1[1]);
            bikeTime[i]=Integer.parseInt(s1[2]);
            bikeMoney[i]=Integer.parseInt(s1[3]);
        }
        System.out.println(go(0,k));
    }

    public static int go(int here,int time){
        if(here==n) return 0;
        if(dp[here][time]!=-1) return dp[here][time];
        int ret=-123456789;
        if(time-bikeTime[here]>=0) ret=Math.max(go(here+1,time-bikeTime[here])+bikeMoney[here],ret);
        if(time-walkTime[here]>=0) ret=Math.max(go(here+1,time-walkTime[here])+walkMoney[here],ret);
        dp[here][time]=ret;
        return ret;
    }
}
