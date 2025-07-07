import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static boolean[][] visited;
    private static int[][] arr;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    private static int direction;
    private static int nowX;
    private static int nowY;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];
        st = new StringTokenizer(bf.readLine());
        nowY = Integer.parseInt(st.nextToken());
        nowX = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if (arr[nowY][nowX] == 0 && !visited[nowY][nowX]) {
                visited[nowY][nowX] = true;
                count++;
            }
            if (aroundDirty(nowX, nowY)) {
                direction = (direction - 1 + 4) % 4;
                int ny = nowY + dy[direction];
                int nx = nowX + dx[direction];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && arr[ny][nx] == 0 && !visited[ny][nx]) {
                    nowX = nx;
                    nowY = ny;
                }
            } else if (canGoBack(nowX, nowY, direction)) {
                int opposite = (direction + 2) % 4;
                nowX = nowX + dx[opposite];
                nowY = nowY + dy[opposite];
            } else {
                break;
            }
        }
        System.out.println(count);
    }

    private static boolean aroundDirty(int x, int y) {
        boolean dirty = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                continue;
            }
            if (arr[ny][nx] == 0 && !visited[ny][nx]) {
                dirty = true;
                break;
            }
        }
        return dirty;
    }

    private static boolean canGoBack(int x, int y, int direction) {
        int opposite = (direction + 2) % 4;
        int nx = x + dx[opposite];
        int ny = y + dy[opposite];
        return nx >= 0 && ny >= 0 && nx < m && ny < n && arr[ny][nx] != 1;
    }
}
