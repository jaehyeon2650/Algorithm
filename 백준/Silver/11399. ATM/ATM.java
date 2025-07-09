import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    private static int n;
    private static List<Integer> nums = new ArrayList<>();
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(nums);
        int total = 0;
        for (int i = 0; i < n; i++) {
            result += (total + nums.get(i));
            total += nums.get(i);
        }
        System.out.println(result);
    }

}
