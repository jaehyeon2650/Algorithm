import java.io.*;
import java.util.Arrays;


public class Main {
    public static int n;
    public static int[] a;
    public static int[][][] dp=new int[5][5][100004];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        String s=br.readLine();
        String[] s1 = s.split(" ");
        n=s1.length-1;
        a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(s1[i]);
        }
        System.out.println(go(0,0,0));
    }

    public static int check(int from,int to){
        if(from==0) return 2;
        if(from==to) return 1;
        if(Math.abs(from-to)==2) return 4;
        return 3;
    }
    public static int go(int x,int y,int ind) {
        if (ind == n) return 0;
        if (dp[x][y][ind] != -1) return dp[x][y][ind];
        int left=(go(a[ind],y,ind+1))+check(x,a[ind]);
        int right=(go(x,a[ind],ind+1))+check(y,a[ind]);
        dp[x][y][ind]=Math.min(left,right);
        return dp[x][y][ind];
    }
}
