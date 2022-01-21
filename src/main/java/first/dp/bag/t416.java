package first.dp.bag;

import java.util.Arrays;

public class t416 {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum >> 1;
        int[] dp = new int[target + 1];
        for (int i = 0; i < n; i++) {
            for(int j = target;j >= nums[i];j--){
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}
