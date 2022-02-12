package src.binarytree.constructmaximumbinarytree654;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/01 08:57:24
 * description: 与构造二叉树类似。
 * 解题思路
 * see: https://leetcode-cn.com/problems/maximum-binary-tree/solution/654-zui-da-er-cha-shu-gen-ju-shu-zu-gou-zao-er-cha/
 *
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 *  
 *
 * 示例 ：
 *
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *  
 *
 * 提示：
 *
 * 给定的数组的大小在 [1, 1000] 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 *
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructAuxiliary(nums, 0, nums.length - 1);
    }

    TreeNode constructAuxiliary(int[] nums, int start, int end) {
        if (start > end) return null; // 这里使用了闭区间，即end是可以取到的，所以递归结束条件是start > end。如果是开区间，end取不到，结束条件要变为大于等于

        // 找到最大值的索引
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructAuxiliary(nums, start, maxIndex - 1);
        root.right = constructAuxiliary(nums, maxIndex + 1, end);
        return root;
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
