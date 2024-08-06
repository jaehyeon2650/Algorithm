import java.io.*;
import java.util.*;

class Main {
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(bf.readLine());
        Vector<Integer> v = new Vector<>();
        int l = 0;
        int sum = 0;
        int total = 0;
        //소수들 백터에 집어 넣기
        for (int i = 2; i <= n; i++) {
            if (check(i)) v.add(i);
        }

        //투포인터 활용
        for (int r = 0; r < v.size(); r++) {
            int num = v.get(r);
            sum += num;
            if (sum == n) {
                total++;
            } else if (sum > n) {
                while (sum > n) {
                    sum -= v.get(l);
                    l++;
                }
                if (sum == n) {
                    total++;
                    sum -= v.get(l);
                    l++;
                }
            }
        }
        System.out.println(total);
    }

    // 소수 확인 메소드
    public static boolean check(int a){
        if(a<=1) return false;
        if(a==2) return true;
        if(a%2==0) return false;
        for(int i=2;i*i<=a;i++){
            if(a%i==0) return false;
        }
        return true;
    }
}