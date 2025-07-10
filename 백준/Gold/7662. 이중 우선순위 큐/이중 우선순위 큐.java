import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    private static int n;
    private static int t;
    private static TreeMap<Integer,Integer> maxHeap = new TreeMap<>(Collections.reverseOrder());
    private static TreeMap<Integer,Integer> minHeap = new TreeMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(bf.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(bf.readLine());
            maxHeap.clear();
            minHeap.clear();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                String input = st.nextToken();
                Integer value = Integer.parseInt(st.nextToken());
                if (input.equals("I")) {
                    maxHeap.put(value,maxHeap.getOrDefault(value,0)+1);
                    minHeap.put(value,minHeap.getOrDefault(value,0)+1);
                } else if (input.equals("D") && value == -1 && !minHeap.isEmpty()) {
                    Entry<Integer, Integer> min = minHeap.firstEntry();
                    Integer minValueCount = min.getValue();
                    minHeap.remove(min.getKey());
                    maxHeap.remove(min.getKey());
                    if(minValueCount!=1){
                        minHeap.put(min.getKey(),minValueCount-1);
                        maxHeap.put(min.getKey(),minValueCount-1);
                    }
                } else if (input.equals("D") && value == 1 && !maxHeap.isEmpty()) {
                    Entry<Integer, Integer> max = maxHeap.firstEntry();
                    Integer maxValueCount = max.getValue();
                    minHeap.remove(max.getKey());
                    maxHeap.remove(max.getKey());
                    if(maxValueCount!=1){
                        minHeap.put(max.getKey(),maxValueCount-1);
                        maxHeap.put(max.getKey(),maxValueCount-1);
                    }
                }
            }
            if (maxHeap.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(maxHeap.firstKey() + " " + minHeap.firstKey()+"\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();

    }

}
