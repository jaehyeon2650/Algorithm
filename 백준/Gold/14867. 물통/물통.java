import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int m;
    public static int a;
    public static int b;
    public static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        String[] s1 = s.split(" ");
        n=Integer.parseInt(s1[0]);
        m=Integer.parseInt(s1[1]);
        a=Integer.parseInt(s1[2]);
        b=Integer.parseInt(s1[3]);
        visited=new int[n+1][m+1];
        go(0,0,0);
        if(visited[a][b]==0&&a!=0&&b!=0) System.out.println(-1);
        else System.out.println(visited[a][b]);
    }

    public static void go(int nowA,int nowB,int cnt){
        if(visited[nowA][nowB]!=0&&visited[nowA][nowB]<cnt) return;
        visited[nowA][nowB]=cnt;
        if(nowA==a&&nowB==b) return;
        if(cnt>=1){
            // 버리기
            go(0,nowB,cnt+1);
            go(nowA,0,cnt+1);

            //옮기기
            if(nowA!=n){ //b->a
                int rest=n-nowA;
                if(rest<nowB){
                    go(n,nowB-rest,cnt+1);
                }else{
                    go(nowA+nowB,0,cnt+1);
                }
            }
            if(nowB!=m){ //a->b
                int rest=m-nowB;
                if(rest<nowA){
                    go(nowA-rest,m,cnt+1);
                }else{
                    go(0,nowA+nowB,cnt+1);
                }
            }
        }
        // 채우기
        go(n,nowB,cnt+1);
        go(nowA,m,cnt+1);
    }
}
