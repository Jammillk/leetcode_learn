package first.bytype.monotonstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class t739 {
    public static void main(String[] args) {
        t739 obj = new t739();
        obj.dailyTemperatures(new int[]{
                73, 74, 75, 71, 69, 72, 76, 73
        });
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                res[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return res;
    }
}
