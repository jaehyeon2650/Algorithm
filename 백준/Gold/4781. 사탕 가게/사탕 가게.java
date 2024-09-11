    import java.io.*;
    import java.util.Arrays;

    class Main {

        public static int n;
        public static int k;
        public static int[] dp=new int[10004];
        public static void main(String[] args) throws IOException {
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            StringBuffer sb=new StringBuffer();
            String s = bf.readLine();
            String[] strings = s.split(" ");
            n=Integer.parseInt(strings[0]);
            k=(int) (Double.parseDouble(strings[1])*100+0.5);
            while (n!=0&&k!=0){
                Arrays.fill(dp,0);
                int minn=0;
                for(int i=0;i<n;i++){
                    s = bf.readLine();
                    strings = s.split(" ");
                    int a=Integer.parseInt(strings[0]);
                    int b=(int) (Double.parseDouble(strings[1])*100+0.5);
                    for(int j=b;j<=k;j++){
                        if(dp[j]<dp[j-b]+a){
                            dp[j]=dp[j-b]+a;
                            minn=Math.max(minn,dp[j]);
                        }
                    }
                }
                sb.append(minn+"\n");
                s = bf.readLine();
                strings = s.split(" ");
                n=Integer.parseInt(strings[0]);
                k=(int) (Double.parseDouble(strings[1])*100+0.5);
            }
            System.out.println(sb);
        }
    }