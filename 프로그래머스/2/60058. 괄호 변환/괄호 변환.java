import java.util.*;
class Solution {
    public String solution(String p) {
        if(check(p)) return p;
        else return make(p);
    }
    
    public static boolean check(String s){
            Stack<Character> st=new Stack<>();
            for(int i=0;i<s.length();i++){
                if(st.isEmpty()){
                    st.add(s.charAt(i));
                }else if(st.peek()=='('&&s.charAt(i)==')') st.pop();
                else{
                    st.push(s.charAt(i));
                }
            }
            if(st.isEmpty()) return true;
            return false;
        }
        public static String make(String s){
            if(check(s)) return s;
            String newString="";
            String[] strings = makeNewString(s);
            String u=strings[0];
            String v=strings[1];
            String s1=make(v);
            if(!check(u)){
                String news1="(";
                news1+=s1;
                news1+=")";
                String substring = u.substring(1, u.length() - 1);
                String newsubstring="";
                for(int i=0;i<substring.length();i++){
                    if(substring.charAt(i)=='(') newsubstring+=")";
                    else newsubstring+="(";
                }
                news1+=newsubstring;
                newString=news1;
            }else{
                newString=u+s1;
            }
            return newString;
        }
        public static String[] makeNewString(String s){
            int count1=0;
            int count2=0;
            String news1="";
            String news2="";
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='(') count1++;
                if(s.charAt(i)==')') count2++;
                if(count1==count2){
                    news1=s.substring(0,i+1);
                    if(i+1!=s.length()){
                        news2=s.substring(i+1);
                    }
                    break;
                }
            }
            String[] string={news1,news2};
            return string;
        }
}