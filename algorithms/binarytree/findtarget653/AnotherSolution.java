package blogandquestion.algorithms.binarytree.findtarget653;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/09 19:33:47
 * description:使用HashSet，利用两数之和的思想。这个时间效率比中序遍历加双指针慢40%
 * 解题思路
 * see: https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/solution/liang-shu-zhi-he-iv-by-leetcode/
 */
public class AnotherSolution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }

    private boolean find(TreeNode root, int k, Set<Integer> set) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
}
