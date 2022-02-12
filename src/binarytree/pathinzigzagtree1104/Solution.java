package src.binarytree.pathinzigzagtree1104;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/08 13:41:21
 * description:
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 *
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 *
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 *
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 *
 * 示例 1：
 *
 * 输入：label = 14
 * 输出：[1,3,4,14]
 * 示例 2：
 *
 * 输入：label = 26
 * 输出：[1,2,6,10,26]
 *  
 *
 * 提示：
 *
 * 1 <= label <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree
 *
 */
public class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int depth = (int) (Math.log(label) / Math.log(2)) + 1;
        List<Integer> res = new ArrayList<>(depth);
        while (label > 0) {
            res.add(depth - 1, label);
            label = (int) (Math.pow(2, depth) - 1 - label + Math.pow(2, depth - 1));
            label >>= 1;
            depth--;
        }
        return res;
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree/solution/jian-dan-yi-dong-de-gong-shi-shi-jian-guo-100-by-a/
 */
class AnotherSolution {
    public List<Integer> pathInZigZagTree(int label) {
        ArrayList<Integer> integers = new ArrayList<>(); // 0.初始化存放结果的变量
        int depth = (int) (Math.log(label) / Math.log(2)); // 2.计算label所在的层
        while (label > 1) { // 5.循环直到遇到特殊情况1
            integers.add(label);//3.将label的结果添加到数组中
            label = (int) (3 * Math.pow(2, --depth) - label / 2 - 1); // 4.计算下一个label的值
        }
        integers.add(1); // 6.添加特殊情况 1
        Collections.reverse(integers); // 7.翻转数组
        return integers; // 1.返回结果
    }
}
