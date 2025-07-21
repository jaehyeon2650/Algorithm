import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static class Problem implements Comparable<Problem> {
        int number;
        int level;

        @Override
        public int compareTo(final Problem o) {
            if (level != o.level) {
                return o.level - level;
            }
            return o.number - number;
        }

        public Problem(final int number, final int level) {
            this.number = number;
            this.level = level;
        }
    }

    private static int n;
    private static int m;
    private static StringBuilder sb = new StringBuilder();

    private static TreeSet<Problem> problemsMax = new TreeSet<>();
    private static TreeSet<Problem> problemsMin = new TreeSet<>(Collections.reverseOrder());
    private static Map<Integer, Problem> problems = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String options = st.nextToken();
            if (options.equals("add")) {
                add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } else if (options.equals("solved")) {
                solve(Integer.parseInt(st.nextToken()));
            } else {
                recommend(Integer.parseInt(st.nextToken()));
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void add(int number, int level) {
        Problem problem = new Problem(number, level);
        problemsMax.add(problem);
        problemsMin.add(problem);
        problems.put(number,problem);
    }

    private static void recommend(int option) {
        if (option == 1) {
            sb.append(problemsMax.first().number ).append("\n");
        } else {
            sb.append(problemsMin.first().number ).append("\n");
        }
    }

    private static void solve(int number) {
        Problem findProblem = problems.get(number);
        problemsMax.remove(findProblem);
        problemsMin.remove(findProblem);
    }
}
