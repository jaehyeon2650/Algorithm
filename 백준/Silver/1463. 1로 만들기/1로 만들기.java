import java.io.*;
import java.util.Arrays;

public class Main {
    public static int n;
    public static int[] dp=new int[1000004];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        Arrays.fill(dp,123456789);
        System.out.println(go(n));
    }
    public static int go(int n){
        if(n==1) return 0;
        if(dp[n]!=123456789) return dp[n];
        int ret=123456789;
        if(n%3==0) ret=Math.min(ret,go(n/3)+1);
        if(n%2==0) ret=Math.min(ret,go(n/2)+1);
        ret=Math.min(ret,go(n-1)+1);
        dp[n]=ret;
        return ret;
    }
}
