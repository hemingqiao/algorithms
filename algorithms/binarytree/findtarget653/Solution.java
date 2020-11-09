package blogandquestion.algorithms.binarytree.findtarget653;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/09 19:21:40
 * description: 因为是二叉搜索树，所以可以先中序遍历二叉搜索树获得有序序列，然后利用双指针查找是否存在两个元素之和等于target。
 */
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        int left = 0, right = res.size() - 1;
        while (left < right) {
            if (res.get(left) + res.get(right) == k) {
                return true;
            } else if (res.get(left) + res.get(right) > k) {
                // 因为元素是有序的，如果left和right之和大于目标，不能左移left，否则会偏离目标越来越远，此时需要右移right
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
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
