package blogandquestion.algorithms.binarytree.findmode501;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/23 17:07:01
 * description:
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 *
 * 参考：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/solution/er-cha-shu-zhong-xu-bian-li-de-liang-chong-fang-sh/
 */
public class Solution {
    List<Integer> res = new ArrayList<>();
    int current = 0; // 当前值
    int count = 0; // 当前值出现的次数
    int maxCount = 0; // 某个值出现的最大次数

    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] r = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }

    private void inorder(TreeNode root) {
        if (root == null) return; // base case
        inorder(root.left);
        int nodeValue = root.val;
        if (nodeValue == current) {
            count++;
        } else {
            current = nodeValue;
            count = 1;
        }

        if (count == maxCount) {
            res.add(nodeValue);
        } else if (count > maxCount) {
            // 如果count大于了maxCount，将list清空，将新的值加入列表，重置maxCount
            res.clear();
            res.add(nodeValue);
            maxCount = count;
        }
        inorder(root.right);
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
