import java.io.*;
import java.util.*;
class Main {
    public static int n;
    public static int bit=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String s=br.readLine();
            String[] strings = s.split(" ");
            if(strings[0].equals("all")){
                bit=(1<<21)-1;
            }else if(strings[0].equals("remove")){
                int num=Integer.parseInt(strings[1]);
                bit&=~(1<<num);
            }else if(strings[0].equals("check")){
                int num=Integer.parseInt(strings[1]);
                if((bit&(1<<num))>0){
                    sb.append(1+"\n");
                }else{
                    sb.append(0+"\n");
                }
            }else if(strings[0].equals("toggle")){
                int num=Integer.parseInt(strings[1]);
                bit^=(1<<num);
            }else if(strings[0].equals("add")){
                int num=Integer.parseInt(strings[1]);
                bit|=(1<<num);
            }else if(strings[0].equals("empty")){
                bit=0;
            }
        }
        System.out.println(sb);
    }
}