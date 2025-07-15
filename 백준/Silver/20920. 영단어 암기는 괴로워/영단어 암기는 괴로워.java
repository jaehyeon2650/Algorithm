import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int maxLength;
    private static Queue<Word> words = new PriorityQueue<>();
    private static Map<String,Integer> wordsMap = new HashMap<>();

    static class Word implements Comparable<Word>{
        String word;
        int count;

        @Override
        public int compareTo(final Word o) {
            if(count!=o.count){
                return o.count - count;
            }
            if(word.length()!=o.word.length()){
                return o.word.length()-word.length();
            }
            return word.compareTo(o.word);
        }

        public Word(final String word, final int count) {
            this.word = word;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        maxLength = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            String s = bf.readLine();
            if(s.length()<maxLength) continue;
            wordsMap.put(s,wordsMap.getOrDefault(s,0)+1);
        }
        for (Entry<String, Integer> entry : wordsMap.entrySet()) {
            words.add(new Word(entry.getKey(),entry.getValue()));
        }
        StringBuffer sb = new StringBuffer();
        while(!words.isEmpty()){
            sb.append(words.poll().word+'\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }

}
