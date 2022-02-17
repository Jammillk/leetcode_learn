package first.bytype.dp.bag;

import java.util.Arrays;

public class t416 {
    public boolean canPartition33(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 1){
            return false;
        }
        int m = sum >> 1;
        boolean[] f = new boolean[m + 1];
        f[0] = true;
        // 从0-i个物品中
        for(int i = 0;i < n;i++){
            // 对于不同的背包容量
            for(int j = m;j >= nums[i];j--){
                f[j] |= f[j - nums[i]];
            }
        }
        return f[m];
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 1){
            return false;
        }
        int m = sum >> 1;
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        // 从1-i个物品中
        for(int i = 1;i <= n;i++){
            // 对于不同的背包容量
            for(int j = 1;j <= m;j++){
                if(j >= nums[i - 1]){
                    f[i][j] = f[i - 1][j] || f[i - 1][j - nums[i - 1]];
                }else{
                    f[i][j] = f[i - 1][j];
                }
            }
        }
        return f[n][m];
    }
    public boolean canPartition3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 1){
            return false;
        }
        int target = sum >> 1;
        // dp[i]表示和0-i间任取元素之和
        int[] dp = new int[target + 1];
        // 对于每一个元素
        for(int i = 0;i < nums.length;i++){
            // 对于每个容量
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return nums[target] == target;
    }

    public boolean canPartition2(int[] nums) {
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
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}
