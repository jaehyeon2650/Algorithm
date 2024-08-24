import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

class Main {
    public static int t;
    public static int n;
    public static int m;

    public static Set<Integer> arrA = new HashSet<>();
    public static Set<Integer> arrB = new HashSet<>();
    public static ArrayList<Integer> arrA1 = new ArrayList<>();
    public static ArrayList<Integer> arrB1 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        String[] strings = s.split(" ");
        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);
        s = bf.readLine();
        strings = s.split(" ");
        for (int j = 0; j < n; j++) {
            arrA.add(Integer.parseInt(strings[j]));
            arrA1.add(Integer.parseInt(strings[j]));
        }
        s = bf.readLine();
        strings = s.split(" ");
        for (int j = 0; j < m; j++) {
            arrB.add(Integer.parseInt(strings[j]));
            arrB1.add(Integer.parseInt(strings[j]));
        }
        int total = 0;
        int num = n;
        for (int j = 0; j < m; j++) {

            if (arrA.contains(arrB1.get(j))) {

                num--;
            }
        }
        total += num;
        num = m;
        for (int j = 0; j < n; j++) {
            if (arrB.contains(arrA1.get(j))) {
                num--;
            }
        }
        total += num;
        System.out.println(total);
    }


}