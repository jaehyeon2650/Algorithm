import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] dp;
    private static int t;
    private static int maxn;
    private static int[] want;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(bf.readLine());
        want = new int[t];
        for(int i=0;i<t;i++){
            int num = Integer.parseInt(bf.readLine());
            want[i]=num;
            maxn = Math.max(maxn,num);
        }
        dp = new int[maxn+1];

        dp[0]=1;
        for(int i=1;i<=3;i++){
            for(int j=1;j<=maxn;j++){
                if(j-i>=0){
                    dp[j]+=dp[j-i];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<t;i++){
            sb.append(dp[want[i]]+"\n");
        }
        System.out.println(sb);

    }


}
