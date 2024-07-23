import java.util.*;
class Main {
    public static int n; // 노드의 전체 개수
    public static int visited[];
    public static int comp[]; //색칠
    public static int totalPeople; // 전체 인구수
    public static int minn=Integer.MAX_VALUE; // 인구수 차이 최소
    public static int sums=0;

    static class Node{
        //인구 수
        int n;
        // 연결된 노드들
        Vector<Integer> connectNodes;
        // 연결된 노드 수
        int total;
        public Node(int n){
            this.n=n;
            connectNodes=new Vector<>();
        }
    }
    public static Vector<Node> nodes=new Vector<>();

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        visited=new int[n];
        comp=new int[n];
        for(int i=0;i<n;i++){
            int a=scan.nextInt();
            totalPeople+=a;
            nodes.add(new Node(a));
        }
        for(int i=0;i<n;i++){
            int a=scan.nextInt();
            nodes.get(i).total=a;
            for(int j=0;j<a;j++){
                int b=scan.nextInt();
                nodes.get(i).connectNodes.add(b-1);
            }
        }

        System.out.println(solution());
    }
    public static void dfs(int ind,int color){ // 컴포넌트가 하나일때 dfs로 최소 인구수 차이 계산 후 갱신
        Node cur=nodes.get(ind);
        sums+=cur.n;
        for(int i=0;i<cur.total;i++){
            if((visited[cur.connectNodes.get(i)]==0)&&(comp[cur.connectNodes.get(i)])==color){
                visited[cur.connectNodes.get(i)]=1;
                dfs(cur.connectNodes.get(i),color);
            }
        }
    }


    public static int solution(){
        for(int i=1;i<(1<<n)-1;i++){
            Arrays.fill(comp,0);
            Arrays.fill(visited,0);
            int ind1=-1;
            int ind2=-1;
            for(int j=0;j<n;j++){
                if((i&(1<<j))>0){
                    comp[j]=1;
                    ind2=j;
                }else{
                    ind1=j;
                }
            }
            visited[ind1]=1;
            dfs(ind1,0);
            int sums1=sums;
            sums=0;
            visited[ind2]=1;
            dfs(ind2,1);
            int sums2=sums;
            sums=0;
            if(sums1+sums2==totalPeople){
                minn=Math.min(minn,Math.abs(sums1-sums2));
            }
        }
        if(minn==Integer.MAX_VALUE) return -1;
        else return minn;
    }

}