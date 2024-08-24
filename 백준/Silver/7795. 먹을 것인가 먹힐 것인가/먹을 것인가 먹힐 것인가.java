import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

class Main {
    public static int t;
    public static int n;
    public static int m;

    public static ArrayList<Integer> arrA=new ArrayList<>();
    public static ArrayList<Integer> arrB=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer buffer=new StringBuffer();
        t=Integer.parseInt(bf.readLine());
        for(int i=0;i<t;i++){
            arrA.clear();
            arrB.clear();
            String s=bf.readLine();
            String[] strings = s.split(" ");
            n=Integer.parseInt(strings[0]);
            m=Integer.parseInt(strings[1]);
            s= bf.readLine();;
            strings=s.split(" ");
            for(int j=0;j<n;j++){
                arrA.add(Integer.parseInt(strings[j]));
            }
            s= bf.readLine();;
            strings=s.split(" ");
            for(int j=0;j<m;j++){
                arrB.add(Integer.parseInt(strings[j]));
            }
            Collections.sort(arrB);
            int total=0;
            for(int j=0;j<n;j++){
                int num=arrA.get(j);
                for(int k=0;k<m;k++){
                    if(num>arrB.get(k)) total++;
                    else break;
                }
            }
            buffer.append(total+"\n");
        }
        System.out.println(buffer);

    }


}