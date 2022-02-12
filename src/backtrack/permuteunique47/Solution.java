package src.backtrack.permuteunique47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/16 19:26:25
 * description:
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 *
 * 参考
 * https://mp.weixin.qq.com/s/9L8h3WqRP_h8LLWNT34YlA
 * https://leetcode-cn.com/problems/permutations-ii/solution/47-quan-pai-lie-iiche-di-li-jie-pai-lie-zhong-de-q/
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        // 对数组进行排序，方便去重
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtracking(res, path, nums, used);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 不能在同一层中使用重复的元素，而在不同层使用重复元素时，nums[i] == nums[i - 1]，但是此时used[i - 1] == true
            // 而如果在同一层使用了重复元素时，used[i - 1]此时为false

            // 以 1 2 2 为例，第一次取1，used[0]为true，第二次取2(1)，used[1]为true，第三次取2(2)，used[2]为true，进行回溯
            // 2(2)被移除，used[2]还原为false，2(1)被移除，used[1]还原为false
            // 取2(2)，此时used[i - 1]为false，且nums[i] == nums[i - 1]，这种情况之前已经处理过，不应该再次处理，需要跳过
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                backtracking(res, path, nums, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = {1,1,2};
        List<List<Integer>> res = s.permuteUnique(test);
        System.out.println(res);
    }
}
