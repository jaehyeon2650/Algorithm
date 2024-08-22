import java.io.*;
import java.util.*;

class Main {

    public static int n;
    public static int[] a;
    public static int[] dp;
    public static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(bf.readLine());
        a=new int[n];
        dp=new int[n];
        result=new int[n];
        Arrays.fill(result,-1);
        String s=bf.readLine();
        String[] strings = s.split(" ");
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(strings[i]);
        }
        for(int i=0;i<n;i++){
            int minn=0;
            int minIndex=-1;
            for(int j=0;j<i;j++){
                if(a[i]>a[j]&&minn<=dp[j]){
                    minn=dp[j];
                    minIndex=j;
                }
            }
            if(minIndex!=-1){
                result[i]=minIndex;
            }
            dp[i]=minn+1;
        }
        int minn=Integer.MIN_VALUE;
        int index=0;
        for(int i=0;i<n;i++){
            if(minn<dp[i]){
                minn=dp[i];
                index=i;
            }
        }
        System.out.println(minn);
        ArrayList<Integer> arr=new ArrayList<>();
        while(index!=-1){
            arr.add(a[index]);
            index=result[index];
        }
        for(int i=arr.size()-1;i>=0;i--){
            System.out.print(arr.get(i)+" ");
        }

    }
}