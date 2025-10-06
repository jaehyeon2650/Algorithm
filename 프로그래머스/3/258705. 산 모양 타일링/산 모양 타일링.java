class Solution {
    private static final int MOD = 10007;
    
    public int solution(int n, int[] tops) {
        int[][] dp = new int[n][2];
        dp[0][0]=tops[0]==0?2:3;
        dp[0][1] = 1;
        
        for(int i=1;i<n;i++){
            int x1 = tops[i]==0?1:2;
            int x2 = tops[i]==0?2:3;
            dp[i][0] = ((dp[i-1][0]*x2)+(dp[i-1][1]*x1))%MOD;
            dp[i][1] = (dp[i-1][0]+dp[i-1][1])%MOD;
        }
        
        return (dp[n-1][0]+dp[n-1][1])%MOD;
    }
}