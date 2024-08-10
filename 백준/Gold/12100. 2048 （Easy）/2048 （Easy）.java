import java.io.*;
import java.util.*;

class Main {
    public static int n;
    public static int maxn=Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(bf.readLine());
        int[][] a=new int[n][n];
        for(int i=0;i<n;i++){
            String s= bf.readLine();
            String[] strings = s.split(" ");
            for(int j=0;j<n;j++){
                a[i][j]=Integer.parseInt(strings[j]);
            }
        }
//        goUp(a);
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(a[i][j]+" ");
//            }
//            System.out.println();
//        }
        start(0,a);
        System.out.println(maxn);
    }
    public static void start(int many,int[][] a){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                maxn=Math.max(maxn,a[i][j]);
            }
        }
        if(many==5){
            return;
        }
        for(int i=0;i<4;i++){
            int[][] copy=new int[n][n];
            for(int j=0;j<n;j++){
                copy[j]=Arrays.copyOf(a[j],n);
            }
            if(i==0){
                goLeft(copy);
            }else if(i==1){
                goRight(copy);
            }else if(i==2){
                goDown(copy);
            }else{
                goUp(copy);
            }
            start(many+1,copy);
        }
    }
    public static void goRight(int[][] a){
        int[][] visited=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=n-1;j>=0;j--){
                int k=j;
                int next=k+1;
                boolean can=true;
                if(next==n||(a[i][next]!=a[i][j])&&(a[i][next]!=0)||visited[i][next]==1)can=false;
                while(can){
                    if (a[i][next] == 0) {
                        a[i][next] = a[i][k];
                    } else {
                        a[i][next] = a[i][k] * 2;
                        visited[i][next]=1;
                    }
                    a[i][k]=0;
                    k++;
                    next=k+1;
                    if(next==n||(a[i][next]!=a[i][k])&&(a[i][next]!=0)||visited[i][k]==1||visited[i][next]==1)can=false;
                }
            }
        }
    }
    public static void goLeft(int[][] a){
        int[][] visited=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int k=j;
                int next=k-1;
                boolean can=true;
                if(next==-1||(a[i][next]!=a[i][j])&&(a[i][next]!=0)||visited[i][next]==1||visited[i][j]==1) can=false;
                while(can){
                    if(a[i][next]==0){
                        a[i][next]=a[i][k];
                    }else{
                        a[i][next]=a[i][k]*2;
                        visited[i][next]=1;
                    }
                    a[i][k]=0;
                    k--;
                    next=k-1;
                    if(next==-1||(a[i][next]!=a[i][k])&&(a[i][next]!=0)||visited[i][k]==1||visited[i][next]==1) can=false;
                }
            }
        }
    }
    public static void goDown(int[][] a){
        int[][] visited=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=n-1;j>=0;j--){
                int k=j;
                int next=k+1;
                boolean can=true;
                if(next==n||(a[next][i]!=a[j][i])&&(a[next][i]!=0)||visited[j][i]==1||visited[next][i]==1) can=false;
                while(can){
                    if(a[next][i]==0){
                        a[next][i]=a[k][i];
                    }else{
                        a[next][i]=a[k][i]*2;
                        visited[next][i]=1;
                    }
                    a[k][i]=0;
                    k++;
                    next=k+1;
                    if(next==n||(a[next][i]!=a[k][i])&&(a[next][i]!=0)||visited[k][i]==1||visited[next][i]==1) can=false;
                }
            }
        }
    }
    public static void goUp(int[][] a){
        int[][] visited=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int k=j;
                int next=k-1;
                boolean can=true;
                if(next==-1||(a[next][i]!=a[j][i])&&(a[next][i]!=0)||visited[j][i]==1||visited[next][i]==1) can=false;
                while(can){
                    if(a[next][i]==0){
                        a[next][i]=a[k][i];
                    }else{
                        a[next][i]=a[k][i]*2;
                        visited[next][i]=1;
                    }
                    a[k][i]=0;
                    k--;
                    next=k-1;
                    if(next==-1||(a[next][i]!=a[k][i])&&(a[next][i]!=0)||visited[k][i]==1||visited[next][i]==1) can=false;
                }
            }
        }
    }
}