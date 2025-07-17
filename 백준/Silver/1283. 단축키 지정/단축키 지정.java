import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static Set<Character> keys = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        StringBuilder total = new StringBuilder();
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(bf.readLine());
            boolean find = false;
            int count = st.countTokens();
            for(int j=0;j<count;j++){
                String word = st.nextToken();
                char first = Character.toLowerCase(word.charAt(0));
                if(!find && !keys.contains(first)) {
                    keys.add(first);
                    find = true;
                    sb.append("["+word.charAt(0)+"]"+word.substring(1)+" ");
                    continue;
                }
                sb.append(word+" ");
            }

            if(!find){
                String words = sb.toString();
                sb.setLength(0);
                for(int j=0;j<words.length();j++){
                    char first = Character.toLowerCase(words.charAt(j));
                    if(!find && !keys.contains(first) && words.charAt(j)!=' '){
                        find=true;
                        keys.add(first);
                        sb.append("["+words.charAt(j)+"]");
                        continue;
                    }
                    sb.append(words.charAt(j));
                }
            }
            total.append(sb.toString()+'\n');
        }
        bw.write(total.toString());
        bw.flush();
    }

}
