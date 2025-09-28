import java.util.*;
class Solution {
    private static int diff = 0;
    private static int[] win = new int[11];
    private static int[] finalResult;
    
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        for(int i=0;i<info.length;i++){
            win[i]=info[i]+1;
        }
        go(n,new ArrayList(),info);
        if(diff==0){
            return new int[]{-1};
        }
        return finalResult;
    }
    
    private void go(int n, List<Integer> list, int[] info){
        if(list.size()==11){
            int peach = 0;
            int count = 0;
            int lion = 0;
            for(int i=0;i<11;i++){
                if(list.get(i)==1){
                    count+=win[i];
                    lion+=(10-i);
                }else{
                    if(info[i]>0){
                     peach+=(10-i);   
                    }
                }
            }
            if(count>n) return;
            if(lion>peach && (lion-peach)>diff){
                diff = lion-peach;
                finalResult = create(list,count,n);
            }else if(lion>peach && (lion-peach)==diff){
                int[] now = create(list,count,n);
                finalResult = compare(now);
            }
            return;
        }
        
        list.add(0);
        go(n,list,info);
        list.remove(list.size()-1);
        list.add(1);
        go(n,list,info);
        list.remove(list.size()-1);
    }
    
    private int[] create(List<Integer> list, int count, int n){
        int[] result = new int[11];
        for(int i=0;i<11;i++){
            if(list.get(i)==1){
                result[i]=win[i];
            }
        }
        if(count<n){
            int rest = n-count;
            result[10]+=rest;
        }
        return result;
    }
    
    private int[] compare(int[] now){
        for(int i=10;i>=0;i--){
            if(finalResult[i]<now[i]){
                return now;
            }else if(finalResult[i]>now[i]){
                return finalResult;
            }
        }
        return finalResult;
    }
}