package first.top;

public class t5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int[] range = new int[2];
        for (int i = 0; i < s.length(); i++) {
            i = findLongest(s, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    private int findLongest(String s, int index, int[] range) {
        int left = index, right = index;
        // 左边相同
        while (left - 1 >= 0 && s.charAt(left - 1) == s.charAt(index)) {
            left--;
        }
        while (right + 1 < s.length() && s.charAt(right + 1) == s.charAt(index)) {
            right++;
        }
        // 记录不重复的右索引，返回
        int res = right;
        // 真正的回文判断
        while (left - 1 >= 0 && right + 1 < s.length() && s.charAt(left - 1) == s.charAt(right + 1)) {
            left--;
            right++;
        }
        if (right - left > range[1] - range[0]) {
            range[0] = left;
            range[1] = right;
        }
        return res;
    }

}
