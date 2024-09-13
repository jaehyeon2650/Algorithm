    import java.io.*;
    import java.util.Arrays;

    class Main {

        public static int n;
        public static int m;
        public static int c;
        public static int[][] a;
        public static int[][][][] dp=new int[51][51][51][51];
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuffer stringBuffer=new StringBuffer();
            String s = br.readLine();
            String[] s1 = s.split(" ");
            n=Integer.parseInt(s1[0]);
            m=Integer.parseInt(s1[1]);
            c=Integer.parseInt(s1[2]);
            a=new int[n+1][m+1];
            for(int i=1;i<=c;i++){
                s=br.readLine();
                s1=s.split(" ");
                int y=Integer.parseInt(s1[0]);
                int x=Integer.parseInt(s1[1]);
                a[y][x]=i;
            }
            for(int i=0;i<51;i++){
                for(int j=0;j<51;j++){
                    for(int k=0;k<51;k++){
                        Arrays.fill(dp[i][j][k],-1);
                    }
                }
            }
            for(int i=0;i<=c;i++){
                stringBuffer.append(go(1,1,i,0)+" ");
            }
            System.out.println(stringBuffer);
        }

        public static int go(int y,int x,int cnt,int cur){
            if(y>n||x>m) return 0;
            if(y==n&&x==m){
                if(a[y][x]>0&&a[y][x]>cur&&cnt==1) return 1;
                else if(a[y][x]==0&&cnt==0) return 1;
                return 0;
            }
            if(dp[y][x][cnt][cur]!=-1) return dp[y][x][cnt][cur];
            int ret=0;
            if(a[y][x]==0){
                ret=(go(y+1,x,cnt,cur)+go(y,x+1,cnt,cur))%1000007;
            }else if(a[y][x]>0&&cnt>0&&a[y][x]>cur){
                ret=(go(y+1,x,cnt-1,a[y][x])+go(y,x+1,cnt-1,a[y][x]))%1000007;
            }
            dp[y][x][cnt][cur]=ret;
            return ret;
        }


    }