package src.dp.rob337;

import java.util.HashMap;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/29 19:42:29
 * description:
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 *
 * 参考：https://leetcode-cn.com/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/
 * 参考：https://leetcode-cn.com/problems/house-robber-iii/solution/da-jia-jie-she-iii-by-leetcode-solution/
 */
public class Solution {
    // 类似递归计算斐波那契数列，下面这个方法进行了大量重复的计算
    // 如一个一个节点的子节点在成为根节点时又会重复计算一次
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int money = root.val;
        if (root.left != null) {
            money += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            money += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(money, rob(root.left) + rob(root.right));
    }
}

class AnotherSolution {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, new HashMap<>());
    }

    public int dfs(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int money = root.val;
        if (root.left != null) {
            money += dfs(root.left.left, map) + dfs(root.left.right, map);
        }
        if (root.right != null) {
            money += dfs(root.right.left, map) + dfs(root.right.right, map);
        }
        int res = Math.max(money, dfs(root.left, map) + dfs(root.right, map));
        // 缓存结果
        map.put(root, res);
        return res;
    }
}

class ThirdSolution {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfs(TreeNode root) {
        // 索引0处存储不偷根节点时能偷到的最大值
        // 索引1处存储偷当前节点（根节点）时能偷到的最大值
        if (root == null) return new int[2];
        int[] result = new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;
        return result;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/*
参考：https://leetcode-cn.com/problems/house-robber-iii/solution/shu-xing-dp-ru-men-wen-ti-by-liweiwei1419/
 */
