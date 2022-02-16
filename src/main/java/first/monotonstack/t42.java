package first.monotonstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class t42 {
    public static void main(String[] args) {
        t42 obj = new t42();
        obj.trap(new int[]{
                0, 1, 1, 1, 1, 0, 1, 2, 2, 1, 2, 1
        });
    }

    public int trap(int[] height) {
        int sum = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                sum += leftMax - height[left];
                left++;
            } else {
                sum += rightMax - height[right];
                right--;
            }
        }
        return sum;
    }

    public int trap4(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int len = height.length;
        int sum = 0;
        for (int i = 1; i < len; i++) {
            if (height[i] < height[stack.peek()]) {
                stack.push(i);
            } else if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int h = Math.min(height[stack.peek()], height[i]) - height[mid];
                        int w = i - stack.peek() - 1;
                        sum += h * w;
                    }
                }
                stack.push(i);
            }
        }
        return sum;
    }

    public int trap3(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int length = height.length;
        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];

        maxLeft[0] = height[0];
        for (int i = 1; i < length; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }
        maxRight[length - 1] = height[0];
        for (int i = length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            int count = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (count > 0) {
                sum += count;
            }
        }
        return sum;
    }

    public int trap2(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            if (i == 0 || i == height.length - 1) {
                continue;
            }
            int leftHeight = height[i];
            int rightHeight = height[i];
            for (int r = i + 1; r < height.length; r++) {
                if (height[r] > rightHeight) {
                    rightHeight = height[r];
                }
            }
            for (int l = i - 1; l >= 0; l--) {
                if (height[l] > leftHeight) {
                    leftHeight = height[l];
                }
            }
            int h = Math.min(leftHeight, rightHeight) - height[i];
            if (h > 0) {
                sum += h;
            }
        }
        return sum;
    }
}
