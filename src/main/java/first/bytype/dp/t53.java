package first.bytype.dp;

public class t53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int sum = Integer.MIN_VALUE;
        int count = 0;
        for (int num : nums) {
            count += num;
            if (count > sum){
                sum = count;
            }
            if (count < 0){
                count = 0;
            }
        }
        return sum;
    }

    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int res = nums[0];
        // dp[i]：包括下标i之前的最大连续子序列和为dp[i]。
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
