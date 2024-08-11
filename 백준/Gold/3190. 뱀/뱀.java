import java.io.*;
import java.util.*;

class Main {
    public static int n;
    public static int[][] a;
    public static Dot start=new Dot(0,0);
    public static int apple;
    public static int[] dx={1,0,-1,0};
    public static int[] dy={0,1,0,-1};
    public static int[][] visited;
    static class Pair{
        public int x;
        public char y;

        public Pair(int x, char y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Dot{
        public int x;
        public int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static Queue<Pair> q=new ArrayDeque<>();
    public static Queue<Dot> snake=new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(bf.readLine());
        a=new int[n][n];
        visited=new int[n][n];
        apple=Integer.parseInt(bf.readLine());
        for(int i=0;i<apple;i++){
            String s=bf.readLine();
            String[] strings = s.split(" ");
            a[Integer.parseInt(strings[0])-1][Integer.parseInt(strings[1])-1]=1;
        }
        apple=Integer.parseInt(bf.readLine());
        for(int i=0;i<apple;i++){
            String s=bf.readLine();
            String[] strings = s.split(" ");
            q.add(new Pair(Integer.parseInt(strings[0]),strings[1].charAt(0)));
        }
        System.out.println(start());
    }

    public static int start(){
        int length=0;
        int total=0;
        int i=0;
        visited[start.y][start.x]=1;
        snake.add(new Dot(start.x,start.y));
        while(true){
            total++;
            int nextx=start.x+dx[i];
            int nexty=start.y+dy[i];
            if(nextx<0||nextx>=n||nexty<0||nexty>=n||visited[nexty][nextx]==1) break;
            if(a[nexty][nextx]==1){
                //사과 먹었을때
                start.x+=dx[i];
                start.y+=dy[i];
                length++;
                a[nexty][nextx]=0;
            }else{
                //평상시
                visited[snake.peek().y][snake.peek().x]=0;
                snake.poll();
                start.x+=dx[i];
                start.y+=dy[i];
            }
            snake.add(new Dot(start.x,start.y));
            visited[start.y][start.x]=1;
            if(!q.isEmpty()&&q.peek().x==total){
                if(q.peek().y=='D'){
                    i=(i+1)%4;
                }else{
                    i=(i-1+4)%4;
                }
                q.poll();
            }

        }
        return total;
    }

}