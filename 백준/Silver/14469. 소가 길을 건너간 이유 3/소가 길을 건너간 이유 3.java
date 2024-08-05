import java.io.*;
import java.util.*;

class Main {
    static class Cow implements Comparable<Cow>{
        public int come;
        public int wait;

        public Cow(int come, int wait) {
            this.come= come;
            this.wait = wait;
        }

        @Override
        public int compareTo(Cow o) {
            return come-o.come;
        }
    }
    public static int n;
    public static int total=0;
    public static PriorityQueue<Cow> pqCow=new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.valueOf(bf.readLine());
        for(int i=0;i<n;i++){
            String s=bf.readLine();
            String[] strings = s.split(" ");
            pqCow.add(new Cow(Integer.parseInt(strings[0]),Integer.parseInt(strings[1])));
        }
        while(!pqCow.isEmpty()){
            Cow current=pqCow.poll();
            if(current.come>=total){
                total=current.come+current.wait;
            }else{
                total+= current.wait;
            }
        }
        System.out.println(total);
    }
}