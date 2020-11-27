package blogandquestion.algorithms.binarytree.bstiterator173;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/27 19:16:31
 * description:
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 * 示例：
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 *  
 *
 * 提示：
 *
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
 *
 */
public class BSTIterator {
    List<Integer> res;
    int count = 0;
    public BSTIterator(TreeNode root) {
        this.res = new ArrayList<>();
        dfs(root);
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return this.res.get(count++);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return count < res.size();
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
