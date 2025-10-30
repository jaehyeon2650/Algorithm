import java.util.*;
class Solution {
    
    private static Map<String, List<String>> graph = new HashMap();
    private static int result = Integer.MAX_VALUE;
    private static Map<String, Integer> visited = new HashMap();
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        if(!checkCanChange(target, words)) return answer;
        createGraph2(begin,words);
        createGraph(words);
        bfs(begin);
        answer = visited.get(target)-1;
        return answer;
    }
    
    private void bfs(String start){
        Queue<String> queue = new ArrayDeque();
        queue.add(start);
        visited.put(start,1);
        while(!queue.isEmpty()){
            String now = queue.poll();
            // System.out.println("시작 = "+now);
            List<String> list = graph.get(now);
            for(String s: list){
                // System.out.println(s);
                if(visited.get(s)==0){
                    visited.put(s,visited.get(now)+1);
                    queue.add(s);
                }
            }
        }
    }
    
    private void createGraph2(String start, String[] words){
        visited.put(start, 0);
        List<String> list = new ArrayList();
        for(int j=0;j<words.length;j++){
            int count = 0;
            for(int k=0;k<words[j].length();k++){
                if(words[j].charAt(k)!=start.charAt(k)){
                    count++;
                }
                if(count>=2) break;
            }
            if(count==1){
                list.add(words[j]);
            }
        }
        graph.put(start, list);
    }
    
    private void createGraph(String[] words){
        for(int i=0;i<words.length;i++){
            String word = words[i];
            visited.put(word, 0);
            List<String> list = new ArrayList();
            for(int j=0;j<words.length;j++){
                if(i==j) continue;
                int count = 0;
                for(int k=0;k<words[j].length();k++){
                    if(words[j].charAt(k)!=word.charAt(k)){
                        count++;
                    }
                    if(count>=2) break;
                }
                if(count==1){
                    list.add(words[j]);
                }
            }
            graph.put(word, list);
        }
    }
    
    private boolean checkCanChange(String target, String[] words){
        for(String word: words){
            if(target.equals(word)) return true;
        }
        return false;
    }
}