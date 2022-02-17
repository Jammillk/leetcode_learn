package first.bytype.dp.bag;

public class TestBag {
    //先遍历物品，再遍历背包
    private static void testCompletePack(){
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++){
            for (int j = 1; j <= bagWeight; j++){
                if (j - weight[i] >= 0){
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
        }
        for (int maxValue : dp){
            System.out.println(maxValue + "   ");
        }
    }

    //先遍历背包，再遍历物品
    private static void testCompletePackAnotherWay(){
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        int[] dp = new int[bagWeight + 1];
        for (int i = 1; i <= bagWeight; i++){
            for (int j = 0; j < weight.length; j++){
                if (i - weight[j] >= 0){
                    dp[i] = Math.max(dp[i], dp[i - weight[j]] + value[j]);
                }
            }
        }
        for (int maxValue : dp){
            System.out.println(maxValue + "   ");
        }
    }
    public static void main(String[] args) {
        testCompletePackAnotherWay();
    }

    private static boolean baseSol(int[] weight, int[] value, int bagWeight) {
        int w = weight.length;
        int v = value.length;
        // dp[i][j]表示任取下标为0-i的物品，放入容量为j的背包的最大价值
        int[][] dp = new int[w][bagWeight + 1];
        for (int j = weight[0]; j <= bagWeight; j++) {
            dp[0][j] = value[0];
        }
        // 对于每一件物品
        for (int i = 1; i <= w; i++) {
            // 对于每个容量
            for (int j = 0; j <= bagWeight; j++) {
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j],
                            dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        return false;
    }
}
