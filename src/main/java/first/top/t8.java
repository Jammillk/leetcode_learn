package first.top;

public class t8 {
    public static void main(String[] args) {
        t8 obj = new t8();
        System.out.println(obj.myAtoi("-2147483648"));
    }

    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int index = 0;
        int n = s.length();
        // 去掉前导空格
        // 越界
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }
        if (index == n) {
            return 0;
        }
        boolean negative = false;
        if (s.charAt(index) == '-') {
            negative = true;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        } else if (!Character.isDigit(s.charAt(index))) {
            return 0;
        }
        int ans = 0;
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10){
                return negative ? Integer.MIN_VALUE :Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            index++;
        }
        return negative ? -ans : ans;
    }

    /**
     * 错了
     * "words and 987" 这种结果是0
     *
     * @param s
     * @return
     */
    public int myAtoi2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean negative = false;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-') {
                negative = true;
            }
            if (Character.isDigit(c)) {
                if (!negative && res > Integer.MAX_VALUE / 10) {
                    return Integer.MAX_VALUE;
                } else if (negative && res < Integer.MIN_VALUE / 10) {
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + c - '0';
            }
        }
        return negative ? -res : res;
    }
}
