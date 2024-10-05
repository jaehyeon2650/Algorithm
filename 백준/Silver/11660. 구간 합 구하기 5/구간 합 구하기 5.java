import java.io.*;

public class Main {
    public static int n;
    public static int m;
    public static int x1,x2,y1,y2;
    public static int[][] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb=new StringBuffer();
        String s=bf.readLine();
        String[] s1 = s.split(" ");
        n=Integer.parseInt(s1[0]);
        m=Integer.parseInt(s1[1]);
        sum=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            s= bf.readLine();;
            s1=s.split(" ");
            for(int j=1;j<=n;j++){
                if(j==1&&i!=1) sum[i][j]=sum[i-1][n]+Integer.parseInt(s1[j-1]);
                else sum[i][j]=sum[i][j-1]+Integer.parseInt(s1[j-1]);
            }
        }
        for(int i=0;i<m;i++){
            s= bf.readLine();
            s1=s.split(" ");
            x1=Integer.parseInt(s1[0]);
            y1=Integer.parseInt(s1[1]);
            x2=Integer.parseInt(s1[2]);
            y2=Integer.parseInt(s1[3]);
            int sums=0;
            for(int j=0;j<x2-x1+1;j++){
                if(y1!=1) sums+=(sum[x1+j][y2]-sum[x1+j][y1-1]);
                else sums+=(sum[x1+j][y2]-sum[x1+j-1][n]);
            }
            sb.append(sums+"\n");
        }
        System.out.println(sb);
    }
}
