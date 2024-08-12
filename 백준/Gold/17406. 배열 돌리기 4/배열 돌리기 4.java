import java.io.*;
import java.util.*;

class Main {
    public static int n;
    public static int m;
    public static int k;
    public static int[][] array;
    public static int minn=Integer.MAX_VALUE;
    static class Three{
        public int a;
        public int b;
        public int c;

        public Three(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    public static Vector<Three> ro=new Vector<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String s=bf.readLine();
        String[] strings = s.split(" ");
        n=Integer.parseInt(strings[0]);
        m=Integer.parseInt(strings[1]);
        array=new int[n][m];
        k=Integer.parseInt(strings[2]);
        for(int i=0;i<n;i++){
            s=bf.readLine();
            String[] strings1 = s.split(" ");
            for(int j=0;j<m;j++){
                array[i][j]=Integer.parseInt(strings1[j]);
            }
        }
        for(int i=0;i<k;i++){
            s= bf.readLine();
            String[] strings1 = s.split(" ");
            int a=Integer.parseInt(strings1[0]);
            int b=Integer.parseInt(strings1[1]);
            int c=Integer.parseInt(strings1[2]);
            ro.add(new Three(a,b,c));
        }
        Vector<Integer> v=new Vector<>();
        int[] visited=new int[k];
        make(v,visited);
        System.out.println(minn);
    }
    public static void rotate(int a,int b,int c,int[][] copy){
        if(c==0) return;
        int temp=copy[a-c-1][b+c-1];
        for(int i=b+c-1;i>b-c-1;i--){
            copy[a-c-1][i]=copy[a-c-1][i-1];
        }
        for(int i=a-c-1;i<a+c-1;i++){
            copy[i][b-c-1]=copy[i+1][b-c-1];
        }
        for(int i=b-c-1;i<b+c-1;i++){
            copy[a+c-1][i]=copy[a+c-1][i+1];
        }
        for(int i=a+c-1;i>a-c;i--){
            copy[i][b+c-1]=copy[i-1][b+c-1];
        }
        copy[a-c][b+c-1]=temp;
        rotate(a,b,c-1,copy);
    }
    public static void make(Vector<Integer> v,int[] visited){
        if(v.size()==k){
            int[][] copy=new int[n][m];
            for(int i=0;i<n;i++){
                copy[i]=Arrays.copyOf(array[i],m);
            }
            for(int s:v){
                rotate(ro.get(s).a,ro.get(s).b,ro.get(s).c,copy);
            }
            for(int i=0;i<n;i++){
                int sum=0;
                for(int j=0;j<m;j++){
                    sum+=copy[i][j];
                }
                minn=Math.min(minn,sum);
            }
            return;
        }
        for(int i=0;i<k;i++){
            if(visited[i]==0){
                visited[i]=1;
                v.add(i);
                make(v,visited);
                v.remove(v.size()-1);
                visited[i]=0;
            }
        }
    }

}