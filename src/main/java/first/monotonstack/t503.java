package first.monotonstack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class t503 {
    public static void main(String[] args) {
        t503 obj = new t503();
        obj.nextGreaterElements(new int[]{1, 2, 3, 4, 3});
    }

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.fill(res, -1);
        for (int i = 0; i < len * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                res[stack.pop()] = nums[i % len];
            }
            stack.push(nums[i % len]);
        }
        return res;
    }
}
