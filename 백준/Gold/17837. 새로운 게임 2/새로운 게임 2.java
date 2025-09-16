import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static List<Integer>[][] graph;
    private static int[][] map;
    private static Map<Integer, Horse> horses = new HashMap<>();
    private static int result = 0;
    private static boolean isFinished = false;
    private static int[] opposite = {1, 0, 3, 2};
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    static class Horse {
        int y;
        int x;
        int direction;

        public Horse(final int y, final int x, final int direction) {
            this.y = y;
            this.x = x;
            this.direction = direction;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n][n];
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                graph[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            horses.put(i + 1, new Horse(y, x, Integer.parseInt(st.nextToken()) - 1));
            graph[y][x].add(i + 1);
        }

        while (result <= 1000 && !isFinished) {
            result++;
            for (int i = 1; i <= m; i++) {
                Horse curHorse = horses.get(i);
                int ny = curHorse.y + dy[curHorse.direction];
                int nx = curHorse.x + dx[curHorse.direction];
                if (ny < 0 || nx < 0 || ny >= n || nx >= n || map[ny][nx] == 2) {
                    curHorse.direction = opposite[curHorse.direction];
                    ny = curHorse.y + dy[curHorse.direction];
                    nx = curHorse.x + dx[curHorse.direction];
                }
                if(ny < 0 || nx < 0 || ny >= n || nx >= n || map[ny][nx] == 2) continue;

                int index = -1;
                for(int j = 0;j<graph[curHorse.y][curHorse.x].size();j++){
                    if(graph[curHorse.y][curHorse.x].get(j)==i){
                        index=j;
                        break;
                    }
                }
                List<Integer> haveToMove = new ArrayList<>();
                if(index!=-1){
                    for(int j=index;j<graph[curHorse.y][curHorse.x].size();j++){
                        haveToMove.add(graph[curHorse.y][curHorse.x].get(j));
                    }
                    graph[curHorse.y][curHorse.x].subList(index,graph[curHorse.y][curHorse.x].size()).clear();
                }

                if(map[ny][nx]==1){
                    Collections.reverse(haveToMove);
                }

                for (Integer integer : haveToMove) {
                    Horse horse = horses.get(integer);
                    horse.y = ny;
                    horse.x = nx;
                }
                graph[ny][nx].addAll(haveToMove);
                if(graph[ny][nx].size()>=4){
                    isFinished = true;
                    break;
                }
            }
        }

        if(result>1000){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }
}
