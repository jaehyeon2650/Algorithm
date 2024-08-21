import java.io.*;
import java.util.*;

class Main {

    public static int t;
    public static int n;
    public static int m;
    public static boolean can=false;
    public static ArrayList<Integer> arr1=new ArrayList<>();
    public static ArrayList<Integer> arr2=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        t=Integer.parseInt(bf.readLine());
        for(int i=0;i<t;i++){
            arr1.clear();
            arr2.clear();
            n=Integer.parseInt(bf.readLine());
            String s=bf.readLine();
            String[] strings = s.split(" ");
            for(int j=0;j<n;j++){
                arr1.add(Integer.parseInt(strings[j]));
            }
            m=Integer.parseInt(bf.readLine());
            s=bf.readLine();
            strings = s.split(" ");
            for(int j=0;j<m;j++){
                arr2.add(Integer.parseInt(strings[j]));
            }
            Collections.sort(arr1);
            for(int j=0;j<m;j++){
                int check = check(arr2.get(j));
                sb.append(check+"\n");
            }
        }
        System.out.println(sb);
    }
    public static int check(int n){
//        if(start>end) return;
//        int index=(start+end)/2;
//        if(arr1.get(index)==n){
//            can=true;
//        }else if(arr1.get(index)<n){
//            check(n,index+1,end);
//        }else{
//            check(n,start,index-1);
//        }
        int start=0; int end=arr1.size()-1;
        int mid;
        while(start<=end){
            mid=(start+end)/2;
            if(arr1.get(mid)>n) end=mid-1;
            else if(arr1.get(mid)==n) return 1;
            else start=mid+1;
        }
        return 0;
    }
}