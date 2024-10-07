import java.io.*;

public class Main {
    public static int n;
    public static int m;
    public static int k;
    public static long[] prefix;
    public static long[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb=new StringBuffer();
        String s=bf.readLine();
        String[] s1 = s.split(" ");
        n=Integer.parseInt(s1[0]);
        m=Integer.parseInt(s1[1]);
        k=Integer.parseInt(s1[2]);
        prefix=new long[n+1];
        nums=new long[n+1];
        for(int i=1;i<=n;i++){
            long a=Long.parseLong(bf.readLine());
            nums[i]=a;
            update(i,a);
        }
        for(int i=0;i<m+k;i++){
            s=bf.readLine();
            s1=s.split(" ");
            if(Integer.parseInt(s1[0])==1){
                int index=Integer.parseInt(s1[1]);
                long num=Long.parseLong(s1[2]);
                long diff=num-nums[index];
                update(index,diff);
                nums[index]=num;
            }else{
                int index1=Integer.parseInt(s1[1]);
                int index2=Integer.parseInt(s1[2]);
                sb.append(sum(index2)-sum(index1-1)+"\n");
            }
        }
        System.out.println(sb);
    }

    public static void update(int ind,long diff){
        while(ind<=n){
            prefix[ind]+=diff;
            ind+=ind&(-ind);
        }
    }
    public static long sum(int ind){
        long sum=0;
        while(ind>0){
            sum+=prefix[ind];
            ind-=ind&(-ind);
        }
        return sum;
    }
}
