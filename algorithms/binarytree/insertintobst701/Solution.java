package blogandquestion.algorithms.binarytree.insertintobst701;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/28 11:16:23
 * description:
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 *
 * 示例 1：
 *
 *
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[4,2,7,1,3,5]
 *
 * 示例 2：
 *
 * 输入：root = [40,20,60,10,30,50,70], val = 25
 * 输出：[40,20,60,10,30,50,70,null,null,25]
 * 示例 3：
 *
 * 输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
 * 输出：[4,2,7,1,3,5]
 *
 * 提示：
 *
 * 给定的树上的节点数介于 0 和 10^4 之间
 * 每个节点都有一个唯一整数值，取值范围从 0 到 10^8
 * -10^8 <= val <= 10^8
 * 新值和原始二叉搜索树中的任意节点值都不同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree
 *
 * 参考：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/solution/2-de-cha-ru-by-sweetiee/
 */
public class Solution {
    /*
    如果 root 是空，则新建树节点作为根节点返回即可。
    否则：
        初始化 cur 指向 root。
    比较 cur.val 与目标值的大小关系：
        如果 cur.val 大于目标值，说明目标值应当插入 cur 的左子树中，如果 cur.left 为 null，表明这是目标值可以插入的位置，直接插入并返回即可；
        否则 cur 指向 cur.left，重复步骤 2；
        如果 cur.val 小于目标值，说明目标值应当插入 cur 的右子树中。如果 cur.right 为 null，表明这是目标值可以插入的位置，直接插入并返回即可；
        否则 cur 指向 cur.right，重复步骤 2。
     */

    // 迭代解法
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) {
            return node;
        }
        TreeNode cur = root;
        while (true) {
            if (cur.val > val) {
                // 插入到左子树
                if (cur.left == null) {
                    cur.left = node;
                    break;
                }
                cur = cur.left;
            } else {
                // 插入到右子树
                if (cur.right == null) {
                    cur.right = node;
                    break;
                }
                cur = cur.right;
            }
        }
        return root;
    }
}

class AnotherSolution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (root.val > val) {
            // 插入到左子树
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
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
