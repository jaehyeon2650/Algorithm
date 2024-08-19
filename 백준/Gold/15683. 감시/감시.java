import java.io.*;
import java.util.*;

class Main {
    public static int maxn=Integer.MAX_VALUE;
    public static int n;
    public static int m;
    public static int[][] a;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};

    static class CCTV {
        public int num;
        public int y;
        public int x;

        public CCTV(int num, int y, int x) {
            this.num = num;
            this.y = y;
            this.x = x;
        }
    }

    public static Vector<CCTV> v = new Vector<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s1 = bf.readLine();
        String[] strings1 = s1.split(" ");
        n = Integer.parseInt(strings1[0]);
        m = Integer.parseInt(strings1[1]);
        int[][] visited=new int[n][m];
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = bf.readLine();
            String[] strings = s.split(" ");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(strings[j]);
                if (a[i][j] > 0 && a[i][j] < 6) v.add(new CCTV(a[i][j], i, j));
            }
        }
        go(0,visited);
        System.out.println(maxn);
    }

    public static void go(int index, int[][] visited) {
        if (index == v.size()) {
            int sum=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(visited[i][j]==0&&a[i][j]==0) sum++;
                }
            }
            maxn=Math.min(maxn,sum);
            return;
        }
        CCTV now = v.get(index);
        if (now.num == 1) {
            for (int i = 0; i < 4; i++) {
                int[][] newv = copy(visited);
                go1(newv,i,now);
                go(index+1,newv);
            }
        } else if (now.num == 2) {
            for (int i = 0; i < 2; i++) {
                int[][] newv = copy(visited);
                go2(newv,i,now);
                go(index+1,newv);
            }
        } else if (now.num == 3) {
            for (int i = 0; i < 4; i++) {
                int[][] newv = copy(visited);
                go3(newv,i,now);
                go(index+1,newv);
            }
        } else if (now.num == 4) {
            for (int i = 0; i < 4; i++) {
                int[][] newv = copy(visited);
                go4(newv,i,now);
                go(index+1,newv);
            }
        } else {
            int[][] newv = copy(visited);
            go5(newv,now);
            go(index+1,newv);
        }
    }

    public static void go1(int[][] visited, int num, CCTV now) {
        int ny = now.y + dy[num];
        int nx = now.x + dx[num];
        while (ny >= 0 && ny < n && nx >= 0 && nx < m&&a[ny][nx] != 6) {
            if (visited[ny][nx] == 0) visited[ny][nx] = 1;
            ny = ny + dy[num];
            nx = nx + dx[num];
        }
    }

    public static void go2(int[][] visited, int num, CCTV now) {
        int ny = now.y + dy[num];
        int nx = now.x + dx[num];
        while (ny >= 0 && ny < n && nx >= 0 && nx < m&&a[ny][nx] != 6) {
            if (visited[ny][nx] == 0) visited[ny][nx] = 1;
            ny = ny + dy[num];
            nx = nx + dx[num];
        }
        ny=now.y+dy[num+2];
        nx=now.x+dx[num+2];
        while (ny >= 0 && ny < n && nx >= 0 && nx < m&&a[ny][nx] != 6) {
            if (visited[ny][nx] == 0) visited[ny][nx] = 1;
            ny = ny + dy[num+2];
            nx = nx + dx[num+2];
        }
    }

    public static void go3(int[][] visited, int num, CCTV now){
        int ny = now.y + dy[num];
        int nx = now.x + dx[num];
        while (ny >= 0 && ny < n && nx >= 0 && nx < m&&a[ny][nx] != 6) {
            if (visited[ny][nx] == 0) visited[ny][nx] = 1;
            ny = ny + dy[num];
            nx = nx + dx[num];
        }
        ny=now.y+dy[(num+1)%4];
        nx=now.x+dx[(num+1)%4];
        while (ny >= 0 && ny < n && nx >= 0 && nx < m&&a[ny][nx] != 6) {
            if (visited[ny][nx] == 0) visited[ny][nx] = 1;
            ny = ny + dy[(num+1)%4];
            nx = nx + dx[(num+1)%4];
        }
    }

    public static void go4(int[][] visited, int num, CCTV now){
        for(int i=0;i<4;i++){
            if(num==i) continue;
            int ny = now.y + dy[i];
            int nx = now.x + dx[i];
            while (ny >= 0 && ny < n && nx >= 0 && nx < m&&a[ny][nx] != 6) {
                if (visited[ny][nx] == 0) visited[ny][nx] = 1;
                ny = ny + dy[i];
                nx = nx + dx[i];
            }
        }
    }
    public static void go5(int[][] visited, CCTV now){
        for(int i=0;i<4;i++){
            int ny = now.y + dy[i];
            int nx = now.x + dx[i];
            while (ny >= 0 && ny < n && nx >= 0 && nx < m&&a[ny][nx] != 6) {
                if (visited[ny][nx] == 0) visited[ny][nx] = 1;
                ny = ny + dy[i];
                nx = nx + dx[i];
            }
        }
    }
    public static int[][] copy(int[][] visited) {
        int[][] newVisit = new int[n][m];
        for (int i = 0; i < n; i++) {
            newVisit[i] = Arrays.copyOf(visited[i], m);
        }
        return newVisit;
    }

}