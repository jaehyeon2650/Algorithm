import java.io.*;
import java.util.*;

class Main {
    public static int[][] a;
    public static int n;
    public static int minn=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(bf.readLine());
        a=new int[n][n];
        for(int i=0;i<n;i++){
            String s=bf.readLine();
            String[] strings = s.split(" ");
            for(int j=0;j<n;j++){
                a[i][j]=Integer.parseInt(strings[j]);
            }
        }
        Set<Integer> set=new HashSet<>();
        go(set,1);
        System.out.println(minn);
    }

    public static void go(Set<Integer> set,int next){
        if(set.size()==(n/2)){
            int sum=0;
            int sum2=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(set.contains(i+1)&&set.contains(j+1)){
                        sum+=a[i][j];
                    }else if(!set.contains(i+1)&&!set.contains(j+1)){
                        sum2+=a[i][j];
                    }
                }
            }
            minn=Math.min(minn,Math.abs(sum-sum2));
            return;
        }else if(next>n){
            return;
        } else{
            set.add(next);
            go(set,next+1);
            set.remove(next);
            go(set,next+1);
        }
    }

}