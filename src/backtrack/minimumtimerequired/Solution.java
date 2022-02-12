package src.backtrack.minimumtimerequired;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/08 20:02:17
 * description:
 * 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 *
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 *
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：jobs = [3,2,3], k = 3
 * 输出：3
 * 解释：给每位工人分配一项工作，最大工作时间是 3 。
 * 示例 2：
 *
 * 输入：jobs = [1,2,4,7,8], k = 2
 * 输出：11
 * 解释：按下述方式分配工作：
 * 1 号工人：1、2、8（工作时间 = 1 + 2 + 8 = 11）
 * 2 号工人：4、7（工作时间 = 4 + 7 = 11）
 * 最大工作时间是 11 。
 *  
 *
 * 提示：
 *
 * 1 <= k <= jobs.length <= 12
 * 1 <= jobs[i] <= 10^7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs
 *
 * 参考：https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs/solution/gong-shui-san-xie-yi-ti-shuang-jie-jian-4epdd/
 */
public class Solution {
    int res = 0x3f3f3f3f;

    public int minimumTimeRequired(int[] jobs, int k) {
        int n = jobs.length;
        int[] sum = new int[k];
        dfs(0, 0, sum, jobs, 0, n, k);
        return res;
    }

    // sum数组用来记录每个工人的工作量 如sum[0] = m，代表第0位工人此时工作量为m
    // assigned表示已经分配了任务的工人数
    // index表示当前处理到了哪一个job
    public void dfs(int index, int assigned, int[] sum, int[] jobs, int curRes, int n, int k) {
        if (curRes >= res) return; // 剪枝，在递归的过程中剪掉大于当前分配方案res的方案
        // jobs数组分配完毕
        if (index == n) {
            res = curRes; // 大于等于res的方案都被剪枝剪掉了，此时curRes一定小于res
            return;
        }
        // 已分配人数小于k，优先将任务分配给此时没有被分配任务的工人
        if (assigned < k) {
            sum[assigned] = jobs[index];
            dfs(index + 1, assigned + 1, sum, jobs, Math.max(sum[assigned], curRes), n, k);
            sum[assigned] = 0; // 回溯
        }
        for (int i = 0; i < assigned; i++) {
            sum[i] += jobs[index];
            dfs(index + 1, assigned, sum, jobs, Math.max(sum[i], curRes), n, k);
            sum[i] -= jobs[index];
        }
    }
}
