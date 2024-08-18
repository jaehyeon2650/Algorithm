import java.io.*;
import java.util.*;

class Main {
    public static int k;
    public static int n;
    public static int m;
    public static int[] a=new int[1001];
    public static int[] b=new int[1001];
    public static int[] psum_a=new int[2002];
    public static int[] psum_b=new int[2002];
    public static int total=0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        k=Integer.parseInt(bf.readLine());
        String s=bf.readLine();
        String[] strings = s.split(" ");
        n=Integer.parseInt(strings[0]);
        m=Integer.parseInt(strings[1]);
        for(int i=1;i<=n;i++){
            a[i]=Integer.parseInt(bf.readLine());
            psum_a[i]=psum_a[i-1]+a[i];
        }
        for(int i=n+1;i<=2*n;i++){
            psum_a[i]=psum_a[i-1]+a[i-n];
        }
        for(int i=1;i<=m;i++){
            b[i]=Integer.parseInt(bf.readLine());
            psum_b[i]=psum_b[i-1]+b[i];
        }
        for(int i=m+1;i<=2*m;i++){
            psum_b[i]=psum_b[i-1]+b[i-m];
        }
        Map<Integer,Integer> mapA=new HashMap<>();
        Map<Integer,Integer> mapB=new HashMap<>();
        make(n,psum_a,mapA);
        make(m,psum_b,mapB);
        int ret=mapA.getOrDefault(k,0)+mapB.getOrDefault(k,0);
        for(int i=1;i<k;i++){
            ret+=(mapA.getOrDefault(i,0)*mapB.getOrDefault(k-i,0));
        }
        System.out.println(ret);
    }
    public static void make(int n,int[] psum,Map<Integer,Integer> map){
        for(int inter=1;inter<=n;inter++){
            for(int start=inter;start<=n+inter-1;start++){
                int sum=psum[start]-psum[start-inter];
                map.put(sum,map.getOrDefault(sum,0)+1);
                if(inter==n) break;
            }
        }
    }
}