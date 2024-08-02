import java.util.*;

class Main {
    static class Time implements Comparable<Time>{
        public Long start;
        public Long end;

        public Time(Long start, Long end) {
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(Time o) {
            if(end==o.end){
                return (int) (start-o.start);
            }else{
                return (int) (end-o.end);
            }
        }
    }
    public static Vector<Time> v=new Vector<>();
    public static int n;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        for(int i=0;i<n;i++){
            Long a=scan.nextLong();
            Long b=scan.nextLong();
            v.add(new Time(a,b));
        }
        Collections.sort(v);
        int ret=0;
        Long end=0L;
        for(Time t:v){
            if(end<=t.start){
                ret++;
                end=t.end;
            }
        }
        System.out.println(ret);
    }
}