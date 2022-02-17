package first.bytype.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t39 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates, int target, int index, ArrayList<Integer> list) {
        if (target < 0 || index >= candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        dfs(candidates, target, index + 1, list);

        list.add(candidates[index]);
        dfs(candidates, target - candidates[index], index, list);
        list.remove(list.size() - 1);
    }
}
