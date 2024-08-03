import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static int n;
    public static Vector<Float> v=new Vector<>();
    public static PriorityQueue<Float> grade=new PriorityQueue<>(Comparator.reverseOrder());
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        for(int i=0;i<n;i++){
            float a=Float.parseFloat(bf.readLine());
            if(grade.size()==7){
                grade.add(a);
                grade.poll();
            }else{
                grade.add(a);
            }
        }

        for(int i=0;i<7;i++){
            v.add(grade.poll());
        }
        Collections.sort(v);
        for(Float f:v){
            System.out.printf("%.3f%n",f);
        }

    }
}