import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int[] sets;
    public static int[][] graph;
    public static int n;
    public static int m;
    public static List<Integer> city = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        sets = new int[n + 1];
        graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            sets[i] = i;
        }
        m = Integer.parseInt(bf.readLine());
        for (int i = 1; i <= n; i++) {
            String s = bf.readLine();
            String[] split = s.split(" ");
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(split[j - 1]);
            }
        }
        String s = bf.readLine();
        String[] split = s.split(" ");
        for (int i = 1; i <= m; i++) {
            city.add(Integer.parseInt(split[i - 1]));
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        boolean check = true;
        int group = find(city.get(0));
        for (int i = 1; i < city.size(); i++) {
            if (group != find(city.get(i))) {
                check = false;
                break;
            }
        }

        if (check) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    public static int find(int x) {
        if (sets[x] == x) {
            return sets[x];
        }
        return sets[x]=find(sets[x]);
    }

    public static void union(int x, int y) {
        int x1 = find(x);
        int y1 = find(y);
        if (x1 != y1) {
            sets[x1] = y1;
        }
    }

}
