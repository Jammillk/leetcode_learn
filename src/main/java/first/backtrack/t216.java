package first.backtrack;

import java.util.ArrayList;
import java.util.List;

public class t216 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack2(0, 1, k, n);
        return res;
    }

    private void backtrack(int begin, int k, int n) {
        if (n < 0) {
            return;
        }
        if (path.size() == k) {
            if (n == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = begin; i <= 9 - (k - path.size()) + 1; i++) {
            n -= i;
            path.add(i);
            backtrack(i + 1, k, n);
            path.remove(path.size() - 1);
            n += i;
        }
    }


    private void backtrack2(int sum, int begin, int k, int n) {
        // 剪枝
        if (sum > n) {
            return;
        }
        if (path.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        // 剪枝
        for (int i = begin; i <= 9 - (k - path.size()) + 1; i++) {
            sum += i;
            path.add(i);
            backtrack2(sum, i + 1, k, n);
            path.remove(path.size() - 1);
            sum -= i;
        }
    }
}
