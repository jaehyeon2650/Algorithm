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
        solution();
    }
    public static void solution(){
        for(int s=0;s<(1<<(n*m));s++){
            int sum=0;
            for(int i=0;i<n;i++){
                int cur=0;
                for(int j=0;j<m;j++){
                    int k=m*i+j;
                    if((s&(1<<k))==0){
                        cur=cur*10+nums[i][j];
                    }else{
                        sum+=cur;
                        cur=0;
                    }
                }
                sum+=cur;
            }
            for(int i=0;i<m;i++){
                int cur=0;
                for(int j=0;j<n;j++){
                    int k=m*j+i;
                    if((s&(1<<k))>0){
                        cur=cur*10+nums[j][i];
                    }else{
                        sum+=cur;
                        cur=0;
                    }
                }
                sum+=cur;
            }
            maxn=Math.max(maxn,sum);
        }
        System.out.println(maxn);
    }
}