package first.bytype.backtrack;

import java.util.ArrayList;
import java.util.List;

public class t77 {
    private void ddfs(int n, int k, int begin, List<Integer> list) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (begin > n - k + 1) {
            return;
        }
        // δΈι
        ddfs(n, k, begin + 1, list);

        // ι
        list.add(begin);
        ddfs(n, k - 1, begin + 1, list);
        list.remove(list.size() - 1);
    }


    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1, new ArrayList<>());
        return res;
    }

    private void dfs(int n, int k, int begin, List<Integer> list) {
        if (k == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            dfs(n, k, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
