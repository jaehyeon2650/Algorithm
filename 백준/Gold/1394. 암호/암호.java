import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static String secret;
    private static String pattern;
    private static int n;
    private static Map<Character, Integer> words = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        secret = bf.readLine();
        pattern = bf.readLine();
        n = secret.length();
        for (int i = 0; i < n; i++) {
            if (!words.containsKey(secret.charAt(i))) {
                words.put(secret.charAt(i), i + 1);
            }
        }
        int answer = 0;
        for (int i = 0; i < pattern.length(); i++) {
            answer *= n;
            answer += words.get(pattern.charAt(i));
            answer %= 900528;
        }
        System.out.println(answer);
    }
}
