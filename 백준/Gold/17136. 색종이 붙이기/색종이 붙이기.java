import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int n = 10;
    public static int[][] a = new int[11][11];
    public static int[] counts = new int[6];
    public static int maxn = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 10; i++) {
            String s = br.readLine();
            String[] s1 = s.split(" ");
            for (int j = 1; j <= 10; j++) {
                a[i][j] = Integer.parseInt(s1[j - 1]);
            }
        }
        go(1, 1, 0);
        if (maxn == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(maxn);
        }
    }

    public static void go(int y, int x, int cnt) {
        if (y > n) {
            maxn = Math.min(maxn, cnt);
            return;
        }
        if (x > n) {
            go(y + 1, 0, cnt);
            return;
        }
        if (a[y][x] == 0) {
            go(y, x + 1, cnt);
        }
        for (int i = 1; i <= 5; i++) {
            if (check(y, x, i)) {
                if (counts[i] == 5) {
                    continue;
                }
                draw(y, x, i, 0);
                counts[i]++;
                go(y, x + 1, cnt + 1);
                counts[i]--;
                draw(y, x, i, 1);
            }
        }
    }

    public static void draw(int y, int x, int size, int value) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                a[i][j] = value;
            }
        }
    }

    public static boolean check(int y, int x, int size) {
        if (y + size - 1 > n || x + size - 1 > n) {
            return false;
        }
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (a[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
