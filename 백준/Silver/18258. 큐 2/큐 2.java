import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int rearEle = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                rearEle = Integer.parseInt(st.nextToken());
                queue.add(rearEle);
            } else  {
                if (command.equals("pop")) {
                    sb.append((queue.isEmpty()) ? -1 : queue.remove());
                }
                if (command.equals("size")) {
                    sb.append(queue.size());
                }
                if (command.equals("empty")) {
                    sb.append((queue.isEmpty()) ? 1 : 0);
                }
                if (command.equals("front")) {
                    sb.append((queue.isEmpty()) ? -1 : queue.element());
                }
                if (command.equals("back")) {
                    sb.append((queue.isEmpty()) ? -1 : rearEle);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}