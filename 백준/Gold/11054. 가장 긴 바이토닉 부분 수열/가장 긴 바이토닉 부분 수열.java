import java.io.*;

public class Main {
    public static int n;
    public static int[] a;
    public static int[] dp1;
    public static int[] dp2;
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(bf.readLine());
        String s=bf.readLine();
        String[] s1 = s.split(" ");
        a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(s1[i]);
        }
        dp1=new int[n];
        dp2=new int[n];
        for(int i=0;i<n;i++){
            int ret=0;
            for(int j=0;j<i;j++){
                if(a[i]>a[j]) ret=Math.max(ret,dp1[j]);
            }
            dp1[i]=ret+1;
        }
        for(int i=n-1;i>=0;i--){
            int ret=0;
            for(int j=i+1;j<n;j++){
                if(a[i]>a[j]) ret=Math.max(ret,dp2[j]);
            }
            dp2[i]=ret+1;
        }

        int maxn=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(a[i]>a[j]) maxn=Math.max(maxn,dp1[i]+dp2[j]);
            }
            maxn=Math.max(maxn,dp1[i]);
        }
        System.out.println(maxn);
    }
}
