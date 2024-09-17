import java.io.*;
import java.util.*;

public class Main {
    static class Pair{
        public int a,b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a && b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
    public static int n;
    public static int m;
    public static int a;
    public static int b;
    public static Map<Pair,Integer> visited=new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] s1 = s.split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);
        a = Integer.parseInt(s1[2]);
        b = Integer.parseInt(s1[3]);
        System.out.println(dfs(0,0));
    }
    public static void go(int nowA,int nowB,Queue<Pair> q,int d){
        Integer i = visited.get(new Pair(nowA, nowB));
        if(i!=null) return;
        visited.put(new Pair(nowA,nowB),d+1);
        q.add(new Pair(nowA,nowB));
    }

    public static int dfs(int nowA,int nowB){
        Queue<Pair> q=new ArrayDeque<>();
        q.add(new Pair(nowA,nowB));
        visited.put(new Pair(nowA,nowB),1);
        while (!q.isEmpty()){
            int x=q.peek().a;
            int y=q.peek().b;
            Integer i = visited.get(new Pair(x, y));
            q.poll();
            go(n,y,q,i);
            go(x,m,q,i);
            go(0,y,q,i);
            go(x,0,q,i);
            go(Math.min(x+y,n),Math.max(0,x+y-n),q,i);
            go(Math.max(0,x+y-m),Math.min(x+y,m),q,i);
        }
        Integer result = visited.get(new Pair(a, b));
        if(result!=null) return result-1;
        else return -1;
    }
}
