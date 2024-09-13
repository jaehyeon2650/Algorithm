    import java.io.*;

    class Main {

        public static int n;
        public static int maxn=0;
        public static int[] a;
        public static int[] b;
        public static int[] dp=new int[100];
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n=Integer.parseInt(br.readLine());
            a=new int[n];
            b=new int[n];
            String s=br.readLine();
            String[] s1 = s.split(" ");
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s1[i]);
            }
            s=br.readLine();
            s1 = s.split(" ");
            for(int i=0;i<n;i++){
                b[i]=Integer.parseInt(s1[i]);
            }
            for(int i=0;i<n;i++){
                for(int j=99;j>=a[i];j--){
                    if(dp[j]<dp[j-a[i]]+b[i]){
                        dp[j]=dp[j-a[i]]+b[i];
                        maxn=Math.max(dp[j],maxn);
                    }
                }
            }
            System.out.println(maxn);
        }



    }