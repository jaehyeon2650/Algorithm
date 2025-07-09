import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int x;
        int weight;

        public Edge(int x, int weight) {
            this.x = x;
            this.weight = weight;
        }
    }

    private static List<List<Edge>> graph = new ArrayList<>();
    private static int n;
    private static int maxn = 0;
    private static int start = 0;
    private static int[] visited;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        initGraph();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int next;
            while ((next = Integer.parseInt(st.nextToken())) != -1) {
                int cost = Integer.parseInt(st.nextToken());
                graph.get(start).add(new Edge(next, cost));
            }
        }

        clearVisited();
        dfs(1, 0);
        clearVisited();
        dfs(start, 0);
        System.out.println(result);
    }

    private static void initGraph() {
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
    }

    private static void clearVisited() {
        visited = new int[n + 1];
    }

    private static void dfs(int x, int total) {
        visited[x] = 1;
        for (Edge edge : graph.get(x)) {
            if (visited[edge.x] == 0) {
                dfs(edge.x, total + edge.weight);
            }
        }
        if (result < total) {
            result = total;
            start = x;
        }
    }
}
