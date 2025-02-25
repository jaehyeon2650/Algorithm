import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static int n = -1;
    public static int m = -1;
    public static int cnt = 0;
    public static int count = 0;

    public static int[][] a;
    public static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            count++;
            String input = bf.readLine();
            String[] split = input.split(" ");
            n=Integer.parseInt(split[0]);
            m=Integer.parseInt(split[1]);
            if(n==0 && m==0) break;
            a= new int[n+1][n+1];
            visited = new int[n+1];
            cnt=0;
            for(int i=0;i<m;i++){
                String s = bf.readLine();
                String[] split1 = s.split(" ");
                int a1 = Integer.parseInt(split1[0]);
                int a2 = Integer.parseInt(split1[1]);
                a[a1][a2]=1;
                a[a2][a1]=1;
            }
            for(int i=1;i<=n;i++){
                if(visited[i]==0){
                    if(bfs(i)){
                        cnt++;
                    }
                }
            }
            printResult(cnt,count);
        }
    }

    public static boolean bfs(int x){
        Queue<Integer> queue = new ArrayDeque<>();
        int dot = 0;
        int edge = 0;
        queue.add(x);
        while (!queue.isEmpty()){
            Integer now = queue.poll();
            visited[now]=1;
            dot++;
            for(int i=1;i<=n;i++){
                if(a[now][i]==1){
                    edge++;
                    if(visited[i]==0){
                        queue.add(i);
                    }
                }
            }
        }
        return dot-1==(edge/2);
    }

    public static void printResult(int x,int testNumber){
        System.out.printf("Case %d: ",testNumber);
        if(x==0){
            System.out.println("No trees.");
        }else if(x==1){
            System.out.println("There is one tree.");
        }else{
            System.out.printf("A forest of %d trees.\n",x);
        }
    }
}