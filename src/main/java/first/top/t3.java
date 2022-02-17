package first.top;

import java.util.HashMap;
import java.util.Map;

public class t3 {
    public static void main(String[] args) {
        t3 obj = new t3();
        obj.lengthOfLongestSubstring("abcabcbb");
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            max = Math.max(max, i - left + 1);
            map.put(c, i);
        }
        return max;
    }


    public int lengthOfLongestSubstring2(String s) {
        int[] last = new int[128];
        int start = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index]);
            res = Math.max(res, i - start + 1);
            last[index] = i + 1;
        }
        return res;
    }
}
