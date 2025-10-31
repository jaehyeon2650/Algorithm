import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    private static int n;
    private static int[][] graph;
    private static int[][] visited;
    private static int sharkY;
    private static int sharkX;
    private static int eaten = 0;
    private static int size = 2;
    private static int[] dx = {0,-1,0,1};
    private static int[] dy = {-1,0,1,0};
    private static int count = 0;
    private static Queue<Shark> eats = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        graph = new int[n][n];
        visited = new int[n][n];
        clear();
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j]==9){
                    sharkY = i;
                    sharkX = j;
                    graph[i][j] = 0;
                }
            }
        }

        bfs();
        while(!eats.isEmpty()){
            Shark shark = eats.poll();
            Point next = shark.point;
            eaten++;
            if(eaten==size){
                size++;
                eaten = 0;
            }
            count += visited[next.y][next.x];
            graph[next.y][next.x] = 0;
            sharkY = next.y;
            sharkX = next.x;
            clear();
            eats.clear();
            bfs();
        }
        System.out.println(count);
    }

    private static void bfs(){
        Queue<Point> queue = new ArrayDeque<>();
        visited[sharkY][sharkX]=0;
        queue.add(new Point(sharkY, sharkX));
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            int y = cur.y;
            int x = cur.x;
            if(graph[y][x]>0 && size>graph[y][x]) {
                eats.add( new Shark(cur,visited[y][x]));
            }
            for(int i=0;i<4;i++){
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(ny<0||nx<0||ny>=n||nx>=n||visited[ny][nx]!=-1||graph[ny][nx]> size) continue;
                visited[ny][nx] = visited[y][x]+1;
                queue.add(new Point(ny, nx));
            }
        }
    }

    private static void clear(){
        for(int i=0;i<n;i++){
            Arrays.fill(visited[i],-1);
        }
    }

    static class Point{
        int y;
        int x;

        public Point(final int y, final int x) {
            this.y = y;
            this.x = x;
        }
    }

    static class Shark implements Comparable<Shark>{
        Point point;
        int distance;

        public Shark(final Point point, final int distance) {
            this.point = point;
            this.distance = distance;
        }

        @Override
        public int compareTo(final Shark o) {
            if(distance != o.distance){
                return distance - o.distance;
            }
            return point.y - o.point.y;
        }
    }
}
