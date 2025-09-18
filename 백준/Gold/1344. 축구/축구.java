import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Main {

    private static double a;
    private static double b;
    private static double[][] dpA = new double[19][19];
    private static double[][] dpB = new double[19][19];

    private static Set<Integer> sosu = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        a = Double.parseDouble(bf.readLine()) / 100;
        b = Double.parseDouble(bf.readLine()) / 100;
        init();
        dpA[1][0] = 1 - a;
        dpA[1][1] = a;
        dpB[1][0] = 1 - b;
        dpB[1][1] = b;
        for (int i = 2; i <= 18; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dpA[i][j] = dpA[i - 1][j] * (1-a);
                    dpB[i][j] = dpB[i - 1][j] * (1-b);

                } else {
                    dpA[i][j] = dpA[i - 1][j - 1] * a + dpA[i-1][j] * (1 - a);
                    dpB[i][j] = dpB[i - 1][j - 1] * b + dpB[i-1][j] * (1 - b);
                }
            }
        }
        double result = 0;
        for (int i = 0; i <= 18; i++) {
            for (int j = 0; j <= 18; j++) {
                if(!sosu.contains(i) && !sosu.contains(j)){
                    result+=dpA[18][i]*dpB[18][j];
                }
            }
        }

        System.out.println(1-result);

    }

    private static void init() {
        sosu.add(2);
        sosu.add(3);
        sosu.add(5);
        sosu.add(7);
        sosu.add(11);
        sosu.add(13);
        sosu.add(17);
    }
}
