    import java.io.*;
    import java.util.Arrays;

    class Main {

        public static int n;
        public static int[][] a=new int[18][18];
        public static int[][][] dp=new int[18][18][3];

        public static void main(String[] args) throws IOException {
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            n=Integer.parseInt(bf.readLine());
            for(int i=1;i<=n;i++){
                String s=bf.readLine();
                String[] strings = s.split(" ");
                for(int j=0;j<n;j++){
                    a[i][j+1]=Integer.parseInt(strings[j]);
                }
            }
            dp[1][2][0]=1;
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    go(i,j);
                }
            }
            System.out.println(dp[n][n][0]+dp[n][n][1]+dp[n][n][2]);
        }
        public static void go(int y,int x){
            if(check(y,x+1,0)) dp[y][x+1][0]+=dp[y][x][0];
            if(check(y,x+1,0)) dp[y][x+1][0]+=dp[y][x][1];

            if(check(y+1,x,2)) dp[y+1][x][2]+=dp[y][x][2];
            if(check(y+1,x,2)) dp[y+1][x][2]+=dp[y][x][1];

            if(check(y+1,x+1,1)) dp[y+1][x+1][1]+=dp[y][x][0];
            if(check(y+1,x+1,1)) dp[y+1][x+1][1]+=dp[y][x][1];
            if(check(y+1,x+1,1)) dp[y+1][x+1][1]+=dp[y][x][2];
        }
        public static boolean check(int y,int x,int how){
            if(how==0||how==2){
                if(a[y][x]==1) return false;
            }else{
                if(a[y][x]==1||a[y-1][x]==1||a[y][x-1]==1) return false;
            }
            return true;
        }
    }