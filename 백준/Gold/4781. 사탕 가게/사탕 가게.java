import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Candy {
        int cal;
        int price;

        public Candy(final int cal, final double price) {
            this.cal = cal;
            this.price = (int) (price*100+0.5);
        }
    }

    private static int n = -1;
    private static int money = -1;
    private static List<Candy> candies = new ArrayList<>();
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb =new StringBuffer();
        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            candies.clear();
            n = Integer.parseInt(st.nextToken());
            money = (int)(Double.parseDouble(st.nextToken())*100+0.5);
            if(n==0 && money==0) break;
            dp = new int[(int)(money*100)];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(bf.readLine());
                int cal = Integer.parseInt(st.nextToken());
                double money = Double.parseDouble(st.nextToken());
                candies.add(new Candy(cal, money));
            }
            int maxn = 0;
            for(int i=0;i<candies.size();i++){
                for(int j = candies.get(i).price;j<=money;j++){
                    dp[j] = Math.max(dp[j],dp[j-candies.get(i).price]+candies.get(i).cal);
                    maxn = Math.max(maxn,dp[j]);
                }
            }
            sb.append(maxn+"\n");
        }
        System.out.println(sb);
    }

}
