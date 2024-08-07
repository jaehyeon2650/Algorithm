import java.io.*;
import java.util.*;

class Main {
    static class Item{
        private int name;
        private Queue<Integer> indexs=new ArrayDeque<>();

        public Item(int name) {
            this.name = name;
        }

        public Queue<Integer> getIndexs() {
            return indexs;
        }

        public int getName() {
            return name;
        }
    }
    public static int[] a;
    public static int[] visited;
    public static int plugNum;
    public static int n;
    public static Vector<Item> items=new Vector<>();

    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);
        plugNum=scan.nextInt();
        n=scan.nextInt();
        a=new int[n];
        visited=new int[n];
        for(int i=0;i<n;i++){
            a[i]= scan.nextInt();
            if(visited[a[i]-1]==0){
                Item item=new Item(a[i]);
                item.getIndexs().add(i);
                items.add(item);
                visited[a[i]-1]=1;
            }else{
                for(int j=0;j<items.size();j++){
                    if(items.get(j).getName()==a[i]){
                        items.get(j).getIndexs().add(i);
                        break;
                    }
                }
            }
        }
        int ret=0;
        Arrays.fill(visited,0);
        Vector<Integer> v=new Vector<>();
        for(int i=0;i<n;i++){
            for(Item item:items){
                if(item.getName()==a[i]){
                    item.getIndexs().poll();
                    break;
                }
            }
            if(visited[a[i]-1]==1){
                continue;
            }
            if(v.size()<plugNum){
                v.add(a[i]);
            }else{
                int minn=Integer.MIN_VALUE;
                int findItemNum=-1;
                boolean find=false;
                for(int j=0;j<v.size();j++){
                    for(Item item:items){
                        if(v.get(j)==item.getName()){
                            if(item.getIndexs().isEmpty()){
                                find=true;
                                findItemNum=j;
                                break;
                            }else{
                                if(minn<item.getIndexs().peek()){
                                    minn=item.getIndexs().peek();
                                    findItemNum=j;
                                }
                            }
                        }
                    }
                    if(find) break;
                }
                visited[v.get(findItemNum)-1]=0;
                v.remove(findItemNum);
                v.add(a[i]);
                ret++;
            }
            visited[a[i]-1]=1;
        }
        System.out.println(ret);
    }

}