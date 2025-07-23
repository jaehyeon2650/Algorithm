import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<String> words = new ArrayList<>();
    private static int n;
    private static int maxn = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        String resultA = "";
        String resultB = "";
        for (int i = 0; i < n; i++) {
            words.add(bf.readLine());
        }

        for (int i = 0; i < n; i++) {
            String word1 = words.get(i);
            for (int j = i + 1; j < n; j++) {
                String word2 = words.get(j);
                if (word2.length() < maxn) {
                    continue;
                }
                int count = 0;
                for (int k = 0; k < Math.min(word1.length(), word2.length()); k++) {
                    if (word1.charAt(k) == word2.charAt(k)) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (maxn < count) {
                    maxn = count;
                    resultA = word1;
                    resultB = word2;
                }
            }
        }
        System.out.println(resultA);
        System.out.println(resultB);

    }

}
