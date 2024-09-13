import java.io.*;
import java.util.*;

public class Main {

    static int n, m, k, ret;
    static int[][] A = new int[14][14];
    static int[][] yangbun = new int[14][14];
    static List<Integer>[][] a = new ArrayList[14][14];
    static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    static void springSummer() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j].size() == 0) continue;
                int die_tree = 0;
                List<Integer> temp = new ArrayList<>();
                Collections.sort(a[i][j]);
                for (int tree : a[i][j]) {
                    if (yangbun[i][j] >= tree) {
                        yangbun[i][j] -= tree;
                        temp.add(tree + 1);
                    } else {
                        die_tree += tree / 2;
                    }
                }

                a[i][j] = temp;
                yangbun[i][j] += die_tree;
            }
        }
    }
    static void fall() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j].size() == 0) continue;
                for (int tree : a[i][j]) {
                    if (tree % 5 == 0) {
                        for (int d = 0; d < 8; d++) {
                            int ny = i + dy[d];
                            int nx = j + dx[d];
                            if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                            a[ny][nx].add(1);
                        }
                    }
                }
            }
        }
    }
    static void winter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                yangbun[i][j] += A[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            Arrays.fill(yangbun[i], 5);
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            a[x][y].add(age);
        }
        for (int i = 0; i < k; i++) {
            springSummer();
            fall();
            winter();
        }

        ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ret += a[i][j].size();
            }
        }
        System.out.println(ret);
    }
}
