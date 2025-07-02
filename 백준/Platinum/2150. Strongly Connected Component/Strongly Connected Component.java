
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class Main {

    static class Pair implements Comparable<Pair> {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            return x - o.x;
        }
    }

    private static int n;
    private static int m;
    private static Vector<Vector<Integer>> arr = new Vector<>();
    private static Vector<Vector<Integer>> arr2 = new Vector<>();
    private static int[] visited;
    private static Stack<Integer> stack = new Stack<>();
    private static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String token = bf.readLine();
        String[] split = token.split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        initialize();
        fill(bf);

        for(int i=1;i<=n;i++){
            dfs1(i);
        }

        clearVisited();
        reverse();
        clearArr();
        goStack();
        System.out.println(total);
        for (int i = 1; i < visited.length; i++) {
            arr.get(visited[i]).add(i);
        }
        List<Pair> result = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (!arr.get(i).isEmpty()) {
                result.add(new Pair(arr.get(i).get(0), i));
            }
        }
        Collections.sort(result);
        for (Pair pair : result) {
            for (int i = 0; i < arr.get(pair.y).size(); i++) {
                System.out.print(arr.get(pair.y).get(i) + " ");
            }
            System.out.println("-1");
        }
    }

    private static void fill(BufferedReader bf) throws IOException {
        for (int i = 0; i < m; i++) {
            String token1 = bf.readLine();
            String[] split1 = token1.split(" ");
            int v1 = Integer.parseInt(split1[0]);
            int v2 = Integer.parseInt(split1[1]);
            arr.get(v1).add(v2);
        }
    }

    private static void dfs1(int x) {
        if (visited[x] != 1) {
            stack.add(x);
            visited[x] = 1;
            for (int i = 0; i < arr.get(x).size(); i++) {
                if (visited[arr.get(x).get(i)] == 0) {
                    dfs1(arr.get(x).get(i));
                }
            }
            stack.add(x);
        }
    }

    private static void dfs2(int x, int start) {
        if (visited[x] == 0) {
            visited[x] = start;
            for (int i = 0; i < arr2.get(x).size(); i++) {
                if (visited[arr2.get(x).get(i)] == 0) {
                    dfs2(arr2.get(x).get(i), start);
                }
            }
        }
    }

    private static void goStack() {
        while (!stack.empty()) {
            int top = stack.pop();
            if (visited[top] == 0) {
                total++;
                dfs2(top, top);
            }
        }
    }

    private static void reverse() {
        for (int i = 1; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                arr2.get(arr.get(i).get(j)).add(i);
            }
        }
    }

    private static void initialize() {
        clearVisited();
        for (int i = 0; i <= n; i++) {
            arr.add(new Vector<>());
            arr2.add(new Vector<>());
        }
    }

    private static void clearVisited() {
        visited = new int[n + 1];
    }

    private static void clearArr() {
        for (int i = 0; i < arr.size(); i++) {
            arr.get(i).clear();
        }
    }
}
