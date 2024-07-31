import java.io.*;
import java.math.BigInteger;
import java.util.*;
class Main {
    public static int[] dp=new int[200001];
    public static String s;
    public static int n;
    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        s=scan.next();
        Stack<Integer> st=new Stack<>();
        int maxn=0;
        for(int i=0;i<n;i++){
            if(st.empty()){
                if(s.charAt(i)=='('){
                    st.push(i);
                }
            }else{
                if(s.charAt(i)==')'){
                    dp[st.pop()]=dp[i]=1;
                }else{
                    st.push(i);
                }
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            if(dp[i]==1){
                sum++;
                maxn=Math.max(sum,maxn);
            }else{
                sum=0;
            }
        }
        System.out.println(maxn);
    }

}