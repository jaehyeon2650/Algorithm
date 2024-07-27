import java.util.*;
class Main {
    public static int n;
    public static int l;

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        l=scan.nextInt();
        int a[][]=new int[n][n];
        int b[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]=scan.nextInt();
                b[j][i]=a[i][j];
            }
        }
        int sums=solution(a)+solution(b);
        System.out.println(sums);
    }
    public static int solution(int[][] a){
        int total=0;
        for(int i=0;i<n;i++){
            int cnt=1;
            int j=0;
            for(j=0;j<n-1;j++){
                if(a[i][j]==a[i][j+1]) cnt++;
                //오르막길
                else if((a[i][j]==(a[i][j+1]-1))&&cnt>=l) cnt=1;
                //내리막길
                else if((a[i][j]==(a[i][j+1]+1))&&cnt>=0) cnt=-l+1;
                else break;
            }
            if(j==n-1&&cnt>=0) total++;
        }
        return total;
    }
}