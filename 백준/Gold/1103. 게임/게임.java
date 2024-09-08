    import java.io.*;

    class Main {

        public static int n;
        public static int m;
        public static int[] dx={1,0,-1,0};
        public static int[] dy={0,1,0,-1};
        public static int[][] a;
        public static int[][] visited;
        public static int[][] dp;

        public static void main(String[] args) throws IOException {
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            String s= bf.readLine();
            String[] strings1 = s.split(" ");
            n=Integer.parseInt(strings1[0]);
            m=Integer.parseInt(strings1[1]);
            a=new int[n][m];
            visited=new int[n][m];
            dp=new int[n][m];
            for(int i=0;i<n;i++){
                s=bf.readLine();
                for(int j=0;j<m;j++){
                    if(s.charAt(j)=='H') a[i][j]=-1;
                    else a[i][j]=Integer.parseInt(String.valueOf(s.charAt(j)));
                }
            }
            visited[0][0]=1;
            System.out.println(bfs(0,0));
        }
        public static int bfs(int y,int x){
            if(y<0||x<0||y>=n||x>=m||a[y][x]==-1) return 0;
            int ret=0;
            if(dp[y][x]>0) return dp[y][x];
            for(int i=0;i<4;i++){
                int ny=y+a[y][x]*dy[i];
                int nx=x+a[y][x]*dx[i];
                if(ny<0||nx<0||ny>=n||nx>=m) ret=Math.max(ret,bfs(ny,nx));
                else{
                    if(visited[ny][nx]>0){
                        System.out.println(-1);
                        System.exit(0);
                    }
                    visited[ny][nx]=1;
                    ret=Math.max(ret,bfs(ny,nx));
                    visited[ny][nx]=0;
                }
            }
            dp[y][x]=ret+1;
            return ret+1;
        }
    }