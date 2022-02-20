package first.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t17 {
    List<String> mapping = Arrays.asList("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(String digits, int startIndex, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = startIndex; i < digits.length(); i++) {
            String str = mapping.get(digits.charAt(i) - '0' - 2);
            for (int j = 0; j < str.length(); j++) {
                sb.append(str.charAt(j));
                backtrack(digits, i + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
