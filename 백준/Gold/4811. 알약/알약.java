import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {

    private static BigInteger[][] dp = new BigInteger[31][31];
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while ((n = Integer.parseInt(bf.readLine())) != 0) {
            initialize();
            System.out.println(go(n,0));
        }

    }

    private static void initialize() {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], BigInteger.valueOf(-1));
        }
    }

    private static BigInteger go(int one, int half){
        if(one<0||half<0) return BigInteger.ZERO;
        if(one==0&&half==0) return BigInteger.ONE;
        if(!dp[one][half].equals(BigInteger.valueOf(-1))) return dp[one][half];

        BigInteger total = BigInteger.ZERO;
        total = total.add(go(one-1,half+1));
        if(half!=0){
            total = total.add(go(one,half-1));
        }

        dp[one][half]=total;

        return total;
    }
}


