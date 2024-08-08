import java.io.*;
import java.util.*;

class Main {
    static class Pair{
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static Pair airCleaner;
    public static Vector<Pair> dusts=new Vector<>();
    public static int n;
    public static int m;
    public static int t;
    public static int[][] a;
    public static int[][] visited;
    public static int[] dx={-1,0,1,0};
    public static int[] dy={0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String s=bf.readLine();
        String[] strings = s.split(" ");
        n=Integer.parseInt(strings[0]);
        m=Integer.parseInt(strings[1]);
        t=Integer.parseInt(strings[2]);
        a=new int[n][m];
        visited=new int[n][m];
        for(int i=0;i<n;i++){
            s= bf.readLine();
            String[] strings1 = s.split(" ");
            for(int j=0;j<m;j++){
                a[i][j]=Integer.parseInt(strings1[j]);
                if(a[i][j]==-1&&airCleaner==null){
                    airCleaner=new Pair(i,j);
                }else if(a[i][j]>0){
                    dusts.add(new Pair(i,j));
                }
            }
        }
        for(int i=0;i<t;i++){
            splash();
            cleanAir1();
            cleanAir2();
            vectorClear();
        }
        calculate();

    }
    public static void cleanAir1(){
        int temp=0;
        int next=0;
        for(int i=1;i<m-1;i++){
            temp=next;
            next=a[airCleaner.y][i];
            a[airCleaner.y][i]=temp;
        }
        for(int i= airCleaner.y;i>=1;i--){
            temp=next;
            next=a[i][m-1];
            a[i][m-1]=temp;
        }
        for(int i=m-1;i>=1;i--){
            temp=next;
            next=a[0][i];
            a[0][i]=temp;
        }
        for(int i=0;i<= airCleaner.y-1;i++){
            temp=next;
            next=a[i][0];
            a[i][0]=temp;
        }
    }
    public static void cleanAir2(){
        int temp=0;
        int next=0;
        for(int i=1;i<m-1;i++){
            temp=next;
            next=a[airCleaner.y+1][i];
            a[airCleaner.y+1][i]=temp;
        }
        for(int i= airCleaner.y+1;i<n-1;i++){
            temp=next;
            next=a[i][m-1];
            a[i][m-1]=temp;
        }
        for(int i=m-1;i>=1;i--){
            temp=next;
            next=a[n-1][i];
            a[n-1][i]=temp;
        }
        for(int i=n-1;i>airCleaner.y+1;i--){
            temp=next;
            next=a[i][0];
            a[i][0]=temp;
        }
    }
    public static void splash(){
        int[][] nextA=new int[n][m];
        for(Pair p:dusts){
            if(visited[p.y][p.x]==0){
                dustGo(p.y,p.x,nextA);
            }
        }

        a=nextA;
    }
    public static void dustGo(int y,int x,int[][] nextA){
        visited[y][x]=1;
        int count=0;
        for(int i=0;i<4;i++){
            int ny=y+dy[i];
            int nx=x+dx[i];
            if(ny<0||nx<0||ny>=n||nx>=m||(nx== airCleaner.x&&ny== airCleaner.y)||(nx==airCleaner.x&&ny== airCleaner.y+1)) continue;
            nextA[ny][nx]+=(a[y][x]/5);
            count++;
        }
        nextA[y][x]+=a[y][x]-((a[y][x]/5)*count);
    }

    public static void vectorClear(){
        dusts.clear();
        for(int i=0;i<n;i++){
            Arrays.fill(visited[i],0);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]>0){
                    dusts.add(new Pair(i,j));
                }
            }
        }
    }
    public static void calculate(){
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]>0){
                    sum+=a[i][j];
                }
            }
        }
        System.out.println(sum);
    }
}