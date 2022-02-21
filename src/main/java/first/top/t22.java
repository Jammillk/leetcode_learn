package first.top;

import java.util.ArrayList;
import java.util.List;

public class t22 {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0, new StringBuilder());
        return res;
    }

    private void backtrack(int n, int left, int right, StringBuilder sb) {
        if (left == n && right == n) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append("(");
            backtrack(n, left + 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(")");
            backtrack(n, left, right + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
