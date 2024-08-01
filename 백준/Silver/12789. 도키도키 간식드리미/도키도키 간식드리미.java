import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Stack;

class Main {
    public static int n;
    public static Stack<Integer> st=new Stack<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        int start=1;
        for (int i = 0; i < n; i++) {
            int a=scan.nextInt();
            if(start==a){
                start++;
                while(!st.empty()&&st.peek()==start){
                    st.pop();
                    start++;
                }
            }else if(!st.empty()&&st.peek()==start){
                while((!st.empty()&&st.peek()==start)||start==a){
                    if(start==a){
                        start++;
                    }else{
                        st.pop();
                        start++;
                    }
                }
            }else{
                st.push(a);
            }
        }
        if(st.empty()){
            System.out.println("Nice");
        }else{
            System.out.println("Sad");
        }
    }
}