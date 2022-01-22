package first.dp.bag;

import java.util.Arrays;

public class t1049 {
    public int lastStoneWeightII(int[] stones) {
        if(stones == null || stones.length == 0){
            return 0;
        }
        int n = stones.length;
        int sum = Arrays.stream(stones).sum();
        int m = sum >> 1;
        int[] dp = new int[m + 1];

        for (int i = 0; i < n; i++) {
            for(int j = m;j >= stones[i];j--){
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[m] * 2;
    }
}
