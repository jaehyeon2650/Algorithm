import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int n;
    private static int m;
    private static int t;
    private static char[][] graph;
    private static Queue<Point> startPoints;
    private static Queue<Character> keys;
    private static Queue<Character> findKeys;
    private static boolean[][][] visited;
    private static int count = 0;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            init();
            for (int j = 0; j < n; j++) {
                String s = br.readLine();
                for (int k = 0; k < m; k++) {
                    graph[j][k] = s.charAt(k);
                    if ((j == 0 || j == n - 1 || k == 0 || k == m - 1) && graph[j][k] != '*') {
                        startPoints.add(new Point(k, j));
                    }
                }
            }
            String key = br.readLine();
            if (!key.equals("0")) {
                for (int j = 0; j < key.length(); j++) {
                    keys.add(key.charAt(j));
                    findKeys.add(key.charAt(j));
                }
            }
            while (true) {
                boolean isChange = false;
                int beforeSize = findKeys.size();
                for (Point startPoint : startPoints) {
                    if (!visited[startPoint.y][startPoint.x][findKeys.size()]) {
                        bfs(startPoint.x, startPoint.y);
                    }
                    if (beforeSize != findKeys.size()) {
                        isChange = true;
                        break;
                    }
                }
                if (!isChange) {
                    break;
                }
            }
            sb.append(count + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void bfs(int x, int y) {
        if ((isDoor(graph[y][x]) && !findKeys.contains(Character.toLowerCase(graph[y][x])))) {
            return;
        }
        if(graph[y][x]=='$'){
            graph[y][x]='.';
            count++;
        }
        if(isKey(graph[y][x])&&!findKeys.contains(graph[y][x])){
            findKeys.add(graph[y][x]);
        }
        visited[y][x][findKeys.size()] = true;
        Queue<Point> points = new ArrayDeque<>();
        points.add(new Point(x, y));
        while (!points.isEmpty()) {
            Point now = points.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx][findKeys.size()]) {
                    continue;
                }
                char next = graph[ny][nx];
                if (isKey(next) && !findKeys.contains(next)) {
                    findKeys.add(next);
                }
                if ((isDoor(next) && !findKeys.contains(Character.toLowerCase(next))) || next == '*') {
                    continue;
                }
                if (next == '$') {
                    graph[ny][nx] = '.';
                    count++;
                }
                visited[ny][nx][findKeys.size()] = true;
                points.add(new Point(nx, ny));
            }
        }
    }

    private static boolean isKey(char c) {
        return c >= 'a' && c <= 'z';
    }

    private static boolean isDoor(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private static void init() {
        count = 0;
        visited = new boolean[n + 1][m + 1][10000];
        graph = new char[n + 1][m + 1];
        startPoints = new ArrayDeque<>();
        keys = new ArrayDeque<>();
        findKeys = new ArrayDeque<>();
    }
}
