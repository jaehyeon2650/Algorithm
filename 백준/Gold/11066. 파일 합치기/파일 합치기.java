import java.io.*;

public class Main {
    public static int t;
    public static int n;
    public static int[] a;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb=new StringBuffer();
        t=Integer.parseInt(bf.readLine());
        for(int i=0;i<t;i++){
            n=Integer.parseInt(bf.readLine());
            String s=bf.readLine();
            a=new int[n+1];
            String[] s1 = s.split(" ");
            for(int j=1;j<=n;j++){
                a[j]=Integer.parseInt(s1[j-1])+a[j-1];
            }
            dp=new int[n+1][n+1];
            for(int j=1;j<n;j++){
                dp[j][j+1]=a[j+1]-a[j-1];
            }
            for(int j=2;j<n;j++){
                for(int k=1;k+j<=n;k++){
                    dp[k][k+j]=Integer.MAX_VALUE;
                    for(int mid=k;mid<k+j;mid++){
                        dp[k][k+j]=Math.min(dp[k][k+j],dp[k][mid]+dp[mid+1][k+j]+a[k+j]-a[k-1]);
                    }
                }
            }
            sb.append(dp[1][n]+"\n");
        }
        System.out.println(sb);

    }

}
