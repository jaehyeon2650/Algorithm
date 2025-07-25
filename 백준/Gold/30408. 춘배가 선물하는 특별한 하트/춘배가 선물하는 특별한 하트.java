import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static String input1;
    private static String input2;
    private static boolean isFind = false;
    private static Set<String> falses = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        input1 = st.nextToken();
        input2 = st.nextToken();
        if (check(input1, input2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean check(String number, String want) {
        if(isFind) return true;
        if(falses.contains(number)) return false;
        BigInteger n = new BigInteger(number);
        BigInteger n2 = new BigInteger(want);
        if (n.compareTo(n2) < 0) {
            falses.add(number);
            return false;
        }
        if (n.equals(n2)) {
            isFind = true;
            return true;
        }

        String last = number.substring(number.length() - 1);
        int nums = Integer.parseInt(last);
        if (nums % 2 == 0) {
            boolean result = check(n.divide(new BigInteger("2")).toString(), want);
            if(!result){
                falses.add(number);
            }
            return result;
        } else {
            BigInteger result = n.add(new BigInteger("-1"));
            boolean resultBoolean = check(result.divide(new BigInteger("2")).toString(), want) || check(
                    result.divide(new BigInteger("2")).add(new BigInteger("1")).toString(), want);
            if(!resultBoolean){
                falses.add(number);
            }
            return resultBoolean;
        }
    }
}
