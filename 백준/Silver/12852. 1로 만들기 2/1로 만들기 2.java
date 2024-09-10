    import java.io.*;

    class Main {

        public static int n;
        public static int[] dp;
        public static int[] result;
        public static void main(String[] args) throws IOException {
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            n=Integer.parseInt(bf.readLine());
            dp=new int[1000004];
            result=new int[1000004];
            StringBuilder sb=new StringBuilder();
            dp[2]=1;
            result[2]=1;
            dp[3]=1;
            result[3]=1;
            dp[4]=2;
            result[4]=2;
            for(int i=1;i<=n;i++){
                go(i);
            }
            System.out.println(dp[n]);
            int index=n;
            sb.append(index+" ");
            while (index!=1){
                index=result[index];
                sb.append(index+" ");
            }
            System.out.println(sb);
        }

        public static int go(int num){
            if(num<=1) return 0;
            if(dp[num]>0) return dp[num];
            int ret=Integer.MAX_VALUE;
            if(num%3==0){
                if(ret>go(num/3)){
                    ret=go(num/3);
                    result[num]=num/3;
                }
            }
            if(num%2==0){
                if(ret>go(num/2)){
                    ret=go(num/2);
                    result[num]=num/2;
                }
            }
            if(ret>go(num-1)){
                ret=go(num-1);
                result[num]=num-1;
            }
            dp[num]=ret+1;
            return dp[num];
        }
    }