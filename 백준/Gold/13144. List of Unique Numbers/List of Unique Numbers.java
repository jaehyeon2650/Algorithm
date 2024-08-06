import java.io.*;
import java.util.*;

class Main {
    public static int n;
    public static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(rd.readLine());
        a=new int[n];
        String s=rd.readLine();
        String[] strings = s.split(" ");
        for (int i=0;i<n;i++){
            a[i]=Integer.parseInt(strings[i]);
        }
        int l=0;
        Set<Integer> set=new HashSet<>();
        long sum=0;
        for(int r=0;r<n;r++){
            if(!set.contains(a[r])){
                set.add(a[r]);
            }else{
                while(set.contains(a[r])){
                    sum+=(r-l);
                    set.remove(a[l]);
                    l++;
                }
                set.add(a[r]);
            }
        }
        for(int j=1;j<=set.size();j++){
            sum+=j;
        }
        System.out.println(sum);
    }

}