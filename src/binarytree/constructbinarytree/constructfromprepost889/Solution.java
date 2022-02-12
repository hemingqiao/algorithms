package src.binarytree.constructbinarytree.constructfromprepost889;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/07 20:07:30
 * description:
 * 返回与给定的前序和后序遍历匹配的任何二叉树。
 *
 *  pre 和 post 遍历中的值是不同的正整数。
 *
 *  
 *
 * 示例：
 *
 * 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 *  
 *
 * 提示：
 *
 * 1 <= pre.length == post.length <= 30
 * pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列
 * 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal
 *
 * 参考：https://github.com/grandyang/leetcode/issues/889
 */
public class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return builder(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    // 用 preL 和 preR 分别表示左子树区间的开头和结尾位置，postL 和 postR 表示右子树区间的开头和结尾位置，
    // 那么若 preL 大于 preR 或者 postL 大于 postR 的时候，说明已经不存在子树区间，直接返回空指针。然后要先新建当前树的根结点，
    // 就通过 pre[preL] 取到即可，接下来要找左子树的根结点在 post 中的位置，最简单的方法就是遍历 post 中的区间 [postL, postR]，
    // 找到其位置 idx，然后根据这个 idx，就可以算出左子树区间长度为 len = (idx-postL)+1，那么 pre 数组中左子树区间为
    // [preL+1, preL+len]，右子树区间为 [preL+1+len, preR]，同理，post 数组中左子树区间为 [postL, idx]，右子树区间为
    // [idx+1, postR-1]。知道了这些信息，就可以分别调用递归函数了
    public TreeNode builder(int[] pre, int preL, int preR, int[] post, int posL, int posR) {
        if (preL > preR || posL > posR) return null;
        TreeNode node = new TreeNode(pre[preL]);
        if (preL == preR) return node;
        int idx;
        // 在后续遍历数组中找到先序遍历的左子节点
        for (idx = posL; idx <= posR; idx++) {
            if (pre[preL + 1] == post[idx]) break;
        }
        node.left = builder(pre, preL + 1, preL + 1 + idx - posL, post, posL, idx);
        node.right = builder(pre, preL + 1 + idx - posL + 1, preR, post, idx + 1, posR - 1);
        return node;
    }
}


/**
 * 本意是加快运算，实际一提交，妈的不快反慢😂
 */
class AnotherSolution {
    // 使用一个map建立post数组中值和索引之间的关系
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            map.put(post[i], i);
        }
        return builder(pre, 0, pre.length - 1, post, 0, post.length - 1, map);
    }

    private TreeNode builder(int[] pre, int preL, int preR,
                             int[] post, int posL, int posR, Map<Integer, Integer> map) {
        if (preL > preR || posL > posR) return null;
        TreeNode node = new TreeNode(pre[preL]);
        if (preL == preR) return node;
        int idx = map.get(pre[preL + 1]);
        int len = idx - posL;
        node.left = builder(pre, preL + 1, preL + 1 + len, post, posL, idx, map);
        node.right = builder(pre, preL + 1 + len + 1, preR, post, idx + 1, posR - 1, map);
        return node;
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
