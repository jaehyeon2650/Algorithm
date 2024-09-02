import java.util.*;
class Solution {
    public static int w;
    public static int d;
    public static int mincount;
    public static int nn;
    public static int[] weaks;
    public int solution(int n, int[] weak, int[] dist) {
        w=weak.length;
        d=dist.length;
        nn=n;
        weaks=new int[2*w];
        for(int i=0;i<w;i++){
            weaks[i]=weak[i];
        }
        for(int i=0;i<w;i++){
            weaks[w+i]=weak[i]+n;
        }
        mincount=d+1;
        Vector<Integer> v=new Vector();
        int[] visited= new int[d];
        makeDist(v,visited,dist);
        if(mincount==d+1) return -1;
        return mincount;
    }
    
    public void makeDist(Vector<Integer> v,int[] visited,int[] dist){
        if(v.size()==d){
            checkCan(v);
            return;
        }
        for(int i=0;i<d;i++){
            if(visited[i]==0){
                v.add(dist[i]);
                visited[i]=1;
                makeDist(v,visited,dist);
                v.remove(v.size()-1);
                visited[i]=0;
            }
        }
    }
    
    public void checkCan(Vector<Integer> dist){
        int[] visited= new int[w];
        for(int i=0;i<w;i++){
            int count=0;
            int index=i;
            int j;
            for(j=0;j<d;j++){
                if(index>=2*w||count==w) break;
                int next=weaks[index]+dist.get(j);
                count++;
                index++;
                while(index<2*w&&weaks[index]<=next&&count!=w){
                    count++;
                    index++;
                }
            }
            if(count==w){
                mincount=Math.min(mincount,j);
            }
        }
    }
}