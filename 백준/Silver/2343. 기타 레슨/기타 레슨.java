import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

class Main {

    public static int n;
    public static int m;
    public static int[] a;
    public static int sum=0;
    public static int maxn=Integer.MAX_VALUE;
    public static int minn=Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s=bf.readLine();
        String[] strings = s.split(" ");
        n=Integer.parseInt(strings[0]);
        m=Integer.parseInt(strings[1]);
        a=new int[n];
        s=bf.readLine();
        strings=s.split(" ");
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(strings[i]);
            sum+=a[i];
            minn=Math.max(minn,a[i]);
        }
        go(1,sum);
        System.out.println(maxn);
    }

    public static void go(int start,int end){

        while(start<=end){
            int index=(start+end)/2;
            int result=check(index);
            if(result==0){
                maxn=Math.min(maxn,index);
                end=index-1;
            }else {
                start=index+1;
            }
        }
    }

    public static int check(int index){
        if(minn>index) return 1;
        int temp=index;
        int cnt=0;
        for(int i=0;i<n;i++){
            if(index-a[i]<0){
                index=temp;
                cnt++;
            }
            index-=a[i];
        }
        if(index!=temp) cnt++;
        if(cnt<=m) return 0;
        return 1;
//        int total=0;
//        int sums=0;
//        for(int i=0;i<n;i++){
//            if(sums+a[i]<=index){
//                sums+=a[i];
//            }else{
//                sums= a[i];
//                total++;
//            }
//        }
//        if(sums!=index) total++;
//        if(total<=m) return 0;
//        return -1;
    }
}