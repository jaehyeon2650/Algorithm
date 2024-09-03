    import java.io.*;
    import java.util.*;

    class Main {

        public static int n;

        public static int num;
        public static int[] dp=new int[10004];

        public static void main(String[] args) throws IOException {
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            n=Integer.parseInt(bf.readLine());
            StringBuffer buffer=new StringBuffer();
            dp[0]=1;
            for(int i=1;i<=3;i++){
                for(int j=1;j<=10000;j++){
                    if(j-i>=0) dp[j]+=dp[j-i];
                }

            }
            for(int i=0;i<n;i++){
                num=Integer.parseInt(bf.readLine());
                buffer.append(dp[num]+"\n");
            }
            System.out.println(buffer);
        }

    }