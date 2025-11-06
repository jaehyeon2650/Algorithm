import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    static class Point implements Comparable<Point> {
        int num;
        int index;

        public Point(final int num, final int index) {
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(final Point o) {
            return num - o.num;
        }
    }

    private static int n;
    private static int[] dp;
    private static int[] arr;
    private static int[] result;
    private static List<Point> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        dp = new int[n];
        arr = new int[n];
        result = new int[n];
        Arrays.fill(result, -1);
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = 1;
        int maxIndex = 0;
        list.add(new Point(arr[0], 0));
        for (int i = 1; i < n; i++) {
            int num = arr[i];
            int index = Collections.binarySearch(list, new Point(num, i));
            if (index < 0) {
                index = -(index + 1);
            }
            if (index == list.size()) {
                dp[i] = dp[list.size() - 1] + 1;
                maxIndex = i;
                result[i] = list.get(index-1).index;
                list.add(new Point(num,i));
            }else{
                list.set(index,new Point(num,i));
                dp[i] = 1;
                if(index>0){
                    result[i] = list.get(index-1).index;
                    dp[i] = dp[index-1]+1;
                }
            }
        }
        Stack<Integer> stack =  new Stack<>();
        System.out.println(list.size());
        while(maxIndex!=-1){
            stack.add(arr[maxIndex]);
            maxIndex = result[maxIndex];
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }
        System.out.println(sb);
    }
}
