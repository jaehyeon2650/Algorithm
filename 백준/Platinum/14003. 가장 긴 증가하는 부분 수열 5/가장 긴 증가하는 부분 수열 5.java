    import java.io.*;
    import java.util.*;

    class Main {
        static class Pair{
            public Long x;
            public int y;

            public Pair(Long x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        public static Long[] result;
        public static int maxLength=0;
        public static int n;
        public static Stack<Long> st=new Stack<>();
        public static Vector<Pair> v=new Vector<>();
        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringBuffer stringBuffer=new StringBuffer();
            n=Integer.parseInt(bf.readLine());
            result=new Long[n];
            Arrays.fill(result,Long.MAX_VALUE);
            String s= bf.readLine();
            String[] strings = s.split(" ");
            v.add(new Pair(Long.parseLong(strings[0]),0));
            result[0]=Long.parseLong(strings[0]);
            for(int i=1;i<n;i++) {
                Long now=Long.parseLong(strings[i]);
                int index = Arrays.binarySearch(result, 0, maxLength + 1, now);
                if(index<0&&(-index-1)!=maxLength+1){
                    result[-index-1]=now;
                }else if(index<0&&(-index-1)==maxLength+1){
                    result[-index-1]=now;
                    maxLength++;
                }
                if(index<0) v.add(new Pair(now,-index-1));
            }
            System.out.println(maxLength+1);
            for(int i=v.size()-1;i>=0;i--){
                Pair now=v.get(i);
                if(now.y==maxLength){
                    st.add(now.x);
                    maxLength--;
                }
            }
            while(!st.isEmpty()){
                stringBuffer.append(st.pop()+" ");
            }
            System.out.println(stringBuffer);

        }

    }