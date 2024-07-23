import java.util.*;
class Main {
    public static int n;
    public static int m;
    public static int[] dx={-1,0,1,0};
    public static int[] dy={0,1,0,-1};
    public static char[][] alpa;
    public static int total=0;
    public static int maxn=Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        m=scan.nextInt();
        alpa=new char[n][m];
        for(int i=0;i<n;i++){
            String s=scan.next();
            for(int j=0;j<m;j++){
                alpa[i][j]=s.charAt(j);
            }
        }
        dfs(0,0,1<<(int)(alpa[0][0]-'A'),1);
        System.out.println(maxn);
    }
    public static void dfs(int y,int x,int visited,int sum){
        maxn=Math.max(maxn,sum);
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx<0||ny<0||nx>=m||ny>=n) continue;
            int n=(int)(alpa[ny][nx]-'A');
            if((visited&(1<<n))==0){
                dfs(ny,nx,visited|(1<<n),sum+1);
            }
        }
    }
}