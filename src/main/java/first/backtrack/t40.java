package first.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t40 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int[] candidates, int target, int begin, ArrayList<Integer> list) {
        if (target < 0){
            return ;
        }
        if (target == 0){
            res.add(new ArrayList<>(list));
            return ;
        }
        for(int i = begin;i < candidates.length;i++){
            if (target - candidates[i] < 0){
                return ;
            }
            if (i > begin && candidates[i] == candidates[i - 1]){
                continue;
            }
            list.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
