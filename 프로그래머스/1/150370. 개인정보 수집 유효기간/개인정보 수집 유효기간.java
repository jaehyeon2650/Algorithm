import java.util.*;

class Solution {
    
    private static Map<String, Integer> termMap = new HashMap();
    private static List<Privacy> list = new ArrayList();
    
    static class Privacy{
        int year;
        int month;
        int day;
        String term;
        
        public Privacy(String day, String term) {
            StringTokenizer st = new StringTokenizer(day,".");
            this.year = Integer.parseInt(st.nextToken());
            this.month = Integer.parseInt(st.nextToken());
            this.day = Integer.parseInt(st.nextToken());
            this.term = term;
        }
        
        public boolean isTrash(String now) {
            StringTokenizer st = new StringTokenizer(now,".");
            int nowYear = Integer.parseInt(st.nextToken());
            int nowMonth = Integer.parseInt(st.nextToken());
            int nowDay = Integer.parseInt(st.nextToken());
            
            int interval = termMap.get(this.term);
            int nextDay = day -1;
            int nextMonth = month + interval;
            if(nextDay == 0) {
                nextDay = 28;
                nextMonth-=1;
            }
            int nextYear =  year;
            if(nextMonth==0) {
                nextYear--;
                nextMonth = 12;
            } else if(nextMonth >= 13) {
                nextYear += (nextMonth - 1) / 12;
                nextMonth = (nextMonth - 1) % 12 + 1;
            }
            if(nextYear < nowYear) return true;
            if(nextYear == nowYear && nextMonth < nowMonth) return true;
            if(nextYear == nowYear && nextMonth == nowMonth && nextDay < nowDay) return true;
            return false;
        }
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        for(String term : terms) {
            StringTokenizer st = new StringTokenizer(term);
            termMap.put(st.nextToken(),Integer.parseInt(st.nextToken()));
        }
        
        for(String pri : privacies){
            StringTokenizer st = new StringTokenizer(pri);
            list.add(new Privacy(st.nextToken(),st.nextToken()));
        }
        List<Integer> result = new ArrayList();
        for(int i=0;i<list.size();i++){
            if(list.get(i).isTrash(today)) result.add(i+1);
        }
        
        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i]=result.get(i);
        }
        return answer;
    }
}