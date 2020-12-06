package blogandquestion.algorithms.binarytree.pseudopalindromicpaths1457;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/06 20:33:37
 * description:
 * 给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
 *
 * 请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。
 *
 *
 * 示例 1：
 *
 * 输入：root = [2,3,1,3,1,null,1]
 * 输出：2
 * 解释：上图为给定的二叉树。总共有 3 条从根到叶子的路径：红色路径 [2,3,3] ，绿色路径 [2,1,1] 和路径 [2,3,1] 。
 *      在这些路径中，只有红色和绿色的路径是伪回文路径，因为红色路径 [2,3,3] 存在回文排列 [3,2,3] ，绿色路径 [2,1,1] 存在回文排列 [1,2,1] 。
 * 示例 2：
 *
 * 输入：root = [2,1,1,1,3,null,null,null,null,null,1]
 * 输出：1
 * 解释：上图为给定二叉树。总共有 3 条从根到叶子的路径：绿色路径 [2,1,1] ，路径 [2,1,3,1] 和路径 [2,1] 。
 *      这些路径中只有绿色路径是伪回文路径，因为 [2,1,1] 存在回文排列 [1,2,1] 。
 * 示例 3：
 *
 * 输入：root = [9]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 给定二叉树的节点数目在 1 到 10^5 之间。
 * 节点值在 1 到 9 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pseudo-palindromic-paths-in-a-binary-tree
 *
 * 参考：https://leetcode-cn.com/problems/pseudo-palindromic-paths-in-a-binary-tree/solution/java-by-lixianfeng/
 */
public class Solution {
    int res;
    public int pseudoPalindromicPaths(TreeNode root) {
        int[] record = new int[10];
        preOrderDFS(root, record);
        return res;
    }

    public void preOrderDFS(TreeNode root, int[] arr) {
        if (root == null) return;
        arr[root.val]++;
        // 到达叶子节点
        if (root.left == null && root.right == null) {
            int cnt = 0;
            for (int i : arr) {
                if ((i & 1) == 1) cnt++;
            }
            // 只有出现次数为奇数的元素个数小于2，才能形成伪回文
            if (cnt < 2) res++;
        } else {
            // 将arr复制了一份传入递归调用的方法，这样的好处在于不用进行回溯了
            if (root.left != null) {
                preOrderDFS(root.left, Arrays.copyOfRange(arr, 0, arr.length));
            }
            if (root.right != null) {
                preOrderDFS(root.right, Arrays.copyOfRange(arr, 0, arr.length));
            }
        }
    }
}

/**
 * 位运算的思路。
 * 节点值的范围为1-9，可以用 1 << k位代表这9个值，如用1 << 2 代表2
 * 以路径 2 -> 3 -> 3来说，0 ^ (1 << 2) = 0100
 * 0100 ^ (1 << 3) = 1100
 * 1100 ^ (1 << 3) = 0100
 * 此时 0100 ^ (0100 - 0001) == 0
 * 而对于路径 2 -> 3 -> 3 -> 2而言
 * 0 ^ (1 << 2) = 0100
 * 0100 ^ (1 << 3) = 1100
 * 1100 ^ (1 << 3) = 0100
 * 0100 ^ (1 << 2) = 0000
 * 所以对于伪回文序列而言，长度为奇数时，最后的结果与最后的结果减1做与运算得到0
 * 而长度为偶数时，最后得到的结果就是0
 * 参考：https://leetcode-cn.com/problems/pseudo-palindromic-paths-in-a-binary-tree/solution/wei-yun-suan-jie-fa-by-dnanki/
 */
class AnotherSolution {
    int res;
    public int pseudoPalindromicPaths(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return res;
    }

//    private void dfs(TreeNode root, int temp) {
//        if (root == null) {
//            return;
//        }
//        temp = temp ^ (1 << root.val);
//        if (root.left == null && root.right == null) {
//            if (temp == 0 || (temp & (temp - 1)) == 0) {
//                res++;
//            }
//            return;
//        }
//        dfs(root.left, temp);
//        dfs(root.right, temp);
//    }

    // 上面的dfs写法可以优化一下
    private void dfs(TreeNode root, int temp) {
        temp = temp ^ (1 << root.val);
        if (root.left == null && root.right == null) {
            if (temp == 0 || (temp & (temp - 1)) == 0) {
                res++;
            }
            return;
        }
        if (root.left != null) dfs(root.left, temp);
        if (root.right != null) dfs(root.right, temp);
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
