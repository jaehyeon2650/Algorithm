import java.io.*;

public class Main {
    public static int n;
    public static int[][] dpmax;
    public static int[][] a;
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb=new StringBuffer();
        n=Integer.parseInt(bf.readLine());
        a=new int[n][3];
        dpmax=new int[n][3];
        for(int i=0;i<n;i++){
            String s=bf.readLine();
            String[] s1 = s.split(" ");
            for(int j=0;j<3;j++){
                a[i][j]=Integer.parseInt(s1[j]);
            }
        }
        dpmax[0][0]=a[0][0];
        dpmax[0][1]=a[0][1];
        dpmax[0][2]=a[0][2];
        for(int i=1;i<n;i++){
            dpmax[i][0]=Math.max(dpmax[i-1][0],dpmax[i-1][1])+a[i][0];
            dpmax[i][2]=Math.max(dpmax[i-1][1],dpmax[i-1][2])+a[i][2];
            dpmax[i][1]=Math.max(Math.max(dpmax[i-1][0],dpmax[i-1][1]),dpmax[i-1][2])+a[i][1];
        }
        int maxn=dpmax[n-1][0];
        for(int i=1;i<3;i++){
            maxn=Math.max(maxn,dpmax[n-1][i]);
        }
        sb.append(maxn+" ");
        for(int i=1;i<n;i++){
            dpmax[i][0]=Math.min(dpmax[i-1][0],dpmax[i-1][1])+a[i][0];
            dpmax[i][2]=Math.min(dpmax[i-1][1],dpmax[i-1][2])+a[i][2];
            dpmax[i][1]=Math.min(Math.min(dpmax[i-1][0],dpmax[i-1][1]),dpmax[i-1][2])+a[i][1];
        }
        maxn=dpmax[n-1][0];
        for(int i=1;i<3;i++){
            maxn=Math.min(maxn,dpmax[n-1][i]);
        }
        sb.append(maxn);
        System.out.println(sb);
    }

}
