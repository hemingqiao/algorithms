package src.dfs.pathsum437;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/13 16:47:42
 * description:
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 *
 * 参考：https://leetcode-cn.com/problems/path-sum-iii/solution/qian-zhui-he-di-gui-hui-su-by-shi-huo-de-xia-tian/
 */
public class AnotherSolution {
    public int pathSum(TreeNode root, int sum) {
        // key是前缀和, value是大小为key的前缀和出现的次数
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        // 前缀和为0的一条路径（根节点对应的前缀和为0）
        prefixSumCount.put(0, 1);
        // 前缀和的递归回溯思路
        return recursionPathSum(root, prefixSumCount, sum, 0);
    }

    /**
     * 前缀和的递归回溯思路
     * 从当前节点反推到根节点(反推比较好理解，正向其实也只有一条)，有且仅有一条路径，因为这是一棵树
     * 如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
     * 所以前缀和对于当前路径来说是唯一的，当前记录的前缀和，在回溯结束，回到本层时去除，保证其不影响其他分支的结果
     *
     * @param node           树节点
     * @param prefixSumCount 前缀和Map
     * @param target         目标值
     * @param currSum        当前路径和
     * @return 满足题意的解
     */
    private int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, int target, int currSum) {
        // 1.递归终止条件
        if (node == null) {
            return 0;
        }
        // 2.本层要做的事情
        int res = 0;
        // 当前路径上的和
        currSum += node.val;

        //---核心代码
        // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
        // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
        // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
        res += prefixSumCount.getOrDefault(currSum - target, 0);
        // 更新路径上当前节点前缀和的个数
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
        //---核心代码

        // 3.进入下一层
        res += recursionPathSum(node.left, prefixSumCount, target, currSum);
        res += recursionPathSum(node.right, prefixSumCount, target, currSum);

        // 4.回到本层，恢复状态，去除当前节点的前缀和数量（进行回溯）
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
        return res;
    }

    public static void main(String[] args) {
        AnotherSolution as = new AnotherSolution();
        Integer[] treeVal = new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};
        TreeNode root = as.arrayToTree(treeVal);
        int res = as.pathSum(root, 8);
        System.out.println(res);
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
}
