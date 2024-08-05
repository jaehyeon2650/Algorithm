import java.io.*;
import java.util.*;

class Main {
    static class Cup implements Comparable<Cup>{
        public int cup;
        public int dead;

        public Cup(int cup, int dead) {
            this.cup = cup;
            this.dead = dead;
        }

        @Override
        public int compareTo(Cup o) {
            return dead-o.dead;
        }
    }
    public static Vector<Cup> v=new Vector<>();
    public static int n;
    public static int maxn=0;
    public static int total=0;
    public static PriorityQueue<Cup> pqCup=new PriorityQueue<>();
    public static PriorityQueue<Integer> pq=new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.valueOf(bf.readLine());
        for(int i=0;i<n;i++){
            String s=bf.readLine();
            String[] strings = s.split(" ");
            maxn=Math.max(maxn,Integer.parseInt(strings[0]));
            pqCup.add(new Cup(Integer.parseInt(strings[1]),Integer.parseInt(strings[0])));
        }
        Collections.sort(v);
        for(int i=1;i<=maxn;i++){
            while(!pqCup.isEmpty()&&pqCup.peek().dead==i){
                pq.add(pqCup.poll().cup);
            }
            while(pq.size()>i){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            total+=pq.poll();
        }
        System.out.println(total);
    }
}