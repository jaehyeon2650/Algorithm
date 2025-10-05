import java.util.*;
class Solution {
    
    private static int n;
    public int solution(int coin, int[] cards) {
        n = cards.length;
        int heart = coin;
        Set<Integer> wait = new HashSet();
        Set<Integer> now = new HashSet();
        Set<Integer> want = new HashSet();
        for(int i = 0;i< n/3;i++){
            now.add(cards[i]);
            if(!now.contains(n+1-cards[i])){
                want.add(n+1-cards[i]);
            }else{
                want.remove(cards[i]);
            }
        }
        
        int turn = 0;
        for(int i=n/3;i<n;i+=2){
            turn++;
            boolean can = false;
            if(!can){
                for(Integer n1 : now){
                    if(now.contains(n+1-n1)){
                        can=true;
                        now.remove(n1);
                        now.remove(n+1-n1);
                        break;
                    }
                }
            }
            
            int first = cards[i];
            int second = cards[i+1];
            wait.add(first);
            wait.add(second);
            
            if(!can && heart>0){
              for(Integer n1 : wait){
                    if(want.contains(n1)){
                        can = true;
                        wait.remove(n1);
                        want.remove(n1);
                        heart--;
                        break;
                    }
                }  
            }
            
            if(!can && heart > 1){
                for(Integer n1 : wait){
                    if(wait.contains(n+1-n1)){
                        can = true;
                        wait.remove(n1);
                        wait.remove(n+1-n1);
                        heart-=2;
                        break;
                    }
                }
            }
            
            if(!can) break;
            if(can && i+2>=n) turn++;
        }
        
        return turn;
    }
}