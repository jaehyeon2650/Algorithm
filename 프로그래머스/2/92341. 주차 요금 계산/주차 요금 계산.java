import java.util.*;

class Solution {
    
    static class History{
        String status;
        int time;
        
        public History(String time, String status){
            this.status = status;
            String[] times = time.split(":");
            this.time = Integer.parseInt(times[0])*60+Integer.parseInt(times[1]);
        }
    }
    
    private static int basicMin;
    private static int basicMoney;
    private static int unitMin;
    private static int unitMoney;
    private static Queue<String> cars = new PriorityQueue<>();
    private static Set<String> uni = new HashSet();
    private static Map<String,List<History>> histories = new HashMap();
    
    public int[] solution(int[] fees, String[] records) {
        basicMin = fees[0];
        basicMoney = fees[1];
        unitMin = fees[2];
        unitMoney = fees[3];
        for(String record:records){
            StringTokenizer st = new StringTokenizer(record);
            String time = st.nextToken();
            String carName = st.nextToken();
            String status = st.nextToken();
            if(uni.add(carName)){
                cars.add(carName);
            }
            List<History> info = histories.getOrDefault(carName,new ArrayList());
            info.add(new History(time,status));
            histories.put(carName, info);
        }
        int size = cars.size();
        int[] answer = new int[size];
        for(int i=0;i<size;i++){
            String name = cars.poll();
            List<History> historyList = histories.get(name);
            int total = basicMoney;
            int totalTime = 0;
            for(int j=0;j<historyList.size();j+=2){
                int in = historyList.get(j).time;
                int out;
                if(j+1==historyList.size()){
                    out = 23*60+59;
                }else{
                    out = historyList.get(j+1).time;
                }
                totalTime+=(out-in);
            }
            if(totalTime-basicMin > 0){
                if((totalTime-basicMin)%unitMin!=0){
                    totalTime = (totalTime-basicMin)/unitMin + 1;
                }else{
                    totalTime = (totalTime-basicMin)/unitMin;
                }
            }else{
                totalTime = 0;
            }
            total+=totalTime*unitMoney;
            answer[i]=total;
        }
        return answer;
    }
}