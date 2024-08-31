    import java.io.*;
    import java.util.*;

    class Main {
        static class Pair implements Comparable<Pair> {
            public int x;
            public int y;

            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public int compareTo(Pair o) {
                return x-o.x;
            }
        }
        public static Vector<Pair> v=new Vector<>();
        public static int[] result;
        public static int n;
        public static int maxnum=0;

        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(bf.readLine());
            result=new int[n];
            for(int i=0;i<n;i++){
                String s=bf.readLine();
                String[] strings = s.split(" ");
                v.add(new Pair(Integer.parseInt(strings[0]),Integer.parseInt(strings[1])));
            }
            Collections.sort(v);
            for(int i=0;i<n;i++){
                int maxn=0;
                for(int j=0;j<i;j++){
                    if(v.get(i).y>v.get(j).y&&maxn<result[j]){
                        maxn=result[j];
                    }
                }
                result[i]=maxn+1;
                maxnum=Math.max(maxnum,result[i]);
            }
            System.out.println(n-maxnum);
        }
    }