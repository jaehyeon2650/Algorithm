import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static class Course {
        public int money;
        public int day;

        public Course(int money, int day) {
            this.money = money;
            this.day = day;
        }

    }
    // 돈 우선순위
    static class CoursePq implements Comparator<Course>{

        @Override
        public int compare(Course o1, Course o2) {
            return o2.money-o1.money;
        }
    }
    //시간 우선순위
    static class CourseTime implements  Comparator<Course>{

        @Override
        public int compare(Course o1, Course o2) {
            return o2.day-o1.day;
        }
    }
    public static int n;
    public static int maxDay=0;
    public static int total=0;
    public static PriorityQueue<Course> pqTime=new PriorityQueue<>(1,new CourseTime());
    public static PriorityQueue<Course> pq=new PriorityQueue<>(1,new CoursePq());
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(bf.readLine());
        for(int i=0;i<n;i++){
            String s=bf.readLine();
            String[] strings = s.split(" ");
            maxDay=Math.max(Integer.parseInt(strings[1]),maxDay);
            pqTime.add(new Course(Integer.parseInt(strings[0]),Integer.parseInt(strings[1])));
        }
        for(int i=maxDay;i>=1;i--){
            while(!pqTime.isEmpty()&&pqTime.peek().day==i) pq.add(pqTime.poll());
            if(!pq.isEmpty()){
                total+=pq.poll().money;
            }

        }
        System.out.println(total);
    }
}