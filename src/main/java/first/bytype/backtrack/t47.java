package first.bytype.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t47 {
    public static void main(String[] args) {
        t47 obj = new t47();
        obj .permuteUnique(new int[]{1,1,2});

    }
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited);
        return res;
    }

    private void backtrack(int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            backtrack(nums, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
