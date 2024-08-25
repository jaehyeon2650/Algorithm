import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

class Main {
    public static Long n;
    public static Long m;
    public static Long maxn=Long.MIN_VALUE;
    public static Long maxnPar=Long.MIN_VALUE;
    public static ArrayList<Long> arr=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        String[] strings = s.split(" ");
        n = Long.parseLong(strings[0]);
        m = Long.parseLong(strings[1]);
        for(int i=0;i<n;i++){
            Long a=Long.parseLong(bf.readLine());
            arr.add(a);
            maxn=Math.max(maxn,arr.get(i));
        }
        go(1L,maxn);
        Long sum=0L;
        int total=0;
        for(int i=0;i<n;i++){
            Long a=arr.get(i);
            while(total<m&&a>=maxnPar){
                a-=maxnPar;
                total++;
            }
            sum+=a;
        }
        System.out.println(sum);

    }
    public static void go(Long start,Long end){
        while(start<=end){
            Long index=(start+end)/2;
            if(check(index)){
                maxnPar=Math.max(maxnPar,index);
                start=index+1;
            }else{
                end=index-1;
            }
        }
    }
    public static boolean check(Long index){
        Long total=0L;
        for(int i=0;i<n;i++){
            Long par=arr.get(i);
            total+=par/index;
        }
        if(total>=m) return true;
        return false;
    }



}