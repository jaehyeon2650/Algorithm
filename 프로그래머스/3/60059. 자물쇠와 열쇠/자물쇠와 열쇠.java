import java.util.*;

class Solution {
    public static boolean can=false;
    public static int n;
    public static int m;
    
    public boolean solution(int[][] key, int[][] lock) {
        n=key.length;
        m=lock.length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(lock[i][j]==0) count++;
            }
        }
        go(0,key,lock,count);
        return can;
    }
    
    public static void go(int rightRotate,int[][] key,int[][] lock,int count){
            if(can(key,lock,count)) can=true;
            if(can) return;
            if(rightRotate==4) return;
            int[][] newKey=copy(key);
            newKey=copy(key);
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    newKey[j][n-1-i]=key[i][j];
                }
            }
            go(rightRotate+1,newKey,lock,count);
        }
        public static boolean can(int[][] key,int[][] lock,int count){
            for(int i=-n+1;i<m;i++){
                for(int j=-n+1;j<m;j++){
                    int temp=count;
                    boolean check=true;
                    for(int k=0;k<n;k++){
                        for(int l=0;l<n;l++){
                            int ny=i+k;
                            int nx=j+l;
                            if(ny<0||nx<0||ny>=m||nx>=m) continue;
                            if(lock[ny][nx]==1&&key[k][l]==1) check=false;
                            if(lock[ny][nx]==0&&key[k][l]==0) check=false;
                            if(lock[ny][nx]==0&&key[k][l]==1) temp--;
                            if(!check) break;
                        }
                        if(!check) break;
                    }
                    if(temp!=0) check=false;
                    if(check) return true;
                }
            }
            return false;
        }

        public static int[][] copy(int[][] key){
            int[][] newkey=new int[n][n];
            for(int i=0;i<n;i++){
                newkey[i]=Arrays.copyOf(key[i],n);
            }
            return newkey;
        }
    
}