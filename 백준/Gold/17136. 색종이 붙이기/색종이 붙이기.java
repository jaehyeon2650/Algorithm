import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[][] graph = new int[11][11];
    public static int[] counts = new int[6];
    public static int maxn = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(0,0,0);
        if(maxn==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(maxn);
        }
    }

    private static void go(int y,int x,int cnt) {
        if(cnt>=maxn) return;
        if(x==10) {
            go(y+1,0,cnt);
            return;
        }
        if(y==10){
            maxn = Math.min(maxn,cnt);
            return;
        }
        if(graph[y][x]==0) {
            go(y,x+1,cnt);
            return;
        }

        for(int i=5;i>=1;i--){
            if(can(y,x,i) && counts[i]<5){
                checkGraph(y,x,i,0);
                counts[i]++;
                go(y,x+1,cnt+1);
                counts[i]--;
                checkGraph(y,x,i,1);
            }
        }
    }

    private static void checkGraph(int y, int x, int size, int num) {
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                graph[y+i][x+j]=num;
            }
        }
    }

    private static boolean can(int y,int x, int size) {
        if(y+size-1>=10 || x+size-1>=10) return false;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(graph[y+i][x+j]==0) return false;
            }
        }
        return true;
    }
}
