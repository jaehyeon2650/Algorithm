import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    private static int a;
    private static int b;
    private static int targetA;
    private static int targetB;

    private static Map<Pair, Integer> result = new HashMap<>();

    static class Pair{
        int x;
        int y;

        public Pair(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            final Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        a= Integer.parseInt(st.nextToken());
        b= Integer.parseInt(st.nextToken());
        targetA= Integer.parseInt(st.nextToken());
        targetB= Integer.parseInt(st.nextToken());

        System.out.println(bfs(0,0));
    }

    private static int bfs(int x, int y){
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(x,y));
        result.put(new Pair(x,y),0);
        while(!queue.isEmpty()){
            Pair poll = queue.poll();
            int nowX = poll.x;
            int nowY = poll.y;
            int now = result.get(poll);
            go(0,nowY,queue,now);
            go(nowX,0,queue,now);
            go(a,nowY,queue,now);
            go(nowX,b,queue,now);
            go(nowX-Math.min(b-nowY,nowX),Math.min(nowX+nowY,b),queue,now);
            go(Math.min(nowX+nowY,a),nowY-Math.min(a-nowX,nowY),queue,now);
        }
        Integer minn = result.getOrDefault(new Pair(targetA, targetB), null);
        if(minn==null) return -1;
        return minn;
    }

    private static void go(int x,int y, Queue<Pair> queue, int now){
        Integer find = result.getOrDefault(new Pair(x, y), null);
        if(find!=null) return;
        result.put(new Pair(x,y),now+1);
        queue.add(new Pair(x,y));
    }


}
