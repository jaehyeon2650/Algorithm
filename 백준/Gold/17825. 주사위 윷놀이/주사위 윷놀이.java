import java.io.*;
import java.util.*;

class Main {
    public static Map[] m=new Map[44];
    static class Mal{
        public int index;
        public int location;
        public boolean in=false;

        public Mal(int index, int location) {
            this.index = index;
            this.location = location;
        }
    }
    static class Map{
        public int next;
        public int score;

        public Map(int next, int score) {
            this.next = next;
            this.score = score;
        }
    }
    public static Vector<Mal> mals=new Vector<>();
    public static int[] visited=new int[44];
    public static int[] a=new int[10];
    public static int maxn=Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);
        for(int i=0;i<4;i++){
            mals.add(new Mal(i,0));
        }
        for(int i=0;i<10;i++){
            a[i]=scan.nextInt();
        }
        makeMap();
//        int cur=40;
//        for(int j=0;j<4;j++){
//            if(j==0&&(cur==10||cur==20||cur==30)){
//                cur=cur+1;
//            }else{
//                cur=m[cur].next;
//            }
//            if(cur==42) break;
//        }
//        System.out.println(cur);
        goMal(0,0);
        System.out.println(maxn);
    }
    public static void makeMap(){
        //42는 도착
        for(int i=0;i<42;i+=2){
            m[i]=new Map(i+2,i);
        }
        m[11]=new Map(13,13);m[13]=new Map(15,16);m[15]=new Map(37,19);
        m[21]=new Map(23,22);m[23]=new Map(37,24);
        m[31]=new Map(33,28);m[33]=new Map(35,27);m[35]=new Map(37,26);
        m[37]=new Map(39,25);m[39]=new Map(41,30);m[41]=new Map(40,35);
    }

    public static void goMal(int index,int total){
        if(index==10){
            maxn=Math.max(total,maxn);
            return;
        }
        for(int i=0;i<4;i++){
            int before=mals.get(i).location;
            int cur=before;
            if(cur==42) continue;
            for(int j=0;j<a[index];j++){
                if(j==0&&(cur==10||cur==20||cur==30)){
                    cur=cur+1;
                }else{
                    cur=m[cur].next;
                }
                if(cur==42) break;
            }
            if(cur!=42&&visited[cur]==0){
                visited[cur]=1;
                visited[before]=0;
                mals.get(i).location=cur;
                goMal(index+1,total+m[cur].score);
                visited[cur]=0;
                visited[before]=1;
                mals.get(i).location=before;
            }else if(cur==42){
                mals.get(i).location=cur;
                visited[before]=0;
                goMal(index+1,total);
                mals.get(i).location=before;
                visited[before]=1;
            }
        }
    }
}