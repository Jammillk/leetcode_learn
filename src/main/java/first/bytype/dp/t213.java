package first.bytype.dp;

public class t213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int n = nums.length;
        int pre1 = nums[left];
        int pre2 = Math.max(nums[left], nums[left + 1]);
        for (int i = left + 2; i <= right; i++) {
            int temp = Math.max(pre2, pre1 + nums[i]);
            pre1 = pre2;
            pre2 = temp;
        }
        return pre2;
    }


    private int rob2(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[left] = nums[left];
        dp[left + 1] = Math.max(nums[left + 1], nums[left]);
        for (int i = left + 2; i <= right; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[right];
    }
}
