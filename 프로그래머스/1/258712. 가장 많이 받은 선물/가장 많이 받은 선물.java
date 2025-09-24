import java.util.*;

class Solution {
    
    private static Map<String,Map<String,Integer>> giveInfos = new HashMap();
    private static Map<String,Integer> giftScore = new HashMap();
    private static Map<String,Integer> result = new HashMap();
    
    public int solution(String[] friends, String[] gifts) {
        initialize(friends);
        initGitfInfo(gifts);
        
        for (int i=0;i<friends.length;i++){
            for(int j=i+1;j<friends.length;j++){
                String a = friends[i];
                String b = friends[j];
                int aGivenCount = giveInfos.get(a).getOrDefault(b,0);
                int bGivenCount = giveInfos.get(b).getOrDefault(a,0);
                if(aGivenCount<bGivenCount){
                    result.put(b,result.get(b)+1);
                }else if(aGivenCount>bGivenCount){
                    result.put(a,result.get(a)+1);
                }else{
                    int aGiftScore = giftScore.get(a);
                    int bGiftScore = giftScore.get(b);
                    if(aGiftScore>bGiftScore){
                        result.put(a,result.get(a)+1);
                    }else if(aGiftScore<bGiftScore){
                        result.put(b,result.get(b)+1);
                    }
                }
            }
        }
        
        int maxn = 0;
        for(Integer score : result.values()){
            maxn = Math.max(maxn,score);
        }
        return maxn;
    }
    
    private void initialize(String[] friends){
        for(String friend : friends){
            giveInfos.put(friend,new HashMap());
            giftScore.put(friend,0);
            result.put(friend,0);
        }
    }
    
    private void initGitfInfo(String[] gifts){
        for(String gift:gifts){
            StringTokenizer st = new StringTokenizer(gift);
            String from = st.nextToken();
            String to = st.nextToken();
            Map<String,Integer> info = giveInfos.get(from);
            info.put(to,info.getOrDefault(to,0)+1);
            giftScore.put(from,giftScore.get(from)+1);
            giftScore.put(to,giftScore.get(to)-1);
        }
    }
}