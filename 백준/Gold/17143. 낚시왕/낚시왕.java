import java.io.*;
import java.util.*;

class Main {
    static class Shark{
        public int y;
        public int x;
        public int fast;
        public int direction;
        public int size;
        public int index;
        public boolean catched=false;
        public Shark(int y, int x, int fast, int direction, int size,int index) {
            this.y = y;
            this.x = x;
            this.fast = fast;
            this.direction = direction;
            this.size = size;
            this.index=index;
        }
    }
    public static int n;
    public static int m;
    public static int k;
    public static int[][] a;
    public static int total=0;
    public static Vector<Shark> v=new Vector<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        String s=bf.readLine();
        String[] strings = s.split(" ");
        n=Integer.parseInt(strings[0]);
        m=Integer.parseInt(strings[1]);
        k=Integer.parseInt(strings[2]);
        a=new int[n+1][m+1];
        for(int i=0;i<k;i++){
            s=bf.readLine();
            String[] strings1 = s.split(" ");
            v.add(new Shark(Integer.parseInt(strings1[0]),Integer.parseInt(strings1[1]),Integer.parseInt(strings1[2]),Integer.parseInt(strings1[3]),Integer.parseInt(strings1[4]),i));
            a[v.get(i).y][v.get(i).x]=v.get(i).size;
        }

        for(int i=1;i<=m;i++){
            catchShark(i);
            int[][] copy=new int[n+1][m+1];
            for(Shark shark:v){
                if(shark.catched) continue;
                if(shark.direction==1||shark.direction==2){
                    sharkMoveUpDown(shark,copy);
                }else{
                    sharkMoveLeftRight(shark,copy);
                }
            }
            for(int j=0;j<=n;j++){
                a[j]=Arrays.copyOf(copy[j],m+1);
            }
        }
        System.out.println(total);
    }

    public static void sharkMoveUpDown(Shark shark,int[][] copy){
        int before= shark.y;
        for(int i=0;i<shark.fast;i++){
            if(shark.direction==1){
                int nexty=shark.y-1;
                if(nexty==0){
                    shark.direction=2;
                    shark.y= shark.y+1;
                }else{
                    shark.y=nexty;
                }
            }else if(shark.direction==2){
                int nexty= shark.y+1;
                if(nexty==n+1){
                    shark.direction=1;
                    shark.y=shark.y-1;
                }else{
                    shark.y=nexty;
                }
            }
        }
        if(copy[shark.y][shark.x]>0){
            if(copy[shark.y][shark.x]<shark.size){
                for(Shark shark1:v){
                    if(shark1.size==copy[shark.y][shark.x]){
                        shark1.catched=true;
                        break;
                    }
                }
                copy[shark.y][shark.x]=shark.size;
            }else{
                for(Shark shark1:v){
                    if(shark1.size==shark.size){
                        shark1.catched=true;
                        break;
                    }
                }
            }
        }else{
            copy[shark.y][shark.x]=shark.size;
        }
    }
    public static void sharkMoveLeftRight(Shark shark,int[][] copy){
        int before= shark.x;
        for(int i=0;i<shark.fast;i++){
            if(shark.direction==3){
                int nextx=shark.x+1;
                if(nextx==m+1){
                    shark.direction=4;
                    shark.x= shark.x-1;
                }else{
                    shark.x=nextx;
                }
            }else if(shark.direction==4){
                int nextx= shark.x-1;
                if(nextx==0){
                    shark.direction=3;
                    shark.x=shark.x+1;
                }else{
                    shark.x=nextx;
                }
            }
        }
        if(copy[shark.y][shark.x]>0){
            if(copy[shark.y][shark.x]<shark.size){
                for(Shark shark1:v){
                    if(shark1.size==copy[shark.y][shark.x]){
                        shark1.catched=true;
                        break;
                    }
                }
                copy[shark.y][shark.x]=shark.size;
            }else{
                for(Shark shark1:v){
                    if(shark1.size==shark.size){
                        shark1.catched=true;
                        break;
                    }
                }
            }
        }else{
            copy[shark.y][shark.x]=shark.size;
        }
    }
    public static void catchShark(int x){
        boolean catchs=false;
        for(int i=1;i<=n;i++){
            if(a[i][x]>0){
                for(Shark shark:v){
                    if(shark.size==a[i][x]){
                        shark.catched=true;
                        total+=shark.size;
                        a[i][x]=0;
                        catchs=true;
                        break;
                    }
                }
            }
            if(catchs) break;
        }
    }
}