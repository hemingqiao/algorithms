package blogandquestion.algorithms.binarytree.isevenoddtree1609;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/09 15:38:19
 * description:
 * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
 *
 * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
 * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
 * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
 * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
 * 输出：true
 * 解释：每一层的节点值分别是：
 * 0 层：[1]
 * 1 层：[10,4]
 * 2 层：[3,7,9]
 * 3 层：[12,8,6,2]
 * 由于 0 层和 2 层上的节点值都是奇数且严格递增，而 1 层和 3 层上的节点值都是偶数且严格递减，因此这是一棵奇偶树。
 * 示例 2：
 *
 * 输入：root = [5,4,2,3,3,7]
 * 输出：false
 * 解释：每一层的节点值分别是：
 * 0 层：[5]
 * 1 层：[4,2]
 * 2 层：[3,3,7]
 * 2 层上的节点值不满足严格递增的条件，所以这不是一棵奇偶树。
 * 示例 3：
 *
 * 输入：root = [5,9,1,3,5,7]
 * 输出：false
 * 解释：1 层上的节点值应为偶数。
 * 示例 4：
 *
 * 输入：root = [1]
 * 输出：true
 * 示例 5：
 *
 * 输入：root = [11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17]
 * 输出：true
 *  
 *
 * 提示：
 *
 * 树中节点数在范围 [1, 105] 内
 * 1 <= Node.val <= 106
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/even-odd-tree
 *
 */
public class Solution {
    // 这代码写的太烂了
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true;
        int depth = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 是否是偶数
            boolean isEven = depth % 2 == 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            size = list.size();
            // 偶数层，严格递增，奇数
            if (isEven) {
                if (size == 1) {
                    if ((list.get(0) & 1) == 0) return false;
                } else {
                    int pre = list.get(0);
                    if ((pre & 1) == 0) return false;
                    for (int i = 1; i < list.size(); i++) {
                        int t = list.get(i);
                        if ((t & 1) == 0) return false;
                        if (pre >= t) return false;
                        pre = t;
                    }
                }
            } else {
                // 奇数层，严格递减，偶数
                if (size == 1) {
                    if ((list.get(0) & 1) == 1) return false;
                } else {
                    int pre = list.get(0);
                    if ((pre & 1) == 1) return false;
                    for (int i = 1; i < list.size(); i++) {
                        int t = list.get(i);
                        if ((t & 1) == 1) return false;
                        if (pre <= t) return false;
                        pre = t;
                    }
                }
            }
            depth++;
        }
        return true;
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/even-odd-tree/solution/bfsmei-yi-ceng-de-qi-ou-biao-zhi-levelprezhi-de-sh/
 */
class AnotherSolution {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return false;
        boolean isEven = true;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int pre;
        while (!queue.isEmpty()) {
            if (isEven) {
                // 偶数层严格递增
                pre = Integer.MIN_VALUE;
            } else {
                // 奇数层严格递减
                pre = Integer.MAX_VALUE;
            }
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                int cur = node.val;
                // 如果在某一层不满足条件，直接返回false
                if ((isEven && (pre >= cur || (cur & 1) == 0)) || (!isEven && (pre <= cur || (cur & 1) == 1))) {
                    return false;
                }
                pre = cur; // 更新pre
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }
            isEven = !isEven;
        }
        return true;
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
