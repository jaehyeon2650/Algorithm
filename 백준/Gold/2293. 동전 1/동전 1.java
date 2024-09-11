    import java.io.*;

    class Main {

        public static int n;
        public static int k;
        public static int[] dp;
        public static void main(String[] args) throws IOException {
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            String s = bf.readLine();
            String[] strings = s.split(" ");
            n=Integer.parseInt(strings[0]);
            k=Integer.parseInt(strings[1]);
            dp=new int[k+1];
            for(int i=0;i<n;i++){
                int num=Integer.parseInt(bf.readLine());
                if(num>k) continue;
                dp[num]+=1;
                for(int j=num;j<=k;j++){
                    dp[j]+=dp[j-num];
                }
            }
            System.out.println(dp[k]);
        }
    }