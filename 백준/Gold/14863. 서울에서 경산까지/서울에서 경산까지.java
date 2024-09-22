import java.io.*;
import java.util.Collections;
import java.util.Vector;


public class Main {
    static class Pair implements Comparable<Pair>{
        public int time;
        public int money;

        public Pair(int time, int money) {
            this.time = time;
            this.money = money;
        }

        @Override
        public int compareTo(Pair o) {
            return time-o.time;
        }
    }
    public static int n;
    public static int k;
    public static int[] bikeTime;
    public static int[] bikeMoney;
    public static int[] walkTime;
    public static int[] walkMoney;
    public static Vector<Pair> v1=new Vector<>();
    public static Vector<Pair> v2=new Vector<>();
    public static Vector<Pair> v3=new Vector<>();
    public static Vector<Pair> v4=new Vector<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        String[] s1 = s.split(" ");
        n=Integer.parseInt(s1[0]);
        k=Integer.parseInt(s1[1]);
        bikeTime=new int[n];
        bikeMoney=new int[n];
        walkTime=new int[n];
        walkMoney=new int[n];
        for(int i=0;i<n;i++){
            s=br.readLine();
            s1=s.split(" ");
            bikeTime[i]=Integer.parseInt(s1[0]);
            bikeMoney[i]=Integer.parseInt(s1[1]);
            walkTime[i]=Integer.parseInt(s1[2]);
            walkMoney[i]=Integer.parseInt(s1[3]);
        }
        go(0,n/4-1,v1,0,0);
        go(n/4,n/2-1,v2,0,0);
        go(n/2,3*n/4-1,v3,0,0);
        go(3*n/4,n-1,v4,0,0);
        Collections.sort(v1);
        Collections.sort(v2);
        Collections.sort(v3);
        Collections.sort(v4);
        Vector<Pair> newv=new Vector<>();
        for(int i=0;i<v1.size();i++){
            Pair now=v1.get(i);
            int rest=k-now.time;
            int ind = find(v2, rest);
            for(int j=0;j<ind;j++){
                newv.add(new Pair(now.time+v2.get(j).time,now.money+v2.get(j).money));
            }
        }
        Collections.sort(newv);
        v1.clear();
        for(int i=0;i<newv.size();i++){
            Pair now=newv.get(i);
            int rest=k-now.time;
            int ind = find(v3, rest);
            for(int j=0;j<ind;j++){
                v1.add(new Pair(now.time+v3.get(j).time,now.money+v3.get(j).money));
            }
        }
        newv.clear();
        for(int i=0;i<v1.size();i++){
            Pair now=v1.get(i);
            int rest=k-now.time;
            int ind = find(v4, rest);
            for(int j=0;j<ind;j++){
                newv.add(new Pair(now.time+v4.get(j).time,now.money+v4.get(j).money));
            }
        }
        int maxn=0;
        for (Pair pair : newv) {
            maxn=Math.max(maxn,pair.money);
        }
        System.out.println(maxn);
    }
    public static int find(Vector<Pair> v,int num){
        int start=0;
        int end=v.size()-1;
        while(start<=end){
            int index=(start+end)/2;
            if(v.get(index).time<=num){
                start=index+1;
            }else{
                end=index-1;
            }
        }
        return start;
    }
    public static void go(int here,int end,Vector<Pair> v,int sumTime,int sumMoney){
        if(sumTime>k) return;
        if(here>end){
            v.add(new Pair(sumTime,sumMoney));
            return;
        }
        go(here+1,end,v,sumTime+bikeTime[here],sumMoney+bikeMoney[here]);
        go(here+1,end,v,sumTime+walkTime[here],sumMoney+walkMoney[here]);

    }
}
