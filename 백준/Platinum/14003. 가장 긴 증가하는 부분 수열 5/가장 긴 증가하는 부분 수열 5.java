    import java.io.*;
    import java.util.Arrays;
    import java.util.Collections;
    import java.util.Stack;
    import java.util.Vector;

    class Main {
        static class Pair{
            public Long x;
            public int y;

            public Pair(Long x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        public static int n;
        public static Long[] a;
        public static Long[] result;
        public static Vector<Pair> v=new Vector<>();

        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(bf.readLine());
            String s = bf.readLine();
            String[] strings = s.split(" ");
            a = new Long[n];
            result = new Long[n];
            Arrays.fill(result,Long.MAX_VALUE);
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(strings[i]);
            }
            int index=0;
            for(int i=0;i<n;i++){
                int ind = Arrays.binarySearch(result,0,index+1, a[i]);
                if(ind<0){
                    result[-ind-1]=a[i];
                    v.add(new Pair(a[i],-ind-1));
                    index=Math.max(index,-ind-1);
                }
            }
            System.out.println(index+1);
            Stack<Long> st=new Stack<>();
            for(int i=v.size()-1;i>=0;i--){
                Pair pair = v.get(i);
                if(pair.y==index){
                    st.push(pair.x);
                    index--;
                }
            }
            StringBuffer b=new StringBuffer();
            while(!st.isEmpty()){
                b.append(st.pop()+" ");
            }
            System.out.println(b);
        }
    }