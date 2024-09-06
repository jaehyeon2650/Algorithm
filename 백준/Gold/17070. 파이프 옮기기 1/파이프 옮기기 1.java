    import java.io.*;
    import java.util.*;

    class Main {

        public static int n;
        public static int num=0;
        public static int[][] visited;
        public static int[][] a;
        public static int[] dx={1,1,0};
        public static int[] dy={0,1,1};

        public static void main(String[] args) throws IOException {
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            n=Integer.parseInt(bf.readLine());
            visited=new int[n][n];
            a=new int[n][n];
            for(int i=0;i<n;i++){
                String s=bf.readLine();
                String[] strings = s.split(" ");
                for(int j=0;j<n;j++){
                    a[i][j]=Integer.parseInt(strings[j]);
                }
            }
            visited[0][0]=visited[0][1]=1;
            dfs(0,1);
            System.out.println(num);
        }
        public static void dfs(int y,int x){
            if(y==n-1&&x==n-1){
                num++;
                return;
            }
            if(visited[y][x]==1){
                for(int i=0;i<2;i++){
                    int ny=y+dy[i];
                    int nx=x+dx[i];
                    if(ny<0||nx<0||ny>=n||nx>=n||a[ny][nx]==1) continue;
                    if(i==1&&(y+dy[0]<0||x+dx[0]<0||y+dy[0]>=n||x+dx[0]>=n||a[y+dy[0]][x+dx[0]]==1)) continue;
                    if(i==1&&(y+dy[2]<0||x+dx[2]<0||y+dy[2]>=n||x+dx[2]>=n||a[y+dy[2]][x+dx[2]]==1)) continue;
                    visited[ny][nx]=i+1;
                    dfs(ny,nx);
                    visited[ny][nx]=0;
                }
            }else if(visited[y][x]==2){
                for(int i=0;i<3;i++){
                    int ny=y+dy[i];
                    int nx=x+dx[i];
                    if(ny<0||nx<0||ny>=n||nx>=n||a[ny][nx]==1) continue;
                    if(i==1&&(y+dy[0]<0||x+dx[0]<0||y+dy[0]>=n||x+dx[0]>=n||a[y+dy[0]][x+dx[0]]==1)) continue;
                    if(i==1&&(y+dy[2]<0||x+dx[2]<0||y+dy[2]>=n||x+dx[2]>=n||a[y+dy[2]][x+dx[2]]==1)) continue;
                    visited[ny][nx]=i+1;
                    dfs(ny,nx);
                    visited[ny][nx]=0;
                }
            }else{
                for(int i=1;i<3;i++){
                    int ny=y+dy[i];
                    int nx=x+dx[i];
                    if(ny<0||nx<0||ny>=n||nx>=n||a[ny][nx]==1) continue;
                    if(i==1&&(y+dy[0]<0||x+dx[0]<0||y+dy[0]>=n||x+dx[0]>=n||a[y+dy[0]][x+dx[0]]==1)) continue;
                    if(i==1&&(y+dy[2]<0||x+dx[2]<0||y+dy[2]>=n||x+dx[2]>=n||a[y+dy[2]][x+dx[2]]==1)) continue;
                    visited[ny][nx]=i+1;
                    dfs(ny,nx);
                    visited[ny][nx]=0;
                }
            }
        }

    }