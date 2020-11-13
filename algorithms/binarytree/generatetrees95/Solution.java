package blogandquestion.algorithms.binarytree.generatetrees95;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/13 19:33:22
 * description:
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 *
 *  
 *
 * 示例：
 *
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *  
 *
 * 提示：
 *
 * 0 <= n <= 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 *
 * 解题思路
 * see: https://github.com/ustcyyw/yyw_algorithm/blob/master/medium/Tree/generateTrees95.md
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/solution/bu-tong-de-er-cha-sou-suo-shu-ii-by-leetcode-solut/
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/solution/cong-gou-jian-dan-ke-shu-dao-gou-jian-suo-you-shu-/
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return sonTrees(1, n);
    }

    // 以[low, high]区间内的每个元素作为二叉搜索树的根元素，一共能构成多少个二叉搜索树
    private List<TreeNode> sonTrees(int low, int high) {
        List<TreeNode> res = new ArrayList<>();
        if (low > high) res.add(null);
        else if (low == high) res.add(new TreeNode(low));
        else {
            // 当前区间内，每个元素都可能作为根元素，然后要考虑其左边区间所有子树与右边区间所有子树的可能
            for (int i = low; i <= high; i++) {
                List<TreeNode> leftSon = sonTrees(low, i - 1);
                List<TreeNode> rightSon = sonTrees(i + 1, high);
                for (TreeNode left : leftSon) {
                    for (TreeNode right : rightSon) {
                        TreeNode newNode = new TreeNode(i);
                        newNode.left = left;
                        newNode.right = right;
                        res.add(newNode);
                    }
                }
            }
        }
        return res;
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
