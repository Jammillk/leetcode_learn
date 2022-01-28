package first.dp;

public class t115 {
    public static void main(String[] args) {
        System.out.println(numDistinct("baeggg", "bag"));

    }
    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <= n;j++){
                if(j > i){
                    break;
                }
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    public int numDistinct2(String s, String t) {
        int m = s.length();
        int n = t.length();
        // dp[i][j]：以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]。
        // s = "babgbag", t = "bag"
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // rara ra
                // rarb ra
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // 匹配s[i]+不匹配s[i]
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
