import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int m;
    private static int[][] arr;
    private static int[][][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x;
        int y;
        int broken;

        public Point(int x, int y, int broken) {
            this.x = x;
            this.y = y;
            this.broken = broken;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];
        visited = new int[n + 1][m + 1][2];
        for (int i = 0; i < n; i++) {
            String input = bf.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }
        bfs(0, 0);
    }

    private static void bfs(int x, int y) {
        visited[y][x][0] = 1;
        if (x == m - 1 && y == n - 1) {
            System.out.println(1);
            return;
        }
        Queue<Point> points = new ArrayDeque<>();
        points.add(new Point(x, y, 0));
        boolean find = false;
        while (!points.isEmpty()) {
            if (find) {
                break;
            }
            Point now = points.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                int broken = now.broken;
                if (ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx][broken] != 0) {
                    continue;
                }
                if (arr[ny][nx] == 1 && broken == 1) {
                    continue;
                }
                if (arr[ny][nx] == 1 && broken == 0) {
                    broken++;
                }
                points.add(new Point(nx, ny, broken));
                visited[ny][nx][broken] = visited[now.y][now.x][now.broken] + 1;
                if (ny == n - 1 && nx == m - 1) {
                    find = true;
                }
            }
        }

        if (find && visited[n - 1][m - 1][0] != 0) {
            System.out.println(visited[n - 1][m - 1][0]);
        } else if (find && visited[n - 1][m - 1][1] != 0) {
            System.out.println(visited[n - 1][m - 1][1]);
        } else {
            System.out.println(-1);
        }
    }
}
