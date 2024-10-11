import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.Vector;

class Main {
    public static int n;
    public static int[][] a;
    public static int[][] visited;
    public static int[] dx={0,1,0,-1};
    public static int[] dy={1,0,-1,0};
    static class Pair{
        public int y,x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(bf.readLine());
        a=new int[n][n];
        visited=new int[n][n];
        for(int i=0;i<n;i++){
            String s=bf.readLine();
            for(int j=0;j<n;j++){
                a[i][j]=Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        Vector<Integer> v=new Vector<>();
        int total=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==0&&a[i][j]==1){
                    total++;
                    v.add(bfs(i,j));
                }
            }
        }
        Collections.sort(v);
        System.out.println(total);
        for (Integer i : v) {
            System.out.println(i);
        }
    }
    public static int bfs(int y,int x){
        int count=0;
        visited[y][x]=1;
        Queue<Pair> q=new ArrayDeque<>();
        q.add(new Pair(y,x));
        while(!q.isEmpty()){
            count++;
            Pair poll = q.poll();
            int nowy= poll.y;
            int nowx= poll.x;
            for(int i=0;i<4;i++){
                int ny=nowy+dy[i];
                int nx=nowx+dx[i];
                if(ny<0||nx<0||ny>=n||nx>=n||visited[ny][nx]==1||a[ny][nx]==0) continue;
                visited[ny][nx]=1;
                q.add(new Pair(ny,nx));
            }
        }
        return count;
    }
}