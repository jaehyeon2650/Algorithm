import java.io.*;
import java.util.*;
class Main {

    public static int t;
    public static int nodeCnt;
    public static int edgeCnt;
    public static int[] visited=new int[1004];
    public static Vector<Vector<Integer>> nodes=new Vector<>();
    public static boolean tree;

    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);
        t=scan.nextInt();
        for(int i=0;i<t;i++){
            nodes.clear();
            nodeCnt=scan.nextInt();
            Arrays.fill(visited,0);
            tree=true;
            edgeCnt=scan.nextInt();
            for(int j=0;j<=nodeCnt;j++){
                nodes.add(new Vector<>());
            }
            for(int j=0;j<edgeCnt;j++){
                int a,b;
                a=scan.nextInt();
                b=scan.nextInt();
                nodes.get(a).add(b);
                nodes.get(b).add(a);
            }
            dfs(1);
            for(int j=1;j<=nodeCnt;j++){
                if(visited[j]==0){
                    tree=false;
                    break;
                }
            }
            if(nodeCnt!=edgeCnt+1){
                tree=false;
            }
            if(tree){
                System.out.println("tree");
            }else{
                System.out.println("graph");
            }
        }
    }
    public static void dfs(int ind) {
        visited[ind]=1;
        for(int i=0;i<nodes.get(ind).size();i++){
            if(visited[nodes.get(ind).get(i)]==0){
                dfs(nodes.get(ind).get(i));
            }
        }
    }
}