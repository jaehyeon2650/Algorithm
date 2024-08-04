import java.io.*;
import java.util.*;

class Main {
    static class Word{
        public Character c;
        public int correct;
        public int index;

        public Word(Character c, int correct,int index) {
            this.c = c;
            this.correct = correct;
            this.index=index;
        }
    }

    public static String s;
    public static String bomb;
    public static int count=0;
    public static Stack<Word> st=new Stack<>();
    public static Vector<Word> v=new Vector<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sw=new StringBuilder();
        s=bf.readLine();
        bomb=bf.readLine();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==bomb.charAt(count)){
                count++;
                st.add(new Word(s.charAt(i),count,i));
                if(count==bomb.length()){
                    for(int j=0;j<bomb.length();j++){
                        st.pop();
                    }
                    if(!st.isEmpty()){
                        count=st.peek().correct;
                    }else{
                        count=0;
                    }
                }
            }
            else{
                if(count!=0){
                    count=0;
                    if(s.charAt(i)==bomb.charAt(count)){
                        st.add(new Word(s.charAt(i),++count,i));
                    }else{
                        st.add(new Word(s.charAt(i),count,i));
                    }
                }else{
                    st.add(new Word(s.charAt(i),count,i));
                }
            }
        }
        if(st.isEmpty()){
            System.out.println("FRULA");
        }else{
            while(!st.isEmpty()){
                v.add(st.pop());
            }
            Collections.reverse(v);
            for(Word c:v){
                sw.append(c.c);
            }
            System.out.println(sw);
        }

    }
}