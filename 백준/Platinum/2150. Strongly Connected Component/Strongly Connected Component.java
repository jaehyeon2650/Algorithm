import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static int n;
    public static int m;
    public static List<List<Integer>> graph = new ArrayList<>();
    public static List<List<Integer>> reverseGraph = new ArrayList<>();
    public static List<List<Integer>> result = new ArrayList<>();
    public static Map<Integer,Integer> tree = new TreeMap<>();
    public static Stack<Integer> stack = new Stack<>();
    public static int[] visited;
    public static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        init();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            reverseGraph.get(v2).add(v1);
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                dfs1(i);
            }
        }

        visited = new int[n + 1];

        while (!stack.isEmpty()) {
            int top = stack.pop();
            if(visited[top]==0){
                total++;
                dfs2(top,top);
                Collections.sort(result.get(top));
                tree.put(result.get(top).get(0),top);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(total+"\n");

        for (Integer value : tree.values()) {
            for (Integer re : result.get(value)) {
                sb.append(re+" ");
            }
            sb.append("-1\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void init() {
        visited = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
            result.add(new ArrayList<>());
        }
    }

    private static void dfs1(int x) {
        if (visited[x] == 0) {
            visited[x] = 1;
            for (int i = 0; i < graph.get(x).size(); i++) {
                if (visited[graph.get(x).get(i)] == 0) {
                    dfs1(graph.get(x).get(i));
                }
            }
            stack.add(x);
        }
    }

    private static void dfs2(int x, int group) {
        if (visited[x] == 0) {
            visited[x] = 1;
            result.get(group).add(x);
            for (int i = 0; i < reverseGraph.get(x).size(); i++) {
                if(visited[reverseGraph.get(x).get(i)]==0){
                    dfs2(reverseGraph.get(x).get(i),group);
                }
            }
        }
    }
}
