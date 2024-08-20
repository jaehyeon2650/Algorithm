import java.io.*;
import java.util.*;

class Main {

    public static int n;
    public static int m;
    public static int k;
    public static int[][] a;
    public static int[] dx={0,1,0,-1};
    public static int[] dy={-1,0,1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s=bf.readLine();
        String[] strings = s.split(" ");
        n=Integer.parseInt(strings[0]);
        m=Integer.parseInt(strings[1]);
        k=Integer.parseInt(strings[2]);
        a=new int[n][m];
        for(int i=0;i<n;i++){
            s= bf.readLine();
            strings=s.split(" ");
            for(int j=0;j<m;j++){
                a[i][j]=Integer.parseInt(strings[j]);
            }
        }
        for(int i=0;i<k;i++){
            s= bf.readLine();
            strings=s.split(" ");
            int a1=Integer.parseInt(strings[0]);
            int a2=Integer.parseInt(strings[1]);
            int a3=Integer.parseInt(strings[2]);
            go(a1,a2,a3);
            a=check(a);
        }
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum+=a[i][j];
            }
        }
        System.out.println(sum);
    }

    public static void go(int cir,int dir,int how){
        if(dir==0){
            for(int c=cir;c<=n;c++){
                if(c%cir!=0) continue;
                for(int i=0;i<how;i++){
                    int temp=a[c-1][m-1];
                    for(int j=m-1;j>0;j--){
                        a[c-1][j]=a[c-1][j-1];
                    }
                    a[c-1][0]=temp;
                }
            }
        }else{
            for(int c=cir;c<=n;c++) {
                if(c%cir!=0) continue;
                for (int i = 0; i < how; i++) {
                    int temp = a[c-1][0];
                    for (int j = 0; j < m - 1; j++) {
                        a[c-1][j] = a[c-1][j + 1];
                    }
                    a[c-1][m - 1] = temp;
                }
            }
        }
    }
    public static int[][] check(int[][] a){
        int[][] newa=new int[n][m];
        int total=0;
        int sum=0;
        boolean can=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int y=i;
                int x=j;
                if(a[y][x]==0) continue;
                boolean cans=true;
                for(int k=0;k<4;k++){
                    int nx=x+dx[k];
                    int ny=y+dy[k];
                    if(nx==-1&&(ny>=0&&ny<n)){
                        if(a[ny][m-1]==a[y][x]){
                            newa[ny][m-1]=newa[y][x]=0;
                            can=true;
                            cans=false;
                        }
                    }else if(nx==m&&(ny>=0&&ny<n)){
                        if(a[ny][0]==a[y][x]){
                            newa[ny][0]=newa[y][x]=0;
                            can=true;
                            cans=false;
                        }
                    }else if(ny<0||nx<0||ny>=n||nx>=m) continue;
                    else{
                        if(a[ny][nx]==a[y][x]){
                            newa[ny][nx]=newa[y][x]=0;
                            can=true;
                            cans=false;
                        }
                    }
                }
                if(cans){
                    newa[y][x]=a[y][x];
                    sum+=newa[y][x];
                    total++;
                }
            }
        }
        if(!can){
            float avg=(float) sum/(float) total;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(newa[i][j]!=0&&newa[i][j]>avg) newa[i][j]--;
                    else if(newa[i][j]!=0&&newa[i][j]<avg) newa[i][j]++;
                }
            }
        }
        return newa;
    }
}