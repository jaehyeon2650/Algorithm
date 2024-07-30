import java.io.*;
import java.util.*;
class Main {

    public static int t;
    public static String order;
    public static int n;
    public static String array;
    public static Deque<Integer> q=new ArrayDeque<>();
    public static int currentSize;

    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);
        t=scan.nextInt();
        for(int i=0;i<t;i++){
            StringBuilder st=new StringBuilder();
            q.clear();
            order=scan.next();
            n=scan.nextInt();
            currentSize=n;
            array=scan.next();
            changeToArrays();
            boolean can=true;
            boolean reverse=false;
            for(int j=0;j<order.length();j++){
                if(order.charAt(j)=='R'){
                    if(reverse) reverse=false;
                    else reverse=true;
                }else{
                    if(--currentSize<0){
                        can=false;
                        break;
                    }
                    if(reverse){
                        q.pollLast();
                    }else{
                        q.pollFirst();
                    }
                }
            }
            if(!can){
                System.out.println("error");
                continue;
            }
            st.append('[');
            if(reverse){
                for(int j=0;j<currentSize;j++){
                    if(j==currentSize-1){
                        st.append(q.pollLast());
//                        System.out.print(q.pollLast());
                    }else{
                        st.append(q.pollLast()+",");
//                        System.out.print(q.pollLast()+",");
                    }
                }
            }else{
                for(int j=0;j<currentSize;j++){
                    if(j==currentSize-1){
                        st.append(q.pollFirst());
//                        System.out.print(q.pollFirst());
                    }else{
//                        System.out.print(q.pollFirst()+",");
                        st.append(q.pollFirst()+",");
                    }
                }
            }
            st.append(']');
            System.out.println(st);
        }
    }
    public static void changeToArrays() {
        array=array.substring(1,array.length()-1);
        if(array.isEmpty()){
            return;
        }
        String[] strings = array.split(",");
        for(int i=0;i<strings.length;i++){
            q.add(Integer.valueOf(strings[i]));
        }
    }
}