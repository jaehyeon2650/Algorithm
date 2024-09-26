import java.io.*;

public class Main {
    public static int n;
    public static int k;
    public static int[] dp=new int[13];
    public static void main(String[] args) throws IOException {
        dp[0]=1;
        for(int i=1;i<13;i++){
            if(i-1>=0) dp[i]+=(dp[i-1]);
            if(i-2>=0) dp[i]+=(dp[i-2]);
            if(i-3>=0) dp[i]+=(dp[i-3]);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer bf=new StringBuffer();
        n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            k=Integer.parseInt(br.readLine());
            bf.append(dp[k]+"\n");
        }
        System.out.println(bf);
    }
}
