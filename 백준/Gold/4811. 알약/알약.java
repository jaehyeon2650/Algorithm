    import java.io.*;
    import java.math.BigDecimal;

    class Main {

        public static BigDecimal[][][] dp=new BigDecimal[61][31][31];

        public static void main(String[] args) throws IOException {
            for(int i=1;i<=30;i++){
                go(i*2,i,0);
            }
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            int num=Integer.parseInt(bf.readLine());
            while(num!=0){
                System.out.println(dp[num*2][num][0]);
                num=Integer.parseInt(bf.readLine());
            }
        }
        public static BigDecimal go(int index,int hNum,int wNum){
            if(hNum<0||wNum<0) return BigDecimal.ZERO;
            if(index==0) return BigDecimal.ONE;
            if(dp[index][hNum][wNum]!=null) return dp[index][hNum][wNum];
            dp[index][hNum][wNum]=go(index-1,hNum-1,wNum+1).add(go(index-1,hNum,wNum-1));
            return dp[index][hNum][wNum];
        }
    }