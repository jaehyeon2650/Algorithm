import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Stack;

class Main {
    public static int n;
    public static Stack<Integer> st=new Stack<>();
    public static void main(String[] args) {
        StringBuffer stringBuffer=new StringBuffer();
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        for(int i=0;i<n;i++){
            int num=scan.nextInt();
            if(num==1){
                int a=scan.nextInt();
                st.push(a);
            }else if(num==2){
                if(!st.empty()){
                    stringBuffer.append(st.pop()+"\n");
                }else{
                    stringBuffer.append(-1+"\n");
                }
            }else if(num==3){
                stringBuffer.append(st.size()+"\n");
            }else if(num==4){
                if(st.empty()){
                    stringBuffer.append(1+"\n");
                }else{
                    stringBuffer.append(0+"\n");
                }
            }else{
                if(!st.empty()){
                    stringBuffer.append(st.peek()+"\n");
                }else{
                    stringBuffer.append(-1+"\n");
                }
            }
        }
        System.out.println(stringBuffer);
    }
}