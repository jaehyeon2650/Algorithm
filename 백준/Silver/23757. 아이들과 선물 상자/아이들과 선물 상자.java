import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static Queue<Integer> gift = new PriorityQueue<>(Collections.reverseOrder());
    private static Queue<Integer> children = new ArrayDeque<>();


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            gift.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++) {
            children.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0;i<m;i++){
            Integer top = gift.poll();
            Integer want = children.poll();
            if(top==null || top<want){
                System.out.println(0);
                return;
            }
            if(top.equals(want)) continue;
            top -=want;
            gift.add(top);
        }
        System.out.println(1);
    }

}
