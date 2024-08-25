import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

class Main {
    public static Long n;
    public static Long m;
    public static Long maxn=Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        String[] strings = s.split(" ");
        n = Long.parseLong(strings[0]);
        m = Long.parseLong(strings[1]);
        go(1L,1000000001L,(m*100)/n);
        if(maxn==Long.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(maxn);
        }

    }
    public static void go(Long start,Long end,Long win){
        while(start<=end){
            Long index=(start+end)/2;
            if(((m+index)*100)/(n+index)>win){
                maxn=Math.min(maxn,index);
                end=index-1;
            }else{
                start=index+1;
            }
        }
    }


}