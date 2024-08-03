import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static Vector<Integer> v=new Vector<>();
    public static int n;
    public static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        String s= bf.readLine();
        String[] strings = s.split(" ");
        for(int i=0;i<n;i++){
            v.add(Integer.parseInt(strings[i]));
        }

        k=Integer.parseInt(bf.readLine());

        Collections.sort(v);

        int l=0;
        int r=n-1;
        int total=0;
        while(l<r){
            if(v.get(l)+v.get(r)==k){
                total++;
                l++;
                r--;
            }else if(v.get(l)+v.get(r)>k){
                r--;
            }else if(v.get(l)+v.get(r)<k){
                l++;
            }
        }
        System.out.println(total);
    }
}