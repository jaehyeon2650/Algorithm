import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static Map<String, Queue<Integer>> infos = new HashMap<>();
    private static int n;
    private static long total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int option = Integer.parseInt(st.nextToken());
            if (option == 1) {
                String name = st.nextToken();
                Queue<Integer> queue = infos.getOrDefault(name, new PriorityQueue<>(Collections.reverseOrder()));
                int count = Integer.parseInt(st.nextToken());
                for (int j = 0; j < count; j++) {
                    queue.add(Integer.parseInt(st.nextToken()));
                }
                if (!infos.containsKey(name)) {
                    infos.put(name, queue);
                }
            } else {
                String name = st.nextToken();
                if (infos.containsKey(name)) {
                    Queue<Integer> queue = infos.get(name);
                    int number = Integer.parseInt(st.nextToken());
                    while (!queue.isEmpty() && number > 0) {
                        total += queue.poll();
                        number--;
                    }
                }
            }
        }
        System.out.println(total);
    }
}
