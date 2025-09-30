import java.util.*;

class Solution {
    static class Where{
        String dev;
        String job;
        String exp;
        String food;
        
        public Where(String dev, String job, String exp, String food){
            this.dev = dev;
            this.job = job;
            this.exp = exp;
            this.food = food;
        }
        
        @Override
        public boolean equals(Object o){
            Where object = (Where) o;
            return Objects.equals(dev, object.dev) &&
               Objects.equals(job, object.job) &&
               Objects.equals(exp, object.exp) &&
               Objects.equals(food, object.food);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(dev, job, exp, food);
        }
    }
    
    private static Map<Where, List<Integer>> maps = new HashMap();
    public int[] solution(String[] info, String[] query) {
        
        for(String in : info){
            StringTokenizer st = new StringTokenizer(in);
            String dev = st.nextToken();
            String job = st.nextToken();
            String exp = st.nextToken();
            String food = st.nextToken();
            Integer score = Integer.parseInt(st.nextToken());
            create(dev,job,exp,food,score,0,new int[4]);
        }
        
        for (List<Integer> list : maps.values()) {
            Collections.sort(list);
        }
        
        int[] answer = new int[query.length];
        int index = 0;
        for(String q: query){
            String[] sp = q.split(" and ");
            String dev = sp[0];
            String job = sp[1];
            String exp = sp[2];
            String f = sp[3];
            StringTokenizer st = new StringTokenizer(f);
            String food = st.nextToken();
            Integer score = Integer.parseInt(st.nextToken());
            dev = (dev.equals("-")?null: dev);
            job = (job.equals("-")?null: job);
            exp = (exp.equals("-")?null: exp);
            food = (food.equals("-")?null: food);
            Where where = new Where(dev, job, exp, food);
            List<Integer> que = maps.getOrDefault(where, new ArrayList());
            int re = find(que,score);
            answer[index] = que.size()-re;
            index++;
        }
        
        return answer;
    }
    
    private void create(String dev, String job, String exp, String food, int score ,int cnt, int[] list){
        if(cnt == 4){
            String d = list[0] == 0 ? null : dev;
            String j = list[1] == 0 ? null : job;
            String e = list[2] == 0 ? null : exp;
            String f = list[3] == 0 ? null : food;
            Where where = new Where(d,j,e,f);
            List<Integer> q = maps.getOrDefault(where, new ArrayList());
            q.add(score);
            maps.put(where, q);
            return;
        }
        create(dev,job,exp,food,score,cnt+1,list);
        list[cnt] = 1;
        create(dev,job,exp,food,score,cnt+1,list);
        list[cnt] = 0;
    }
    
    private int find(List<Integer> scores, int score){
        int left = 0;
        int right = scores.size()-1;
        int answer = scores.size();
        while(left<=right){
            int mid = (right+left)/2;
            if (scores.get(mid) >= score) {
                answer = mid; 
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }
        return answer;
    }
}