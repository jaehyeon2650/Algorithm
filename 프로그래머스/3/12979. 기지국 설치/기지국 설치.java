class Solution {
    

    public int solution(int n, int[] stations, int w) {
        int prev=0;
        int ret=0;
        for(int station:stations){
            int a=station-w-1-prev;
            int b=a/(w*2+1);
            if(a%(w*2+1)>0) b++;
            ret+=Math.max(0,b);
            prev=station+w;
        }
        ret+=(n-prev)/(w*2+1);
        if((n-prev)%(w*2+1)>0) ret++;
        return ret;
    }
    
   
}