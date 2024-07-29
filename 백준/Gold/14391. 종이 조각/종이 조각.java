import java.io.*;
import java.util.*;
class Main {
    //행
    public static int n;
    //열
    public static int m;

    public static int[][] nums;
    public static int[][] visited;
    public static int maxn=0;

    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        m=scan.nextInt();
        nums=new int[n][m];
        visited=new int[n][m];
        for(int i=0;i<n;i++){
            String s=scan.next();
            for(int j=0;j<s.length();j++){
                nums[i][j]= Character.getNumericValue(s.charAt(j));
            }
        }
        Vector<Integer> v=new Vector<>();
        makeBit(v);
        System.out.println(maxn);
    }
    public static void makeBit(Vector<Integer> v){
        if(v.size()==n){
            makeVisitedZero();
            maxn=Math.max(maxn,start(v));
            return;
        }
        for(int i=0;i<(1<<m);i++){
            v.add(i);
            makeBit(v);
            v.remove(v.size()-1);
        }
    }
    public static void makeVisitedZero(){
        for(int i=0;i<n;i++){
            Arrays.fill(visited[i],0);
        }
    }

    public static int start(Vector<Integer> v){
        int total=0;
        for(int i=0;i<n;i++){
            int num=v.get(i);
            int same=1;
            int sum=0;
            for(int j=m-1;j>=0;j--){
                if((num&(1<<(m-1-j)))>0){
                    visited[i][j]=1;
                    sum+=(nums[i][j]*same);
                    same*=10;
                }else{
                    same=1;
                }
            }
            total+=sum;
        }
        for(int i=0;i<m;i++){
            int sum=0;
            int same=1;
            for(int j=n-1;j>=0;j--){
                if(visited[j][i]==0){
                    sum+=(nums[j][i]*same);
                    same*=10;
                }else{
                    same=1;
                }
            }
            total+=sum;
        }
        return total;
    }

}