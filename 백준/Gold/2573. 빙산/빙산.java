
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static int count = 0;
    private static int component = 0;
    private static int[][] visited;
    private static int[][] graph;
    private static int[][] before;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new int[n + 1][m + 1];
        graph = new int[n + 1][m + 1];
        before = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                before[i][j] = graph[i][j];
            }
        }
        while(component<2){
            component=0;
            count++;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(before[i][j]!=0 && visited[i][j]==0){
                        component++;
                        dfs(j,i);
                    }
                }
            }
            if(component==0) break;
            copy();
            clearVisited();
        }
        if(component>=2){
            System.out.println(count-1);
        }else{
            System.out.println(0);
        }
    }

    private static void clearVisited() {
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], 0);
        }
    }

    private static void dfs(int x, int y) {
        visited[y][x] = 1;
        int nearCount = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                continue;
            }
            if (before[ny][nx] == 0) {
                nearCount++;
            }
        }
        graph[y][x] -= nearCount;
        if (graph[y][x] < 0) {
            graph[y][x] = 0;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx] != 0) {
                continue;
            }
            if (before[ny][nx] != 0) {
                dfs(nx, ny);
            }
        }
    }

    private static void copy() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                before[i][j] = graph[i][j];
            }
        }
    }
}
