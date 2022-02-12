package src.binarytree.isvalidserialization331;


import java.util.Stack;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/02 21:00:03
 * description:
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 *
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 *
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 *
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 *
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 *
 * 示例 1:
 *
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * 示例 2:
 *
 * 输入: "1,#"
 * 输出: false
 * 示例 3:
 *
 * 输入: "9,#,#,1"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree
 *
 * 参考：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/solution/zhan-he-zhao-gui-lu-by-jiangcoder/
 */
public class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder.length() == 0) return true;
        String[] strs = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (String str : strs) {
            stack.push(str);
            int size = stack.size();
            // 当栈顶元素和栈顶的下一个元素都等于"#"时，表明到达了叶子节点处
            // 将代表叶子节点的两个"#"从栈中弹出，判断此时栈顶元素是否为"#"，如果此时栈顶是"#"，返回false（因为null不可以再有子节点了）
            // 如果此时栈顶不是"#"，将栈顶元素弹出，用"#"代替，相当于把这个节点替换为了null
            while (size >= 3 && "#".equals(stack.get(size - 1)) && "#".equals(stack.get(size - 2))) {
                stack.pop();
                stack.pop();
                if ("#".equals(stack.peek())) {
                    return false;
                }
                stack.pop();
                stack.push("#");
            }
        }
        // 退出for循环后，如果栈中只有一个元素并且这个元素值为"#"，表明序列是正确的
        return stack.size() == 1 && "#".equals(stack.pop());
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/solution/zhan-he-zhao-gui-lu-by-jiangcoder/
 */
class AnotherSolution {
    // 二叉树有一个性质就是整棵树叶子节点的个数比内部节点的个数大1，当然在遍历的过程中，叶子节点的个数一定是小于等于内部节点的个数的，
    // 如果不满足这个条件，证明有根节点为空，直接返回false，遍历完成后，只需要验证一下上面说的性质
    public boolean isValidSerialization(String preorder) {
        if (preorder.length() == 0) return true;
        String[] strs = preorder.split(",");
        int leaves = 0; // 记录叶子节点个数
        int innerNodes = 0; // 记录内部节点个数
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("#")) {
                leaves++;
            } else {
                innerNodes++;
            }
            // 如果在没有遍历完情况下，出现了叶子节点数大于内部节点数，返回false
            if (i != strs.length - 1 && leaves > innerNodes) {
                return false;
            }
        }
        return leaves == innerNodes + 1;
    }
}
