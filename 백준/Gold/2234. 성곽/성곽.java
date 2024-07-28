import java.util.*;
class Main {
    public static int maxn=0;
    public static int [][] a;
    public static int n; // 열
    public static int m; // 행
    public static int num;
    public static int [][] visited;
    public static int[] dx={-1,0,1,0};
    public static int[] dy={0,-1,0,1};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n=scan.nextInt();
        m=scan.nextInt();
        a=new int[m][n];
        visited=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=scan.nextInt();
            }
        }
        solution();
    }

    public static void dfs(int y,int x){
        num++;
        visited[y][x]=1;
        for(int i=0;i<4;i++){
            if((a[y][x]&(1<<i))==0){
                int ny=y+dy[i];
                int nx=x+dx[i];
                if(ny<0||nx<0||ny>=m||nx>=n||visited[ny][nx]!=0) continue;
                dfs(ny,nx);
            }
        }
    }
    public static void visitedZero(){
        for(int i=0;i<m;i++){
            Arrays.fill(visited[i],0);
        }
    }
    public static void solution(){
        int rooms=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==0){
                    rooms++;
                    num=0;
                    dfs(i,j);
                    maxn=Math.max(num,maxn);
                }
            }
        }
        System.out.println(rooms);
        System.out.println(maxn);
        maxn=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                for(int k=0;k<4;k++){
                    if((a[i][j]&(1<<k))>0){
                        a[i][j]^=(1<<k);
                        visitedZero();
                        for(int q=0;q<m;q++){
                            for(int w=0;w<n;w++){
                                if(visited[q][w]==0){
                                    rooms++;
                                    num=0;
                                    dfs(q,w);
                                    maxn=Math.max(num,maxn);
                                }
                            }
                        }
                        a[i][j]^=(1<<k);
                    }
                }
            }
        }
        System.out.println(maxn);
    }
}