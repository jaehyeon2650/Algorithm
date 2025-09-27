class Solution {
    
    private static int maxn = 0;
    private static int money = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] rates = new int[emoticons.length];
        go(0,users,emoticons,rates);
        int[] answer = {maxn,money};
        return answer;
    }
    
    private void go(int index,int[][] users, int[] emoticons, int[] rates){
        if(index == emoticons.length){
            evaluate(users,emoticons,rates);
            return;
        }
        int[] hubo = {1,2,3,4};
        for(int i: hubo){
            rates[index]=i;
            go(index+1,users,emoticons,rates);
        }
    }
    
    private void evaluate(int[][] users, int[] emoticons,int[] rates){
        int maxBuy = 0;
        int maxMoney = 0;
        for(int i=0;i<users.length;i++){
            int userRate = users[i][0];
            int userMaxMoney = users[i][1];
            int userMoney = 0;
        
            for(int j=0;j<emoticons.length;j++){
                int rate = rates[j]*10;
                if(userRate>rate) continue;
                userMoney += (emoticons[j]*(100-rate))/100;
            }
            if(userMoney>=userMaxMoney){
                maxBuy++;
            }else{
                maxMoney+=userMoney;
            }
        }
        if(maxn<maxBuy){
            maxn = maxBuy;
            money = maxMoney;
        }else if(maxn==maxBuy && money<maxMoney){
            money = maxMoney;
        }
    }
}