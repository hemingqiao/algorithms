package blogandquestion.algorithms.binarytree.recoverfrompreorder1028;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/25 21:28:41
 * description:
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。
 *
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 *
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 *
 * 给出遍历输出 S，还原树并返回其根节点 root。
 *
 * 示例 1：
 *
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 * 示例 2：
 *
 * 输入："1-2--3---4-5--6---7"
 * 输出：[1,2,5,3,null,6,null,4,null,7]
 * 示例 3：
 *
 * 输入："1-401--349---90--88"
 * 输出：[1,401,null,349,88,90]
 *
 * 提示：
 *
 * 原始树中的节点数介于 1 和 1000 之间。
 * 每个节点的值介于 1 和 10 ^ 9 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal
 *
 * 参考：https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal/comments/450316
 */
public class Solution {
    public TreeNode recoverFromPreorder(String S) {
        // map用来记录深度和对应节点之间的映射
        HashMap<Integer, TreeNode> map = new HashMap<>();
        int depth = 0;
        // idx为遍历字符串的索引
        int idx = 0, val = 0;
        while (idx < S.length() && S.charAt(idx) != '-') {
            // 可能是这样的字符串 "123456"，所以要用while循环取到所有非数字字符为止
            val = val * 10 + (S.charAt(idx) - '0');
            idx++;
        }
        // node为整棵树的根节点
        TreeNode node = new TreeNode(val);
        val = 0; // 重置val
        // depth 0 对应着整棵树的根节点node
        map.put(depth, node);
        while (idx < S.length()) {
            while (idx < S.length() && S.charAt(idx) == '-') {
                idx++;
                depth++; // 深度增加，表明进入了下一层
            }
            // 遇到数值
            while (idx < S.length() && S.charAt(idx) != '-') {
                val = val * 10 + (S.charAt(idx) - '0');
                idx++;
            }
            TreeNode temp = new TreeNode(val);
            // 从哈希表中获取父节点（当前深度 - 1 对应的既是当前深度的父节点）
            TreeNode parent = map.get(depth - 1);
            // 如果父节点的左子树空缺，优先填左子树，因为是从左往右遍历的
            // 使用map和depth保证填充的是同一层节点的左右子树
            if (parent.left == null) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }
            // 将当前深度值和当前深度对应的节点put到map中
            map.put(depth, temp);
            // 重置depth和val，'-'代表深度，一个'-'代表深度为1，字符串中的'-'长度代表了节点所处的深度
            depth = 0;
            val = 0;
        }
        return node;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String S = "10-7--8";
        TreeNode res = s.recoverFromPreorder(S);
        System.out.println(res);
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
