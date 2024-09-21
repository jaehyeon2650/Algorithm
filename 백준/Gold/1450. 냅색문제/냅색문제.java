import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;


public class Main {
    public static int n;
    public static int c;
    public static int[] a;
    public static Long sum=0L;
    public static Vector<Integer> v1=new Vector<>();
    public static Vector<Integer> v2=new Vector<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        String[] s1 = s.split(" ");
        n=Integer.parseInt(s1[0]);
        c=Integer.parseInt(s1[1]);
        a=new int[n];
        s=br.readLine();
        s1=s.split(" ");
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(s1[i]);
        }
        go(0,n/2-1,v1,0);
        go(n/2,n-1,v2,0);
        Collections.sort(v1);
        Collections.sort(v2);
        for(int i=0;i<v2.size();i++){
            int b=v2.get(i);
            int rest=c-b;
            int total = find(v1, rest);
            sum+=total;
        }
        System.out.println(sum);
    }

    public static void go(int here,int end,Vector<Integer> v,int sum){
        if(sum>c) return;
        if(here>end){
            v.add(sum);
            return;
        }
        go(here+1,end,v,sum);
        go(here+1,end,v,sum+a[here]);
    }

    public static int find(Vector<Integer> v,int num){
        int start=0;
        int end=v.size()-1;
        while(start<=end){
            int index=(start+end)/2;
            if(v.get(index)<=num) start=index+1;
            else end=index-1;
        }
        return start;
    }
}
