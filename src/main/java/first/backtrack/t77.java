package first.backtrack;

import java.util.ArrayList;
import java.util.List;

public class t77 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1, new ArrayList<>());
        return res;
    }

    private void dfs(int n, int k, int begin, List<Integer> list) {
        if (k == list.size()){
            res.add(new ArrayList<>(list));
            return ;
        }
        for(int i = begin;i <= n;i++){
            list.add(i);
            dfs(n, k - 1, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
