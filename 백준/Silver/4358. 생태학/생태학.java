import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

    private static int n=0;
    private static Map<String, Integer> counts = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String tree = "";
        while ((tree = bf.readLine()) != null) {
            counts.put(tree, counts.getOrDefault(tree, 0) + 1);
            n++;
        }
        StringBuilder sb = new StringBuilder();
        for (Entry<String, Integer> trees : counts.entrySet()) {
            String treeName = trees.getKey();
            Integer number = trees.getValue();
            double rate = (double) number/n;
            String rateString = String.format("%.4f", rate*100);
            sb.append(treeName+" "+rateString+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

}
