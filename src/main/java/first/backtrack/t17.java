package first.backtrack;

import java.util.*;

public class t17 {
    public static void main(String[] args) {
        t17 obj = new t17();
        List<String> strings = obj.letterCombinations("23");
        System.out.println(strings);
    }
    List<String> mapping = Arrays.asList("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return res;
        }
        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(String digits, int index, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = index; i < digits.length(); i++) {
            String s = mapping.get(digits.charAt(index) - '0' - 2);
            for(int j = 0;j < s.length();j++){
                sb.append(s.charAt(j));
                backtrack(digits, i + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
