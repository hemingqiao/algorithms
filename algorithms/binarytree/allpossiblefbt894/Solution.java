package blogandquestion.algorithms.binarytree.allpossiblefbt894;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/06 14:49:43
 * description:
 * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
 *
 * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
 *
 * 答案中每个树的每个结点都必须有 node.val=0。
 *
 * 你可以按任何顺序返回树的最终列表。
 *
 * 示例：
 *
 * 输入：7
 * 输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * 解释：
 *
 * 提示：
 *
 * 1 <= N <= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees
 *
 * 参考：https://github.com/grandyang/leetcode/issues/894
 */
public class Solution {
    public List<TreeNode> allPossibleFBT(int N) {
        // N为偶数时直接返回空列表
        if ((N & 1) == 0) return new ArrayList<>();
        if (N == 1) {
            List<TreeNode> temp = new ArrayList<>();
            temp.add(new TreeNode(0));
            return temp;
        }
        List<TreeNode> res = new ArrayList<>();
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - 1 - i);
            for (TreeNode t : left) {
                for (TreeNode n : right) {
                    TreeNode node = new TreeNode(0);
                    node.left = t;
                    node.right = n;
                    res.add(node);
                }
            }
        }
        return res;
    }
}

class AnotherSolution {
    // map相当于加了一个缓存
    Map<Integer, List<TreeNode>> record = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
        // N为偶数时直接返回空列表
        if ((N & 1) == 0) return new ArrayList<>();
        if (N == 1) {
            List<TreeNode> temp = new ArrayList<>();
            temp.add(new TreeNode(0));
            return temp;
        }
        // 如果之前计算过N，直接从map中取出结果
        if (record.containsKey(N)) return record.get(N);
        List<TreeNode> res = new ArrayList<>();
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - 1 - i);
            for (TreeNode t : left) {
                for (TreeNode n : right) {
                    TreeNode node = new TreeNode(0);
                    node.left = t;
                    node.right = n;
                    res.add(node);
                }
            }
        }
        record.put(N, res); // 将结果加入到map中
        return res;
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
