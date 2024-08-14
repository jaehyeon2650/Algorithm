import java.io.*;
import java.util.*;

class Main {
    public static int minn=Integer.MAX_VALUE;
    public static int maxn=Integer.MIN_VALUE;
    public static int n;
    public static int[] a;
    public static int[] operations=new int[4];
    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=scan.nextInt();
        }
        for(int i=0;i<4;i++){
            operations[i]=scan.nextInt();
        }
        operate(operations,1,a[0]);
        System.out.println(maxn);
        System.out.println(minn);
    }
    public static void operate(int[] operation,int index,int calculate){
        if(index==n){
            maxn=Math.max(maxn,calculate);
            minn=Math.min(minn,calculate);
            return;
        }
        int[] copy=Arrays.copyOf(operation,4);
        for(int i=0;i<4;i++){
            if(copy[i]>0){
                copy[i]--;
                operate(copy,index+1,calculateNum(i,calculate,a[index]));
                copy[i]++;
            }
        }
    }
    public static int calculateNum(int index,int a,int b){
        if(index==0){
            return a+b;
        }else if(index==1){
            return a-b;
        }else if(index==2){
            return a*b;
        }else{
            return a/b;
        }
    }
}