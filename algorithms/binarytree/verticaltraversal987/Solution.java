package blogandquestion.algorithms.binarytree.verticaltraversal987;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/06 19:30:09
 * description:
 * 给定二叉树，按垂序遍历返回其结点值。
 *
 * 对位于 (X, Y) 的每个结点而言，其左右子结点分别位于 (X-1, Y-1) 和 (X+1, Y-1)。
 *
 * 把一条垂线从 X = -infinity 移动到 X = +infinity ，每当该垂线与结点接触时，我们按从上到下的顺序报告结点的值（ Y 坐标递减）。
 *
 * 如果两个结点位置相同，则首先报告的结点值较小。
 *
 * 按 X 坐标顺序返回非空报告的列表。每个报告都有一个结点值列表。
 *
 *
 * 示例 1：
 *
 * 输入：[3,9,20,null,null,15,7]
 * 输出：[[9],[3,15],[20],[7]]
 * 解释：
 * 在不丧失其普遍性的情况下，我们可以假设根结点位于 (0, 0)：
 * 然后，值为 9 的结点出现在 (-1, -1)；
 * 值为 3 和 15 的两个结点分别出现在 (0, 0) 和 (0, -2)；
 * 值为 20 的结点出现在 (1, -1)；
 * 值为 7 的结点出现在 (2, -2)。
 * 示例 2：
 *
 * 输入：[1,2,3,4,5,6,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 根据给定的方案，值为 5 和 6 的两个结点出现在同一位置。
 * 然而，在报告 "[1,5,6]" 中，结点值 5 排在前面，因为 5 小于 6。
 *  
 *
 * 提示：
 *
 * 树的结点数介于 1 和 1000 之间。
 * 每个结点值介于 0 和 1000 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree
 *
 * 参考：https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/solution/java-dfspai-xu-by-shi-a-xin-ya/
 */
public class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<int[]> list = new ArrayList<>();
        dfs(root, list, 0, 0); // 根节点的坐标视为(0, 0)
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 如果x不相同，按照x进行升序排序
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                // 如果x相同，y不相同，按照y进行降序排序
                if (o1[1] != o2[1]) {
                    return o2[1] - o1[1];
                }
                // 如果x和y值均相同，按照value值进行升序排序
                return o1[2] - o2[2];
            }
        });

        List<List<Integer>> res = new ArrayList<>();
        int pre = list.get(0)[0]; // 代表x坐标
        res.add(new ArrayList<>());
        for (int[] arr : list) {
            // 如果x值不同的话
            if (pre != arr[0]) {
                pre = arr[0]; // 更新pre
                res.add(new ArrayList<>()); // 加入一个新的列表
            }
            res.get(res.size() - 1).add(arr[2]); // 将值加入x值相同的列表之中
        }
        return res;
    }

    private void dfs(TreeNode root, List<int[]> list, int x, int y) {
        if (root == null) return;
        list.add(new int[]{x, y, root.val});
        // 在本题语境下，左子节点的坐标为(x - 1, y - 1)，右子节点的坐标为(x + 1, y - 1)
        dfs(root.left, list, x - 1, y - 1);
        dfs(root.right, list, x + 1, y - 1);
    }
}


/**
 * 使用优先队列
 * 参考：https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/solution/java-you-xian-dui-lie-di-gui-by-ace4j/
 */
class AnotherSolution {
    // 声明一个内部类用于存储数据
    private static class Pair {
        int val;
        int x;
        int y;

        Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                // 如果x不相同，按照x进行升序排序
                if (o1.x != o2.x) {
                    return o1.x - o2.x;
                }
                // 如果x相同，y不相同，按照y进行降序排序
                if (o1.y != o2.y) {
                    return o2.y - o1.y;
                }
                // 如果x和y值均相同，按照value值进行升序排序
                return o1.val - o2.val;
            }
        });
        dfs(root, queue, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        int pre = queue.peek().x;
        res.add(new ArrayList<>());
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            // 如果x值不同的话
            if (pre != p.x) {
                pre = p.x; // 更新pre
                res.add(new ArrayList<>()); // 向结果列表中加入一个新的列表
            }
            res.get(res.size() - 1).add(p.val); // 将节点值加入到相同的x值对应的列表之中
        }
        return res;
    }


    private void dfs(TreeNode root, PriorityQueue<Pair> queue, int x, int y) {
        if (root == null) return;
        queue.add(new Pair(x, y, root.val));
        // 在本题语境下，左子节点的坐标为(x - 1, y - 1)，右子节点的坐标为(x + 1, y - 1)
        dfs(root.left, queue, x - 1, y - 1);
        dfs(root.right, queue, x + 1, y - 1);
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
