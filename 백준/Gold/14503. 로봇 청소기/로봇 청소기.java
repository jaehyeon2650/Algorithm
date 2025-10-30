import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    private static int n;
    private static int m;
    private static int[][] graph;
    private static int nowDirection;
    private static int nowy;
    private static int nowx;
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {-1,0,1,0};
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        st = new StringTokenizer(bf.readLine());
        nowy = Integer.parseInt(st.nextToken());
        nowx = Integer.parseInt(st.nextToken());
        nowDirection = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            clean();
            if(thereIsDirty()){
                go();
            }else{
                if(!goBack()) break;
            }
        }
        System.out.println(result);
    }

    private static void clean(){
        if(graph[nowy][nowx]==0){
            graph[nowy][nowx]=2;
            result++;
        }
    }

    private static boolean goBack(){
        int back = (nowDirection+2)%4;
        int ny = nowy+dy[back];
        int nx = nowx+dx[back];
        if(ny<0||nx<0||ny>=n||nx>=m||graph[ny][nx]==1) return false;
        nowy = ny;
        nowx = nx;
        return true;
    }

    private static boolean thereIsDirty(){
        for(int i=0;i<4;i++){
            int ny = nowy +dy[i];
            int nx = nowx + dx[i];
            if(ny<0||nx<0||ny>=n||nx>=m||graph[ny][nx]!=0) continue;
            return true;
        }
        return false;
    }

    private static void go(){
        nowDirection = (nowDirection-1+4)%4;
        int ny = nowy + dy[nowDirection];
        int nx = nowx + dx[nowDirection];
        if(ny<0||nx<0||ny>=n||nx>=m||graph[ny][nx]!=0) return;
        nowy = ny;
        nowx = nx;
    }

}
