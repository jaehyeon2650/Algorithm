import java.io.*;
import java.util.Arrays;

public class Main {
    public static double a;
    public static double b;
    public static double[][][] dp=new double[20][20][20];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<20;i++){
            for(int j=0;j<20;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        a=Double.parseDouble(br.readLine());
        b=Double.parseDouble(br.readLine());
        a/=100; b/=100;
        System.out.printf("%.6f", go(0,0,0));
    }
    public static double go(int ind,int x,int y){
        if(ind==18){
            if(check(x)||check(y)) return 1;
            return 0;
        }
        if(dp[ind][x][y]>-0.5) return dp[ind][x][y];
        double result=0;
        result+=go(ind+1,x+1,y)*a*(1-b);
        result+=go(ind+1,x,y)*(1-a)*(1-b);
        result+=go(ind+1,x,y+1)*(1-a)*b;
        result+=go(ind+1,x+1,y+1)*a*b;
        dp[ind][x][y]=result;
        return result;

    }
    public static boolean check(int x){
        if(x==1) return false;
        if(x==2||x==3) return true;
        if (x % 2 == 0 || x % 3 == 0) return false;
        for(int i=2;i<19;i=i*i){
            if(x%i==0) return false;
        }
        return true;
    }
}
