package blogandquestion.algorithms.backtrack.subsets78;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/17 20:15:21
 * description: 增量构造法：每个元素，都有两个选择，选还是不选
 * 在树的每个节点处，都有两个选择：选择当前元素，或者跳过当前元素，一直遍历到树的叶子节点处，然后将路径加入结果列表
 * 参考：算法珠玑，algorithm-essentials-java.pdf
 */
public class ThirdSolution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(res, path, nums, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> path, int[] nums, int startIndex) {
        if (startIndex == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 不选nums[startIndex]，那么直接进入下一层递归
        backtracking(res, path, nums, startIndex + 1);
        // 选择nums[startIndex]，本层需要进行选择，递归，回溯（撤销选择）
        path.add(nums[startIndex]);
        backtracking(res, path, nums, startIndex + 1); // 递归
        path.remove(path.size() - 1); // 回溯，撤销选择
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ThirdSolution ts = new ThirdSolution();
        List<List<Integer>> res = ts.subsets(nums);
        System.out.println(res);
    }
}
