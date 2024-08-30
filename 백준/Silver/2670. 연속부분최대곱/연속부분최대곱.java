    import java.io.*;
    import java.util.*;

    class Main {
        public static double[] a;
        public static double maxFloat=Double.MIN_VALUE;
        public static int n;
        public static void main(String[] args) throws IOException {
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            n=Integer.parseInt(bf.readLine());
            a=new double[n];
            for(int i=0;i<n;i++){
                a[i]=Double.parseDouble(bf.readLine());
            }
            for(int i=0;i<n;i++){
                double d=1.0;
                for(int j=i;j<n;j++){
                    d*=a[j];
                    maxFloat=Math.max(maxFloat,d);
                }
            }
            System.out.println(String.format("%.3f", maxFloat));
        }
    }