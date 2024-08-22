import java.io.*;
import java.util.*;

class Main {

    public static int n;
    public static int[] a;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(bf.readLine());
        a=new int[n];
        dp=new int[n];
        String s=bf.readLine();
        String[] strings = s.split(" ");
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(strings[i]);
        }
        for(int i=0;i<n;i++){
            dp[i]=1;
            int minn=dp[0];
            for(int j=0;j<i;j++){
                if(a[i]>a[j]&&minn<=dp[j]){
                    dp[i]=dp[j]+1;
                    minn=dp[j];
                }
            }
        }
        int minn=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            minn=Math.max(minn,dp[i]);
        }
        System.out.println(minn);
    }
}