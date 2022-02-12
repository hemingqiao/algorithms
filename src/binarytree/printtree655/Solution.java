package src.binarytree.printtree655;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/05 13:53:07
 * description:
 * 在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
 *
 * 行数 m 应当等于给定二叉树的高度。
 * 列数 n 应当总是奇数。
 * 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。
 * 你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，
 * 你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
 * 每个未使用的空间应包含一个空的字符串""。
 * 使用相同的规则输出子树。
 * 示例 1:
 *
 * 输入:
 *      1
 *     /
 *    2
 * 输出:
 * [["", "1", ""],
 *  ["2", "", ""]]
 * 示例 2:
 *
 * 输入:
 *      1
 *     / \
 *    2   3
 *     \
 *      4
 * 输出:
 * [["", "", "", "1", "", "", ""],
 *  ["", "2", "", "", "", "3", ""],
 *  ["", "", "4", "", "", "", ""]]
 * 示例 3:
 *
 * 输入:
 *       1
 *      / \
 *     2   5
 *    /
 *   3
 *  /
 * 4
 * 输出:
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 *  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 *  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 *  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 * 注意: 二叉树的高度在范围 [1, 10] 中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-binary-tree
 * 参考：https://github.com/grandyang/leetcode/issues/655
 */
public class Solution {
    // 解题思路：先获取树的最大深度，每次都是将节点值插入到每一行的中间位置。
    // 如第一行插入到中间位置，第二行分为左右两部分，都是将值插入到左右两部分的中间位置
    public List<List<String>> printTree(TreeNode root) {
        if (root == null) return new ArrayList<>();
        int height = getTreeDepth(root);
        // 每一行的宽度
        int len = (int) (Math.pow(2, height) - 1);
        List<List<String>> res = new ArrayList<>();
        // 初始化结果列表
//        for (int i = 0; i < height; i++) {
//            res.add(new ArrayList<>());
//        }
//        for (List<String> list : res) {
//            for (int i = 0; i < len; i++) {
//                list.add("");
//            }
//        }
        // 另一种初始化方法
        for (int i = 0; i < height; i++) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                temp.add("");
            }
            res.add(temp);
        }
        dfs(root, 0, len - 1, 0, height, res);
        return res;
    }

    private void dfs(TreeNode root, int left, int right, int curHeight, int height, List<List<String>> res) {
        if (curHeight == height || root == null) return;
        int mid = (left + right) >>> 1;
        res.get(curHeight).set(mid, String.valueOf(root.val));
        dfs(root.left, left, mid - 1, curHeight + 1, height, res);
        dfs(root.right, mid + 1, right, curHeight + 1, height, res);
    }

    // 获取树的最大深度
    private int getTreeDepth(TreeNode root) {
        return root == null ? 0 : Math.max(getTreeDepth(root.left), getTreeDepth(root.right)) + 1;
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
