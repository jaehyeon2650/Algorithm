import java.io.*;
import java.util.*;

public class Main {
    static class Mal{
        public int y;
        public int x;
        public int direction;
        public Mal(int y, int x, int direction) {
            this.y = y;
            this.x = x;
            this.direction = direction;
        }
    }
    public static int num=0;
    public static boolean can=false;
    public static int[] dx={1,-1,0,0};
    public static int[] dy={0,0,-1,1};
    public static int n;
    public static int k;
    public static int[][] map;
    public static Vector<Integer>[][] mals;
    public static Vector<Mal> v=new Vector<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        String[] s1 = s.split(" ");
        n=Integer.parseInt(s1[0]);
        k=Integer.parseInt(s1[1]);
        map=new int[n+1][n+1];
        mals=new Vector[n+1][n+1];
        for(int i=1;i<=n;i++){
            s=br.readLine();
            s1=s.split(" ");
            for(int j=0;j<n;j++){
                map[i][j+1]=Integer.parseInt(s1[j]);
            }
        }
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                mals[i][j]=new Vector<>();
            }
        }
        for(int i=1;i<=k;i++){
            s=br.readLine();
            s1=s.split(" ");
            v.add(new Mal(Integer.parseInt(s1[0]),Integer.parseInt(s1[1]),Integer.parseInt(s1[2])));
            mals[Integer.parseInt(s1[0])][Integer.parseInt(s1[1])].add(i);
        }
        go(0);
        if(can) System.out.println(num);
        else System.out.println(-1);
    }

    public static void go(int cnt){
        if(can){
            num=cnt;
            return;
        }
        if(cnt>1000) return;
        for(int i=0;i<v.size();i++){
            Mal cur=v.get(i);
            int result = check(cur.y, cur.x, cur.direction);
            if(result==0){
                goWhite(cur,i);
            }else if(result==1){
                goRed(cur,i);
            }else{
                if(cur.direction==1) cur.direction=2;
                else if(cur.direction==2) cur.direction=1;
                else if(cur.direction==3) cur.direction=4;
                else if(cur.direction==4) cur.direction=3;
                int check = check(cur.y, cur.x, cur.direction);
                if(check==1) goRed(cur,i);
                else if(check==0) goWhite(cur,i);
            }
            if(can) break;
        }
        go(cnt+1);
    }

    public static int check(int y,int x,int direction){
        int ny=y+dy[direction-1];
        int nx=x+dx[direction-1];
        if(ny<=0||nx<=0||ny>n||nx>n||map[ny][nx]==2) return 2;
        else return map[ny][nx];
    }

    public static void goWhite(Mal cur,int i){
        int ind = mals[cur.y][cur.x].indexOf(i + 1);
        Vector<Integer> newv=new Vector<>();
        Vector<Integer> move=new Vector<>();
        for(int j=0;j<=ind;j++){
            move.add(mals[cur.y][cur.x].get(j));
        }
       for(int j=ind+1;j<mals[cur.y][cur.x].size();j++){
           newv.add(mals[cur.y][cur.x].get(j));
       }
       mals[cur.y][cur.x]=newv;
        cur.y=cur.y+dy[cur.direction-1];
        cur.x=cur.x+dx[cur.direction-1];
        for(int j=0;j<move.size();j++){
            Integer i1 = move.get(j);
            Mal mal = v.get(i1-1);
            mal.y=cur.y;
            mal.x=cur.x;
        }
        for(int j=0;j<mals[cur.y][cur.x].size();j++){
            move.add(mals[cur.y][cur.x].get(j));
        }
        mals[cur.y][cur.x]=move;
        if(mals[cur.y][cur.x].size()>=4){
            can=true;
            return;
        }
    }

    public static void goRed(Mal cur,int i){
        int ind = mals[cur.y][cur.x].indexOf(i + 1);
        Vector<Integer> newv=new Vector<>();
        Vector<Integer> move=new Vector<>();
        for(int j=0;j<=ind;j++){
            move.add(mals[cur.y][cur.x].get(j));
        }
        for(int j=ind+1;j<mals[cur.y][cur.x].size();j++){
            newv.add(mals[cur.y][cur.x].get(j));
        }
        Collections.reverse(move);
        mals[cur.y][cur.x]=newv;
        cur.y=cur.y+dy[cur.direction-1];
        cur.x=cur.x+dx[cur.direction-1];
        for(int j=0;j<move.size();j++){
            Integer i1 = move.get(j);
            Mal mal = v.get(i1-1);
            mal.y=cur.y;
            mal.x=cur.x;
        }
        for(int j=0;j<mals[cur.y][cur.x].size();j++){
            move.add(mals[cur.y][cur.x].get(j));
        }
        mals[cur.y][cur.x]=move;
        if(mals[cur.y][cur.x].size()>=4){
            can=true;
            return;
        }
    }
}
