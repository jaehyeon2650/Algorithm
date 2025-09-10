import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Tree implements Comparable<Tree> {
        public int y;
        public int x;
        public int age;

        public Tree(final int y, final int x, final int age) {
            this.y = y;
            this.x = x;
            this.age = age;
        }

        @Override
        public int compareTo(final Tree o) {
            return age - o.age;
        }
    }

    private static int n;
    private static int m;
    private static int k;
    private static int[][] foods;
    private static int[][] curFoods;
    private static int[] dy = {0, 0, 1, 1, 1, -1, -1, -1};
    private static int[] dx = {-1, 1, -1, 0, 1, -1, 0, 1};

    private static Queue<Tree> trees = new PriorityQueue<>();
    private static Queue<Tree> diedTrees = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        foods = new int[n + 1][n + 1];
        curFoods = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                curFoods[i][j] = 5;
                foods[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x, y, age));
        }

        for (int i = 0; i < k; i++) {
            int treeCount = trees.size();
            Queue<Tree> clearTree = new ArrayDeque<>();
            for (int j = 0; j < treeCount; j++) {
                Tree tree = trees.poll();
                if (curFoods[tree.y][tree.x] >= tree.age) {
                    curFoods[tree.y][tree.x] -= tree.age;
                    tree.age += 1;
                    clearTree.add(tree);
                } else {
                    diedTrees.add(tree);
                }
            }

            trees.addAll(clearTree);

            for (Tree diedTree : diedTrees) {
                curFoods[diedTree.y][diedTree.x] += (diedTree.age / 2);
            }

            diedTrees.clear();

            for (Tree tree : clearTree) {
                if (tree.age % 5 == 0) {
                    for (int j = 0; j < 8; j++) {
                        int ny = tree.y + dy[j];
                        int nx = tree.x + dx[j];
                        if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                            continue;
                        }
                        trees.add(new Tree(ny, nx, 1));
                    }
                }
            }
            addFoods();
        }

        System.out.println(trees.size());
    }

    private static void addFoods() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                curFoods[i][j] += foods[i][j];
            }
        }
    }
}
