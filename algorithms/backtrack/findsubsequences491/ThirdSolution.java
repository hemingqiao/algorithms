package blogandquestion.algorithms.backtrack.findsubsequences491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/16 10:29:00
 * description:
 */
public class ThirdSolution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(res, path, nums, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> path, int[] nums, int startIndex) {
        // 只要当前的递增序列大于1，就加入到结果列表中
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
            // 注意这里没有加return，因为要取到树的同一个树枝上的所有节点
        }

        int[] visited = new int[201]; // 题目限定范围为[-100,100]，所以可以使用一个数组来记录某个元素是否使用过
        for (int i = startIndex; i < nums.length; i++) {
            // 如果path非空且nums[i]小于path的最后一个元素或者使用过nums[i]这个元素值，则跳过
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || visited[nums[i] + 100] == 1) continue;
            visited[nums[i] + 100] = 1; // 记录使用过这个元素值
            path.add(nums[i]);
            backtracking(res, path, nums, i + 1); // 递归
            path.remove(path.size() - 1); // 回溯
        }
    }

    public static void main(String[] args) {
        int[] test = {4,3,2,1};
        ThirdSolution ts = new ThirdSolution();
        List<List<Integer>> res = ts.findSubsequences(test);
        System.out.println(res);
    }
}

class FourthSolution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(res, path, nums, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> path, int[] nums, int startIndex) {
        // 只要当前的递增序列大于1，就加入到结果列表中
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
            // 注意这里没有加return，因为要取到树的同一个树枝上的所有节点
        }

        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            // 如果path非空且nums[i]小于path的最后一个元素或者使用过nums[i]这个元素值，则跳过
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || set.contains(nums[i])) continue;
            set.add(nums[i]); // 记录使用过这个元素值
            path.add(nums[i]);
            backtracking(res, path, nums, i + 1); // 递归
            path.remove(path.size() - 1); // 回溯
        }
    }
}
