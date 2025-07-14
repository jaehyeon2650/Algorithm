import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    private static int n;
    private static Queue<Integer> cards = new PriorityQueue<>();
    private static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            cards.add(Integer.parseInt(bf.readLine()));
        }

        while (cards.size() != 1) {
            Integer first = cards.poll();
            Integer second = cards.poll();
            total += (first + second);
            cards.add(first + second);
        }

        System.out.println(total);
    }

}
