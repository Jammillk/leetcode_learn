package first.bytype.backtrack;

import java.util.ArrayList;
import java.util.List;

public class t491 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0);
        return res;
    }


    private void backtrack(int[] nums, int startIndex) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }
        int[] used = new int[201];
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && path.get(path.size() - 1) > nums[i]
                    || used[nums[i] + 100] == 1) {
                continue;
            }
            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

}
