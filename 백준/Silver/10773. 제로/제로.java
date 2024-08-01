import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Stack;

class Main {
    public static int n;
    public static Stack<Integer> st=new Stack<>();
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        for(int i=0;i<n;i++){
            int a=scan.nextInt();
            if(a==0){
                st.pop();
            }else{
                st.add(a);
            }
        }
        int sum=0;
        while(!st.empty()){
            sum+=st.pop();
        }
        System.out.println(sum);
    }
}