package src.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/23 17:04:56
 * description:
 */
public class Solution {
    public List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(res, path, used, nums);
        return res;
    }

    public void dfs(List<List<Integer>> list, List<Integer> path, boolean[] used, int[] nums) {
        if (path.size() == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                dfs(list, path, used, nums);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    public List<Integer> solve(int[] nums) {
        List<List<Integer>> permutations = permutation(nums);
        List<Integer> ret = new ArrayList<>();
        for (List<Integer> p : permutations) {
            int a = p.get(0) * 100 + p.get(1) * 10 + p.get(2);
            int b = p.get(3) * 100 + p.get(4) * 10 + p.get(5);
            int c = p.get(6) * 100 + p.get(7) * 10 + p.get(8);
            if (b == a * 2 && c == a * 3) {
                ret.add((int) (a * 1e6 + b * 1e3 + c));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] test = new int[]{1, 2, 3};
//        List<List<Integer>> res = s.permutation(test);
//        System.out.println(res);
        double currentTime = System.currentTimeMillis();
        List<Integer> res = s.solve(test);
        System.out.println((System.currentTimeMillis() - currentTime) + "ms elapsed");
        System.out.println(res);
    }
}
