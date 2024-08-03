import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static class Line implements Comparable<Line>{
        public int start;
        public int end;

        @Override
        public int compareTo(Line o) {
            if(start==o.start){
                return end-o.end;
            }
            return start-o.start;
        }

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static Vector<Line> v=new Vector<>();
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        for(int i=0;i<n;i++){
            String s=bf.readLine();
            String[] strings = s.split(" ");
            int a=Integer.parseInt(strings[0]);
            int b=Integer.parseInt(strings[1]);
            v.add(new Line(a,b));
        }
        Collections.sort(v);
        int total=0;
        int start=v.get(0).start;
        int end=v.get(0).end;
        for(int i=1;i<n;i++){
            Line next=v.get(i);
            int nextStart=next.start;
            int nextEnd=next.end;
            if(nextStart>end){
                total+=(end-start);
                start=nextStart;
                end=nextEnd;
            }else if(nextStart>=start&&nextEnd>=end){
                end=nextEnd;
            }
        }
        System.out.println(total+(end-start));

    }
}