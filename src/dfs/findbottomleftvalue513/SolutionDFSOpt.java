package src.dfs.findbottomleftvalue513;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/24 10:32:58
 * description: 对DFS的优化，没有使用list记录节点值。
 * 解题思路
 * see: https://leetcode-cn.com/problems/find-bottom-left-tree-value/solution/di-gui-jie-fa-0ms-100-by-wangocean/
 */
public class SolutionDFSOpt {
    int depth = -1;
    int result = -1;
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int num) {
        if (root == null) return;
        // 记录下num第一次大于depth时节点的值
        if (num > depth) {
            result = root.val;
            depth = num; // 将depth值更新为num，使得同一层num == depth，避免同一层的节点值对result进行修改
        }
        num++;
        dfs(root.left, num);
        dfs(root.right, num);
    }
}
