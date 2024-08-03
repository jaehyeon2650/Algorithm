import javax.swing.*;
import java.util.*;

class Main {
    static class Jewerly implements Comparable<Jewerly>{
        public Long weight;
        public Long price;

        public Jewerly(Long weight, Long price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewerly o) {
            if(weight==o.weight){
                return (int) (o.price-price);
            }
            return (int)(weight-o.weight);
        }
    }
    public static int n;
    public static int m;
    public static Vector<Jewerly> v=new Vector<>();
    public static Vector<Long> bags=new Vector<>();
    public static PriorityQueue<Long> jew=new PriorityQueue<>(Comparator.reverseOrder());
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        for (int i = 0; i < n; i++) {
            Long a = scan.nextLong();
            Long b = scan.nextLong();
            v.add(new Jewerly(a, b));
        }
        for (int i = 0; i < m; i++) {
            Long a = scan.nextLong();
            bags.add(a);
        }
        Collections.sort(v);
        Collections.sort(bags);
        int j=0;
        Long ret=0L;
        for(int i=0;i<m;i++){
            while(j<n&&bags.get(i)>=v.get(j).weight){
                jew.add(v.get(j++).price);
            }
            if(!jew.isEmpty()){
                ret+=jew.poll();
            }
        }
        System.out.println(ret);
    }
}