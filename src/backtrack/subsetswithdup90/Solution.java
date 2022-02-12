package src.backtrack.subsetswithdup90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/15 15:26:47
 * description:
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 *
 * 参考
 * https://mp.weixin.qq.com/s/WJ4JNDRJgsW3eUN72Hh3uQ
 * https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/225211
 * https://leetcode-cn.com/problems/subsets-ii/solution/li-jie-li-jie-qu-zhong-cao-zuo-by-jin-ai-yi/
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // 去重前提需要排序
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));
        if (startIndex >= nums.length) return;
        for (int i = startIndex; i < nums.length; i++) {
            // 去重逻辑参考了组合总和II
            // see: https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/225211
            // 去重的逻辑是同一层（树的同一层）不能出现同一个元素，但是树的不同层（树枝）上可以出现不同层的元素
            // 但是在树的每一层的第一个出现的元素需要保留，同一层第一个出现的元素的特征是i == startIndex
            // 而同一层第二个出现的元素其索引i > startIndex，这时就需要跳过这个重复出现的元素
            if (i > startIndex && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = {1,2,2};
        List<List<Integer>> res = s.subsetsWithDup(test);
        System.out.println(res);
    }
}

/**
 * 改变一下结构，把上面解法中的全局变量写入方法中，执行时间从63到99.96，这个真是迷😓
 */
class AnotherSolution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums); // 需要对数组进行排序以方便去重
        backtracking(res, path, nums, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> path, int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            // 去重逻辑参考了组合总和II
            // see: https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/225211
            // 去重的逻辑是同一层（树的同一层）不能出现同一个元素，但是树的不同层（树枝）上可以出现不同层的元素
            // 但是在树的每一层的第一个出现的元素需要保留，同一层第一个出现的元素的特征是i == startIndex
            // 而同一层第二个出现的元素其索引i > startIndex，这时就需要跳过这个重复出现的元素
            if (i > startIndex && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backtracking(res, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
