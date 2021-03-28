package blogandquestion.algorithms.binarytree.bstiterator173;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/28 13:14:14
 * description: 二刷
 */
public class BSTIterator2 {
    private List<Integer> list = new ArrayList<>();
    private Iterator<Integer> itr;

    public BSTIterator2(TreeNode root) {
        dfs(root);
        this.itr = list.iterator();
    }

    public int next() {
        return itr.next();
    }

    public boolean hasNext() {
        return itr.hasNext();
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
