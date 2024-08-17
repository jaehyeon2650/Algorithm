import java.io.*;
import java.util.*;

class Main {
    static class Point{
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int n;
    public static int[][] dragon=new int[101][101];
    public static int[] dx={-1,1,1,-1};
    public static int[] dy={1,1,-1,-1};
    public static int total=0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            String s = bf.readLine();
            String[] strings = s.split(" ");
            int x=Integer.parseInt(strings[0]);
            int y=Integer.parseInt(strings[1]);
            int d=Integer.parseInt(strings[2]);
            int dr=Integer.parseInt(strings[3]);
            Deque<Point> points=new ArrayDeque<>();
            Deque<Integer> direction=new ArrayDeque<>();
            points.addFirst(new Point(x,y));
            dragon[y][x]=1;
            int ny=y;
            int nx=x;
            if(d==0){
                nx++;
            }else if(d==1){
                ny--;
            }else if(d==2){
                nx--;
            }else{
                ny++;
            }
            if(ny<0||nx<0||ny>=101||nx>=101) continue;
            dragon[ny][nx]=1;
            Point newpoint= new Point(nx,ny);
            direction.add(check(points.getLast().x,points.getLast().y,newpoint));
            points.addLast(newpoint);
            dragonGo(points,direction,dr-1);
        }
        count();
        System.out.println(total);
    }
    public static void dragonGo(Deque<Point> points,Deque<Integer> direction,int num){
        if(num==-1) return;
        Deque<Point> newPoints=new ArrayDeque<>();
        Deque<Integer> newDirection=new ArrayDeque<>();
        Point endPoint=points.pollLast();
        newPoints.add(endPoint);
        int totalx=0;
        int totaly=0;
        int size=direction.size();
        for(int i=0;i<size;i++){
            Point p=points.pollLast();
            newPoints.addFirst(p);
            Integer in=direction.pollLast();
            newDirection.addFirst(in);
            totalx+=dx[in];
            totaly+=dy[in];
            int nx=p.x+totalx;
            int ny=p.y+totaly;
            if(ny<0||nx<0||ny>=101||nx>=101) continue;
            dragon[ny][nx]=1;
            Point newpoint=new Point(nx,ny);
            newDirection.addLast(check(newPoints.getLast().x,newPoints.getLast().y,newpoint));
            newPoints.addLast(newpoint);
        }
        dragonGo(newPoints,newDirection,num-1);
    }
    public static int check(int nx,int ny,Point now){
        int dxx=nx-now.x;
        int dyy=ny-now.y;
        if(dxx==1&&dyy==0) return 0;
        if(dxx==0&&dyy==-1) return 1;
        if(dxx==-1&&dyy==0) return 2;
        return 3;
    }
    public static void count(){
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(dragon[i][j]==1&&dragon[i+1][j]==1&&dragon[i][j+1]==1&&dragon[i+1][j+1]==1){
                    total++;
                }
            }
        }
    }
}