package blogandquestion.algorithms.binarytree.codec449;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/27 12:58:40
 * description:
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 *
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 *
 * 编码的字符串应尽可能紧凑。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [2,1,3]
 * 输出：[2,1,3]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 树中节点数范围是 [0, 104]
 * 0 <= Node.val <= 104
 * 题目数据 保证 输入的树是一棵二叉搜索树。
 *  
 *
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-bst
 *
 * 参考：https://leetcode-cn.com/problems/serialize-and-deserialize-bst/solution/java-shi-yong-qian-xu-bian-li-jin-xing-xu-lie-hua-/
 */
public class CodeC {
    // Encodes a tree to a single string.
    // 序列化时按照先序遍历，这样当反序列化时，就可以利用二叉搜索树的性质构建树（二叉搜索树的中序遍历是有序的）
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    // 先序遍历
    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] arr = data.split(",");
        return builder(arr, 0, arr.length - 1);
    }

    private TreeNode builder(String[] arr, int low, int high) {
        if (low > high) return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[low]));
        // 找到第一个比首元素大的元素位置
        int index = high + 1; // index初始化为high + 1是让在没有右子树的情况下，也能正确的进行下面的递归，如[2,1]这种情况
        for (int i = low + 1; i <= high; i++) {
            if (Integer.parseInt(arr[i]) > root.val) {
                index = i;
                break;
            }
        }
        // 递归构建左右子树
        root.left = builder(arr, low + 1, index - 1);
        root.right = builder(arr, index, high);
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
