package first.bytype.dp;

public class t718 {
    public int findLength(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return 0;
        }
        int m = nums1.length;
        int n = nums2.length;
        int res = 0;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = n; j > 1; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    dp[j] = 0;
                }
                if (dp[j] > res){
                    res = dp[j];
                }
            }
        }
        return res;
    }

    // 子序列默认不连续，子数组默认连续!
    public int findLength2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return 0;
        }
        int m = nums1.length;
        int n = nums2.length;
        int res = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > res) {
                    res = dp[i][j];
                }
            }
        }
        return res;
    }
}
