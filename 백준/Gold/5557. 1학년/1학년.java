import java.io.*;
import java.util.Arrays;


public class Main {
    public static int n;
    public static int[] a;
    public static Long[][][] dp=new Long[101][2][21];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        a=new int[n];
        String s=br.readLine();
        String[] s1 = s.split(" ");
        for(int i=0;i<101;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1L);
            }
        }
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(s1[i]);
        }
        System.out.println(go(0,0,a[0]));
    }
    public static Long go(int index,int how,int result){
        if(index==n-2&&result==a[n-1]) return 1L;
        else if(index==n-2) return 0L;
        if(dp[index][how][result]!=-1) return dp[index][how][result];
        Long ret=0L;
        if(result+a[index+1]>=0&&result+a[index+1]<=20) ret+=go(index+1,0,result+a[index+1]);
        if(result-a[index+1]>=0&&result-a[index+1]<=20) ret+=go(index+1,1,result-a[index+1]);
        dp[index][how][result]=ret;
        return ret;
    }

}
