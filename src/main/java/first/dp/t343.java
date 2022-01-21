package first.dp;

public class t343 {
    public int integerBreak(int n) {
        // dp[i]：分拆数字i，可以得到的最大乘积为dp[i]。
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for(int i = 3;i <= n;i++){
            for(int j = 1;j < i - 1;j++){
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];
    }
}
