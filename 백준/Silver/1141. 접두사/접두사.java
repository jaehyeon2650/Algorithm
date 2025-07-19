import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    private static int n;
    private static List<Word> words = new ArrayList<>();

    static class Word implements Comparable<Word> {
        String word;

        @Override
        public int compareTo(final Word o) {
            if(this.word.length()!=o.word.length()){
                return word.length()-o.word.length();
            }
            return word.compareTo(o.word);
        }

        public Word(final String word) {
            this.word = word;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        int cant = 0;
        for(int i=0;i<n;i++){
            words.add(new Word(bf.readLine()));
        }
        Collections.sort(words);
        for(int i=0;i<n;i++){
            boolean same = false;
            String word = words.get(i).word;
            for(int j=i+1;j<n;j++){
                if(words.get(j).word.substring(0,word.length()).equals(word)){
                    same=true;
                    break;
                }
            }
            if(same){
                cant++;
            }
        }
        System.out.println(n-cant);
    }


}
