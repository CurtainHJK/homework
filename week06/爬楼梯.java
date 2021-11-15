class Solution {
    public int climbStairs(int n) {
        if(n < 2) {
            return 1;
        }
        // dp[i]表示到达第i阶楼梯的方法数
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}