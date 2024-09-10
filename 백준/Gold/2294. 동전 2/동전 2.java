    import java.io.*;

    class Main {

        public static int n;
        public static int k;
        public static int[] a;
        public static int[] dp;
        public static void main(String[] args) throws IOException {
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            String s = bf.readLine();
            String[] strings = s.split(" ");
            n=Integer.parseInt(strings[0]);
            k=Integer.parseInt(strings[1]);
            a=new int[n];
            dp=new int[k+1];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(bf.readLine());
            }

            for(int i=1;i<=k;i++){
                go(i);
            }
            if(dp[k]>k) System.out.println(-1);
            else System.out.println(dp[k]);
        }

        public static int go(int num){
            if(num<0) return k;
            if(num==0) return 0;
            if(dp[num]!=0) return dp[num];
            int ret=Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                ret=Math.min(ret,go(num-a[i]));
            }
            dp[num]=ret+1;
            return dp[num];
        }
    }