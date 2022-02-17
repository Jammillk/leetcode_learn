package first.bytype.greddy;

public class t134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int min = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            min = Math.min(min, sum);
        }
        if (sum < 0) {
            return -1;
        }
        // 有得剩
        if (min >= 0) {
            return 0;
        }
        for(int i = gas.length - 1;i > 0;i--){
            // 抹平从0开始的计数，即从此开始可以绕一圈
            min += gas[i] - cost[i];
            if (min >= 0){
                return i;
            }
        }
        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                start = i + 1;
                curSum = 0;
            }
        }
        if (totalSum < 0) {
            return -1;
        }
        return start;
    }
}
