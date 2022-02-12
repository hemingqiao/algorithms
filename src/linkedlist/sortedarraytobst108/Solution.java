 package src.linkedlist.sortedarraytobst108;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/21 08:43:29
 * description: 和109解题思路类似。找到中间元素，递归的构建左右子树。
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 *
 * 解题思路
 * see: https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/jian-dan-di-gui-bi-xu-miao-dong-by-sweetiee/
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        return dfs(nums, 0, nums.length - 1);
    }

    // dfs返回以数组的中间元素为根节点的二叉树
    private TreeNode dfs(int[] nums, int low, int high) {
        if (low > high) return null;
//        int mid = (low + high) / 2;
        int mid = low + (high - low) / 2;
        TreeNode tree = new TreeNode(nums[mid]); // 以升序数组的中间元素为根节点构建二叉树
        tree.left = dfs(nums, low, mid - 1); // 递归的构建二叉树的左子树和右子树
        tree.right = dfs(nums, mid + 1, high);
        return tree;
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
