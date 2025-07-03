import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static int[] visited;
    private static int[] result;
    private static int n;
    private static int t;
    private static int count;
    private static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(bf.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(bf.readLine());
            visited = new int[n + 1];
            result = new int[n + 1];
            graph = new int[n + 1];
            count=0;
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= n; j++) {
                graph[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 1; j <= n; j++) {
                if (result[j] == 0) {
                    dfs(j);
                }
            }
            sb.append(n-count + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        bf.close();
    }

    private static void dfs(int x) {
        if (visited[x] == 0) {
            visited[x] = 1;
        } else {
            count++;
            result[x] = 1;
        }

        if (result[graph[x]] == 0) {
            dfs(graph[x]);
        }

        visited[x] = 0;
        result[x] = 1;
    }
}