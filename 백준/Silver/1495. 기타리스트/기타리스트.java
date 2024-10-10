import java.io.*;

public class Main {
    public static int n,s,m;
    public static int[] a;
    public static boolean[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String st=bf.readLine();
        String[] s1 = st.split(" ");
        n=Integer.parseInt(s1[0]);
        s=Integer.parseInt(s1[1]);
        m=Integer.parseInt(s1[2]);
        a=new int[n+1];
        dp=new boolean[n+1][m+1];
        st=bf.readLine();
        s1=st.split(" ");
        dp[0][s]=true;
        for(int i=0;i<n;i++){
            a[i+1]=Integer.parseInt(s1[i]);
        }
        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(dp[i-1][j]){
                    int minus=j-a[i];
                    int plus=j+a[i];
                    if(minus>=0) dp[i][minus]=true;
                    if(plus<=m) dp[i][plus]=true;

                }
            }
        }
        int ret=-1;
        for(int i=0;i<=m;i++){
            if(dp[n][i]){
                ret=i;
            }
        }
        System.out.println(ret);
    }


}
