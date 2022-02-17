package first.bytype.dp.bag;

import java.util.Arrays;

public class t494 {
    // left + right = sum
    // left - right = target
    // left = (sum + target) / 2
    public int findTargetSumWays(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int sum = Arrays.stream(nums).sum();
        if (Math.abs(target) > sum){
            return 0;
        }
        if ((target + sum) % 2 != 0){
            return 0;
        }
        int size = (sum + target) / 2;
        if (size < 0){
            size = -size;
        }
        // dp[j] 表示：填满j（包括j）这么大容积的包，有dp[j]种方法
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = size; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[size];
    }
}
