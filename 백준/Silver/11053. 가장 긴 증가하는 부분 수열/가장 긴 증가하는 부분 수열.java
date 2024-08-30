    import java.io.*;
    import java.util.Arrays;

    class Main {
        public static int n;
        public static int[] a;
        public static int[] result;

        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(bf.readLine());
            String s = bf.readLine();
            String[] strings = s.split(" ");
            a = new int[n];
            result = new int[n];
            Arrays.fill(result,Integer.MAX_VALUE);
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(strings[i]);
            }
            int maxLength=0;
            for(int i=0;i<n;i++){
                int ind = Arrays.binarySearch(result, 0, maxLength + 1, a[i]);
                if(ind<0){
                    result[-ind-1]=a[i];
                    maxLength=Math.max(maxLength,-ind-1);
                }
            }
            System.out.println(maxLength+1);
        }
    }