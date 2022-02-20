package first.top;

import java.util.HashMap;
import java.util.Map;

public class t13 {
    Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int value = map.get(s.charAt(i));
            if (i + 1 < n && value < map.get(s.charAt(i + 1))) {
                // 直接减了前面小的，然后后面遍历的时候再把大的加上
                res -= value;
            } else {
                res += value;
            }
        }
        return res;
    }

    public int romanToInt2(String s) {
        int res = 0;
        int index = 0;
        int n = s.length();
        while (index < n) {
            char c = s.charAt(index);
            if (c == 'I') {
                if (index + 1 < n && s.charAt(index + 1) == 'V') {
                    res += 4;
                    index += 2;
                } else if (index + 1 < n && s.charAt(index + 1) == 'X') {
                    res += 9;
                    index += 2;
                } else {
                    res += 1;
                    index++;
                }
            } else if (c == 'V') {
                res += 5;
                index++;
            } else if (c == 'X') {
                if (index + 1 < n && s.charAt(index + 1) == 'L') {
                    res += 40;
                    index += 2;
                } else if (index + 1 < n && s.charAt(index + 1) == 'C') {
                    res += 90;
                    index += 2;
                } else {
                    res += 10;
                    index++;
                }
            } else if (c == 'L') {
                res += 50;
                index++;
            } else if (c == 'C') {
                if (index + 1 < n && s.charAt(index + 1) == 'D') {
                    res += 400;
                    index += 2;
                } else if (index + 1 < n && s.charAt(index + 1) == 'M') {
                    res += 900;
                    index += 2;
                } else {
                    res += 100;
                    index++;
                }
            } else if (c == 'D') {
                res += 500;
                index++;
            } else if (c == 'M') {
                res += 1000;
                index++;
            }
        }
        return res;
    }
}
