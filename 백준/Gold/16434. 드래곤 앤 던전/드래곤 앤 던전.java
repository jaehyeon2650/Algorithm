import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

class Main {
    public static int t;
    public static int n;
    public static int m;

    static class Room{
        public Long a;
        public Long b;
        public Long c;

        public Room(Long a, Long b, Long c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    public static Long maxn=Long.MIN_VALUE;
    public static Long answer=Long.MAX_VALUE;
    public static ArrayList<Room> rooms=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        String[] strings = s.split(" ");
        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);
        for(int i=0;i<n;i++){
            s= bf.readLine();
            strings=s.split(" ");
            Long a=Long.parseLong(strings[0]);
            Long b=Long.parseLong(strings[1]);
            Long c=Long.parseLong(strings[2]);
            rooms.add(new Room(a,b,c));
        }
        go(1L,Long.MAX_VALUE);
        System.out.println(answer);

    }
    public static void go(Long start,Long end){
        while(start<=end){
            Long index=(start+end)/2;
            if(check(index)){
                answer=Math.min(answer,index);
                end=index-1;
            }else{
                start=index+1;
            }
        }
    }
    public static boolean check(Long index){
        Long level=(long) m;
        Long hp=index;
        for(int i=0;i<n;i++){
            Room cur=rooms.get(i);
            if(cur.a==1){
                Long check=(cur.c / level) *cur.b;
                if(cur.c%level==0) check-=cur.b;
                hp-=check;
                if(hp<=0) return false;
            }else{
                level+=cur.b;
                if(hp+cur.c>=index) hp=index;
                else hp+=cur.c;
            }
        }
        return true;
    }
}