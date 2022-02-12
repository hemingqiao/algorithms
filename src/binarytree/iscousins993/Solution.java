package src.binarytree.iscousins993;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/07 19:17:29
 * description:
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 *
 * 示例 1：
 *
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 示例 3：
 *
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *
 * 提示：
 *
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 *
 */
public class Solution {
    List<Integer> depths = new ArrayList<>();
    List<TreeNode> fathers = new ArrayList<>();
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        dfs(root, null, 0, x);
        dfs(root, null, 0, y);
        return depths.get(0).equals(depths.get(1)) && fathers.get(0) != fathers.get(1);
    }

    private void dfs(TreeNode root, TreeNode father, int depth, int target) {
        if (root == null) return;
        if (root.val == target) {
            fathers.add(father);
            depths.add(depth);
            return;
        }
        dfs(root.left, root, depth + 1, target);
        dfs(root.right, root, depth + 1, target);
    }
}

/**
 * BFS的代码真尼玛又臭又长
 * 参考：https://leetcode-cn.com/problems/cousins-in-binary-tree/solution/bfsjie-jin-shuang-bai-by-sagittarius-l/
 */
class SolutionBFS {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.val == x || root.val == y) return false;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode nodeX = null;
        TreeNode nodeY = null;
        TreeNode fatherX = null;
        TreeNode fatherY = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                    if (temp.left.val == x) {
                        nodeX = temp.left;
                        fatherX = temp;
                    }
                    if (temp.left.val == y) {
                        nodeY = temp.left;
                        fatherY = temp;
                    }
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                    if (temp.right.val == x) {
                        nodeX = temp.right;
                        fatherX = temp;
                    }
                    if (temp.right.val == y) {
                        nodeY = temp.right;
                        fatherY = temp;
                    }
                }
                // 两个节点都没有找到
                if (nodeX == null && nodeY == null) {
                    // do nothing
                } else if (nodeX != null && nodeY != null) {
                    // 两个节点都找到了，接下来判断两个节点的父节点是否相同
                    return fatherX != fatherY;
                } else if (size == 0) {
                    // 本层遍历完之后，两个节点中有一个为null，说明两个节点处于不同的深度
                    return false;
                }
            }
        }
        return false;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
