    import java.io.*;
    import java.util.*;

    class Main {

        public static int n;
        public static int dp[][][];
        public static int[][] a;

        public static void main(String[] args) throws IOException {
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            n=Integer.parseInt(bf.readLine());
            a=new int[24][24];
            dp=new int[24][24][3];
            dp[1][2][0]=1;
            for(int i=1;i<=n;i++){
                String s=bf.readLine();
                String[] strings = s.split(" ");
                for(int j=0;j<n;j++){
                    a[i][j+1]=Integer.parseInt(strings[j]);
                }
            }
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    // 원래 가로
                    if(check(i,j+1,0)) dp[i][j+1][0]+=dp[i][j][0];
                    if(check(i+1,j+1,1)) dp[i+1][j+1][1]+=dp[i][j][0];

                    // 원래 세로
                    if(check(i+1,j,2)) dp[i+1][j][2]+=dp[i][j][2];
                    if(check(i+1,j+1,1)) dp[i+1][j+1][1]+=dp[i][j][2];

                    // 원래 대각
                    if(check(i+1,j,2)) dp[i+1][j][2]+=dp[i][j][1];
                    if(check(i+1,j+1,1)) dp[i+1][j+1][1]+=dp[i][j][1];
                    if(check(i,j+1,0)) dp[i][j+1][0]+=dp[i][j][1];
                }
            }
            int ret=dp[n][n][0]+dp[n][n][1]+dp[n][n][2];
            System.out.println(ret);

        }

        public static boolean check(int y,int x,int d){
            if(d==0||d==2){
                if(a[y][x]==1) return false;
            }else{
                if(a[y-1][x]==1||a[y][x]==1||a[y][x-1]==1) return false;
            }
            return true;

        }

    }