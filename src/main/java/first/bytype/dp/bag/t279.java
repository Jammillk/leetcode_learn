package first.bytype.dp.bag;

import java.util.Arrays;

public class t279 {
    public static void main(String[] args) {
        System.out.println(numSquares(14));
    }
    public static int numSquares(int n) {
         int[] dp = new int[n + 1];
         Arrays.fill(dp, Integer.MAX_VALUE);
         dp[0] = 0;
         for(int i = 1;i <= Math.sqrt(n);i++){
             for(int j = i;j <= n;j++){
                 if (j - i * i >= 0){
                     dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                 }
             }
         }
         return dp[n];
    }

        public static int numSquares2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0;i <= n;i++){
            // 边界值
            for(int j = 1;j <= Math.sqrt(i);j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n]  ;
    }
}
