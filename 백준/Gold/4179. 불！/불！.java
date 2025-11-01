import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static class Point{
        int y;
        int x;

        public Point(final int y, final int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static int n;
    private static int m;
    private static String[][] graph;
    private static int jx;
    private static int jy;
    private static int fy;
    private static int fx;
    private static int[] dy = {-1,0,1,0};
    private static int[] dx = {0,1,0,-1};
    private static int[][] visited;
    private static int[][] fireVisited;
    private static Queue<Point> fires = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new String[n][m];
        visited = new int[n][m];
        fireVisited = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(visited[i],-1);
            Arrays.fill(fireVisited[i],-1);
        }
        for(int i=0;i<n;i++){
            String s = bf.readLine();
            for(int j=0;j<m;j++){
                graph[i][j] = String.valueOf(s.charAt(j));
                if(graph[i][j].equals("J")){
                    jy = i;
                    jx = j;
                }else if(graph[i][j].equals("F")){
                    fires.add(new Point(i,j));
                    fireVisited[i][j]=0;
                }
            }
        }
        fireBfs();
        bfs();
        int result = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            if(!graph[0][i].equals("#") && visited[0][i]>=0){
                result = Math.min(visited[0][i],result);
            }
            if(!graph[n-1][i].equals("#")&& visited[n-1][i]>=0){
                result = Math.min(visited[n-1][i],result);
            }
        }

        for(int i=0;i<n;i++){
            if(!graph[i][0].equals("#") && visited[i][0]>=0){
                result = Math.min(visited[i][0],result);
            }
            if(!graph[i][m-1].equals("#")&& visited[i][m-1]>=0){
                result = Math.min(visited[i][m-1],result);
            }
        }

        if(result==Integer.MAX_VALUE){
            System.out.println("IMPOSSIBLE");
        }else{
            System.out.println(result+1);
        }
    }

    private static void fireBfs(){
        while(!fires.isEmpty()){
            Point cur = fires.poll();
            for(int i=0;i<4;i++){
                int ny = cur.y+dy[i];
                int nx = cur.x+dx[i];
                if(ny<0||nx<0||ny>=n||nx>=m||fireVisited[ny][nx]!=-1||graph[ny][nx].equals("#")) continue;
                fireVisited[ny][nx] = fireVisited[cur.y][cur.x]+1;
                fires.add(new Point(ny,nx));
            }
        }
    }

    private static void bfs(){
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(jy,jx));
        visited[jy][jx]=0;
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            for(int i=0;i<4;i++){
                int ny = cur.y+dy[i];
                int nx = cur.x+dx[i];
                if(ny<0||nx<0||ny>=n||nx>=m||visited[ny][nx]!=-1||graph[ny][nx].equals("#")) continue;
                if(fireVisited[ny][nx]!=-1 && fireVisited[ny][nx]<=visited[cur.y][cur.x]+1) continue;
                visited[ny][nx] = visited[cur.y][cur.x]+1;
                queue.add(new Point(ny,nx));
            }
        }
    }
}
