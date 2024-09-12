    import java.io.*;
    import java.util.Collection;
    import java.util.Collections;
    import java.util.Vector;

    class Main {
        static class Pair implements Comparable<Pair>{
            public int x,y;

            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public int compareTo(Pair o) {
                return x-o.x;
            }
        }
        public static int n;
        public static int m;
        public static int[] dp=new int[100004];
        public static Vector<Pair> v=new Vector<>();
        public static int maxn=0;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            String[] s1 = s.split(" ");
            n=Integer.parseInt(s1[0]);
            m=Integer.parseInt(s1[1]);
            for(int i=0;i<n;i++){
                int a,b;
                s=br.readLine();
                s1 = s.split(" ");
                a=Integer.parseInt(s1[0]);
                b=Integer.parseInt(s1[1]);
                v.add(new Pair(a,b));
            }
            Collections.sort(v);
            for (int i=0;i<v.size();i++){
                for(int j=m;j>=v.get(i).x;j--){
                    if(dp[j]<dp[j-v.get(i).x]+v.get(i).y){
                         dp[j]=dp[j-v.get(i).x]+v.get(i).y;
                         maxn=Math.max(maxn,dp[j]);
                    }
                }
            }
            System.out.println(maxn);
        }
    }