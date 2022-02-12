package src.binarytree.codec297;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/25 19:41:00
 * description:
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 *
 * 参考：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/solution/bfshe-dfsliang-chong-fang-shi-jie-jue-by-sdwwld-3/
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 先序遍历，左子树的节点在右子树之前
        if (root == null) {
            return "#";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 把data拆分，存储到队列中
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        String s = queue.poll(); // 出队
        if ("#".equals(s)) {
            // "#"代表空节点
            return null;
        }
        // 将当前字符转为数字，作为根节点构造树
        TreeNode root = new TreeNode(Integer.parseInt(s));
        // 因为序列化时左子树节点先入队，所以这里先构造左子树
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
