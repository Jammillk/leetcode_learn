package first.dp;

public class t1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
            return 0;
        }
        int m = nums1.length;
        int n = nums2.length;
        // 为什么是m+1,n+1呢？因为是方便操作！
        int[][] dp = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
            }
        }
        return 0;
    }

    public int maxUncrossedLines2(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
            return 0;
        }
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <= n;j++){
                if (nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
