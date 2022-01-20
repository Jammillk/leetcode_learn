package first.greddy;

public class t714 {
    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int buy = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length - 1; i++) {
            // 买入价最低，每次更新都是有手续费的
            buy = Math.min(buy, prices[i] + fee);
            // 若能有收益
            if (prices[i + 1] > buy) {
                profit += prices[i + 1] - buy;
                // 更新买入价，但是不加手续费（因为已经减过了）
                buy = prices[i + 1];
            }
        }
        return profit;
    }

    public int maxProfit2(int[] prices, int fee) {
        int buy = prices[0] + fee;
        int sum = 0;
        for (int p : prices) {
            if (p + fee < buy) {
                buy = p + fee;
            } else if (p > buy) {
                sum += p - buy;
                buy = p;
            }
        }
        return sum;
    }
}
