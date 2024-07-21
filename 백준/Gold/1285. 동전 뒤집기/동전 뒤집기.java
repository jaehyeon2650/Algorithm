import java.util.*;
class Main {
    public static Vector<Integer> col=new Vector<>();
    public static Vector<Integer> row=new Vector<>();

    public static int arr[][];
    public static int n;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        arr=new int[n][n];
        for(int i=0;i<n;i++){
            String s=scan.next();
            for(int j=0;j<n;j++){
                if(s.charAt(j)=='H'){
                    arr[i][j]=1;
                }else{
                    arr[i][j]=0;
                }
            }
        }
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=n-1;j>=0;j--){
                if(arr[i][j]==1){
                    sum+=(1<<(n-j-1));
                }
            }
            row.add(sum);
        }
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=n-1;j>=0;j--){
                if(arr[j][i]==1){
                    sum+=(1<<(n-j-1));
                }
            }
            col.add(sum);
        }
        solution();
    }

    public static void solution(){
        int maxn=Integer.MAX_VALUE;
        Vector<Integer> v=new Vector<>();
        for(int i=0;i<(1<<n);i++){
            for(int j=0;j<n;j++){
                if((i&(1<<j))==0){
                    v.add(~row.get(n-j-1));
                }else{
                    v.add(row.get(n-j-1));
                }
            }
            maxn=Math.min(maxn,count(v));
            v.clear();
        }
        System.out.println(maxn);
    }

    public static int count(Vector<Integer> v){
        int sum=0;
        for(int i=1;i<=(1<<(n-1));i*=2){
            int cnt=0;
            for(int j=0;j<n;j++){
                if((v.get(j)&i)==0){
                    cnt++;
                }
            }
            sum+=Math.min(cnt,n-cnt);
        }
        return sum;
    }
}