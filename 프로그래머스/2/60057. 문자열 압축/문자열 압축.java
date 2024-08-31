import java.io.*;

class Solution {
    public static int minn=Integer.MAX_VALUE;
    
    public int solution(String s) {
        int answer = 0;
        for(int i=1;i<=s.length();i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<s.length();j+=i){
                    int count=1;
                    //기준
                    String sub1="";
                    int next=j+i;
                    if(next<=s.length()){
                        sub1=s.substring(j,next);
                    }else{
                        sub1=s.substring(j,s.length());
                    }
                    while(next+i<=s.length()){
                        String sub2=s.substring(next,next+i);
                        if(sub1.equals(sub2)){
                            count++;
                            next+=i;
                        }else{
                            break;
                        }
                    }
                    if(count>1){
                        sb.append(count+sub1);
                        j+=(count-1)*i;
                    }else{
                        sb.append(sub1);
                    }
                }
                minn=Math.min(minn,sb.length());
            }
        answer=minn;
        return answer;
    }
}