import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Shark implements Comparable<Shark> {
        int x;
        int y;
        int distance;

        public Shark(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }


        @Override
        public int compareTo(Shark o) {
            if (distance != o.distance) {
                return distance - o.distance;
            }
            if (y != o.y) {
                return y - o.y;
            }
            return x - o.x;
        }
    }

    private static int n;
    private static int[][] arr;
    private static Shark shark;
    private static int sharkShape = 2;
    private static int result = 0;
    private static int eaten = 0;
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {-1, 0, 1, 0};
    private static Queue<Shark> eats = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    arr[i][j] = 0;
                    shark = new Shark(j, i, 0);
                }
            }
        }

        bfs(shark.x, shark.y);
        while (!eats.isEmpty()) {
            eaten++;
            Shark eatFish = eats.poll();
            result = result + eatFish.distance;
            if (eaten == sharkShape) {
                eaten = 0;
                sharkShape++;
            }
            arr[eatFish.y][eatFish.x] = 0;
            eats.clear();
            bfs(eatFish.x,eatFish.y);
        }
        System.out.println(result);
    }

    public static void bfs(int x, int y) {
        int[][] visited = new int[n + 1][n + 1];
        Queue<Shark> sharks = new PriorityQueue<>();
        sharks.add(new Shark(x, y, 0));
        visited[y][x] = 1;
        while (!sharks.isEmpty()) {
            Shark now = sharks.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx] != 0 || arr[ny][nx] > sharkShape) {
                    continue;
                }
                sharks.add(new Shark(nx, ny, now.distance + 1));
                visited[ny][nx] = 1;
                if (arr[ny][nx] != 0 && arr[ny][nx] < sharkShape) {
                    eats.add(new Shark(nx, ny, now.distance + 1));
                }
            }
        }
    }
}
