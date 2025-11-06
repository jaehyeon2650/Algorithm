import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    private static int n;
    private static int[] dp;
    private static int[] arr;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        dp = new int[n];
        arr = new int[n];
        result = new int[n];
        Arrays.fill(result,-1);
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0]=1;
        int maxn = 1;
        int maxIndex = 0;
        for(int i=1;i<n;i++){
            int num = arr[i];
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(arr[j]<num){
                    if(dp[i]<dp[j]+1){
                        result[i] = j;
                        dp[i] = dp[j]+1;
                        if(maxn<dp[i]){
                            maxn = dp[i];
                            maxIndex=i;
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Stack<Integer> results = new Stack<>();
        System.out.println(maxn);
        while(maxIndex!=-1){
            results.add(arr[maxIndex]);
            maxIndex = result[maxIndex];
        }
        while(!results.isEmpty()){
            sb.append(results.pop()+" ");
        }
        System.out.println(sb);
    }
}
