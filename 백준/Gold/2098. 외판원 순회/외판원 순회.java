    import java.io.*;
    import java.util.Arrays;

    class Main {

        public static int n;
        public static int[][] a;
        public static int[][] dp;
        public static int INF=987654321;

        public static void main(String[] args) throws IOException {
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            n=Integer.parseInt(bf.readLine());
            a=new int[16][16];
            dp=new int[16][1<<16];
            for(int i=0;i<n;i++){
                String s=bf.readLine();
                String[] strings = s.split(" ");
                for(int j=0;j<n;j++){
                    a[i][j]=Integer.parseInt(strings[j]);
                }
            }
            for(int i=0;i<16;i++){
                Arrays.fill(dp[i],-1);
            }
            System.out.println(tsp(0,1));
        }

        public static int tsp(int here,int visited){
            if(visited==(1<<n)-1){
                return a[here][0]!=0?a[here][0]:INF;
            }
            if(dp[here][visited]!=-1) return dp[here][visited];
            int ret=INF;
            for(int i=0;i<n;i++){
                if((visited&(1<<i))>0) continue;
                if(a[here][i]==0) continue;
                ret=Math.min(ret,tsp(i,visited|(1<<i))+a[here][i]);
            }
            dp[here][visited]=ret;
            return ret;
        }

    }