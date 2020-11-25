package blogandquestion.algorithms.binarytree.findfrequenttreesum508;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/25 18:56:10
 * description:
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 *
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 *  
 *
 * 示例 1：
 * 输入:
 *
 *   5
 *  /  \
 * 2   -3
 * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 *
 * 示例 2：
 * 输入：
 *
 *   5
 *  /  \
 * 2   -5
 * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
 *
 *  
 *
 * 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-frequent-subtree-sum
 *
 */
public class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        findSum(root);
        // 记录某个和出现的最大次数
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int times = entry.getValue();
            int key = entry.getKey();
            // 如果某个和出现的次数大于之前记录的最大次数max，更新set和max
            if (times > max) {
                max = times;
                set.clear();
                set.add(key);
            } else if (times == max) {
                // 次数相同，直接加入set
                set.add(key);
            }
        }
        int[] res = new int[set.size()];
        int i = 0;
        for (int j : set) {
            res[i++] = j;
        }
        return res;
    }

    // 返回以root为根节点的所有子节点之和（包括根节点）
    public int findSum(TreeNode root) {
        if (root == null) return 0;
        int leftSum = findSum(root.left);
        int rightSum = findSum(root.right);
        // 以root为根节点的所有子节点之和
        int sum = leftSum + rightSum + root.val;
        // 将子节点之和put到map中
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}

class AnotherSolution {
    List<Integer> res = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        int[] a = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            a[i] = res.get(i);
        }
        return a;
    }

    // 在搜索过程中即进行判断并向列表中加入sum的值
    // 同时dfs返回以root为根节点的子节点值之和（包括根节点）
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int sum = root.val + dfs(root.left) + dfs(root.right);
        int num = map.getOrDefault(sum, 0) + 1;
        map.put(sum, num);
        if (num > max) {
            // 如果当前某个节点的所有子节点之和超过了max，更行list和max
            max = num;
            res = new ArrayList<>();
            res.add(sum);
        } else if (num == max) {
            // 如果sum恰好等于max，直接加入列表
            res.add(sum);
        }
        return sum;
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
