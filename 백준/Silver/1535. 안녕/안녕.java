import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[] lossHealth;
    private static int[] getHappy;
    private static int[] dp = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(bf.readLine());

        lossHealth = new int[n];
        getHappy = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++){
            lossHealth[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++){
            getHappy[i]=Integer.parseInt(st.nextToken());
        }

        for(int i = 0;i<n;i++){
            for(int j=99;j>=lossHealth[i];j--){
                dp[j]=Math.max(dp[j],dp[j-lossHealth[i]]+getHappy[i]);
            }
        }
        System.out.println(dp[99]);
    }
}
