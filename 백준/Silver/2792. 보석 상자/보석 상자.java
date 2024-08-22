import java.io.*;
import java.util.*;

class Main {

    public static int n;
    public static int m;
    public static int[] a;
    public static int maxn=Integer.MIN_VALUE;
    public static int minn=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s=bf.readLine();
        String[] strings = s.split(" ");
        n=Integer.parseInt(strings[0]);
        m=Integer.parseInt(strings[1]);
        a=new int[m];
        for(int i=0;i<m;i++){
            a[i]=Integer.parseInt(bf.readLine());
            maxn=Math.max(a[i],maxn);
        }
        can(1,maxn);
        System.out.println(minn);
    }
    public static void can(int start,int end){
        int index=0;
        while(start<=end){
            index=(start+end)/2;
            if(check(index)){
                minn=Math.min(minn,index);
                end=index-1;
            }
            else start=index+1;
        }
    }
    public static boolean check(int index){
        int sum=0;
        for(int i=0;i<m;i++){
            sum+=(a[i]/index);
            if(a[i]%index!=0) sum++;
        }
        return n>=sum;
    }
}