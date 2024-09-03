    import java.io.*;
    import java.util.*;

    class Main {

        public static int n;
        public static int w;
        public static int maxn=0;

        public static int[] apple;
        public static int[][][] dp;

        public static void main(String[] args) throws IOException {
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            String s=bf.readLine();
            String[] strings = s.split(" ");
            n=Integer.parseInt(strings[0]);
            w=Integer.parseInt(strings[1]);
            apple=new int[n];
            dp=new int[n][3][w+1];
            for(int i=0;i<n;i++){
                apple[i]=Integer.parseInt(bf.readLine());
            }
            if(apple[0]==1){
                dp[0][1][0]=1;
                dp[0][2][0]=0;
            }
            else{
                dp[0][1][0]=0;
                dp[0][2][0]=1;
            }
            for(int i=1;i<n;i++){
                for(int k=0;k<=w;k++){
                    if(i<=k) break;
                    if(apple[i]==1&&k!=0){
                        dp[i][1][k]=Math.max(dp[i-1][1][k],dp[i-1][2][k-1])+1;
                        dp[i][2][k]=Math.max(dp[i-1][2][k],dp[i-1][1][k-1]);
                    }else if(apple[i]==2&&k!=0){
                        dp[i][1][k]=Math.max(dp[i-1][1][k],dp[i-1][2][k-1]);
                        dp[i][2][k]=Math.max(dp[i-1][2][k],dp[i-1][1][k-1])+1;
                    }else if(apple[i]==1&&k==0){
                        dp[i][1][k]=dp[i-1][1][k]+1;
                        dp[i][2][k]=dp[i-1][2][k];
                    }else if(apple[i]==2&&k==0){
                        dp[i][1][k]=dp[i-1][1][k];
                        dp[i][2][k]=dp[i-1][2][k]+1;
                    }
                }
            }
            for(int i=1;i<3;i++){
                for(int j=0;j<=w;j++){
                    maxn=Math.max(dp[n-1][i][j],maxn);
                }
            }
            System.out.println(maxn);
        }


    }