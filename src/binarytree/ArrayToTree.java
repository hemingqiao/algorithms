package src.binarytree;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/09 18:17:18
 * description:
 */
public class ArrayToTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 给定一个数组，构造一个二叉树。
     *
     * @param array 数组元素为null表明是空节点
     * @return 返回一个由数组元素构造的二叉树
     */
    public TreeNode arrayToTree(Integer[] array) {
        if (array.length == 0) return new TreeNode(0);
        List<TreeNode> nodes = new ArrayList<>(); // 用来存储节点
        int len = array.length;
        TreeNode root = new TreeNode(array[0]);
        nodes.add(root);
        int j = 0; // j用来遍历nodes列表
        // 每个非空节点可以提供左右两个位置来放新的子节点，当两个位置都填满后，移动j，填充新的节点
        // 如果i已经遍历到数组末尾，表明已经没有新节点需要构建了，此时可以退出
        for (int i = 1; i < len; i++) {
            TreeNode node = nodes.get(j);
            // 如果i处元素不为null，创建一个新节点，与父节点连接，否则，父节点的左子节点就是null
            if (array[i] != null) {
                TreeNode temp = new TreeNode(array[i]);
                node.left = temp;
                nodes.add(temp);
            }

            i++;
            if (i >= len) {
                break;
            }
            if (array[i] != null) {
                TreeNode temp = new TreeNode(array[i]);
                node.right = temp;
                nodes.add(temp);
            }
            j++;
        }
        return root;
    }

    /**
     * 通过给定的数组构造一个二叉树<p></p>
     * 参考：https://blog.nowcoder.net/n/f3799d64ed764fd49c63947d617d4cd5
     *
     * @param array 数组元素为null表明是空节点
     * @return 返回一个由数组元素构造的二叉树
     */
    public TreeNode constructTree(Integer[] array) {
        if (array.length == 0) return new TreeNode(0);
        int len = array.length;
        Deque<TreeNode> nodes = new ArrayDeque<>();
        TreeNode root = new TreeNode(array[0]);
        nodes.offer(root);
        TreeNode cur;
        int curLineNodeNum = 2; // 记录当前行可以填充的节点数量（注意不一定是2的幂，而是上一行中非空节点的数量乘2）
        int startIdx = 1; // 用来遍历数组
        int restLength = len - 1; // 记录数组中剩余可遍历元素个数
        while (restLength > 0) {
            for (int i = startIdx; i < startIdx + curLineNodeNum; i++) {
                if (i == len) return root;
                cur = nodes.poll();
                if (array[i] != null) {
                    cur.left = new TreeNode(array[i]);
                    nodes.offer(cur.left);
                }
                i++;
                if (i == len) return root;
                if (array[i] != null) {
                    cur.right = new TreeNode(array[i]);
                    nodes.offer(cur.right);
                }
            }
            startIdx += curLineNodeNum;
            restLength -= curLineNodeNum;
            curLineNodeNum = nodes.size() * 2;
        }
        return root;
    }

    public static void main(String[] args) {
        ArrayToTree att = new ArrayToTree();
        TreeNode t = att.constructTree(new Integer[]{1, null});
        System.out.println(att.treeToArray(t));
    }

    /**
     * 将二叉树转为数组表示
     *
     * @param root 给定的二叉树
     * @return 数组表示的二叉树
     */
    public List<Integer> treeToArray(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>(); // 需要向队列中添加null，ArrayDequeue不能添加null
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            } else {
                res.add(null);
            }
        }
        int size = res.size();
        // 去除多余的null
        for (int i = size - 1; i >= 0; i--) {
            if (res.get(i) == null) {
                res.remove(i);
            } else {
                break; // 遇到第一个非null的值后退出循环
            }
        }
        return res;
    }
}
