import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

class Main {

    public static int n;
    public static int m;

    public static int[] a;
    public static int sum=0;
    public static int maxn=Integer.MAX_VALUE;
    public static int maxMoney=0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s=bf.readLine();
        String[] strings = s.split(" ");
        n=Integer.parseInt(strings[0]);
        m=Integer.parseInt(strings[1]);
        a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(bf.readLine());
            sum+=a[i];
            maxMoney=Math.max(maxMoney,a[i]);
        }
        go(maxMoney,sum);
        System.out.println(maxn);
    }
    public static void go(int start,int end){
        while(start<=end){
            int index=(start+end)/2;
            if(check(index)) end=index-1;
            else start=index+1;
        }
    }
    public static boolean check(int index){
        int temp=index;
        int total=1;
        for(int i=0;i<n;i++){
            if(temp-a[i]>=0) temp-=a[i];
            else{
                total++;
                temp=index;
                temp-=a[i];
            }
        }
        if(total<=m){
            maxn=Math.min(maxn,index);
            return true;
        }
        return false;
    }
}