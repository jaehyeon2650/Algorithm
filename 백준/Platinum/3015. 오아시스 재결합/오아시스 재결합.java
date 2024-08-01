import java.io.*;
import java.math.BigInteger;
import java.util.*;
class Main {
    static class Num{
        private BigInteger integer;
        private Long cnt;

        public Num(BigInteger integer, Long cnt) {
            this.integer = integer;
            this.cnt = cnt;
        }

        public BigInteger getInteger() {
            return integer;
        }

        public Long getCnt() {
            return cnt;
        }
    }
    public static Stack<Num> st=new Stack<>();
    public static int n;
    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        Long ret=0L;
        for(int i=0;i<n;i++){
            String s=scan.next();
            BigInteger next=new BigInteger(s);
            Long cnt=1L;
            while(!st.empty()&&st.peek().getInteger().compareTo(next)<=0){
                ret+=st.peek().getCnt();
                if(st.peek().getInteger().compareTo(next)==0){
                    cnt=st.peek().getCnt()+1;
                }else{
                    cnt=1L;
                }
                st.pop();
            }
            if(!st.empty()){
                ret++;
            }
            st.push(new Num(next,cnt));
        }
        System.out.println(ret);
    }
}