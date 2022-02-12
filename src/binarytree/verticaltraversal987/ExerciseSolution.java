package src.binarytree.verticaltraversal987;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/31 09:12:49
 * description:
 */
public class ExerciseSolution {
    TreeMap<Integer, List<Pair>> map = new TreeMap<>();

    public void dfs(TreeNode root, int x, int y) {
        if (root == null) return;
        if (!map.containsKey(y)) map.put(y, new ArrayList<>());
        map.get(y).add(new Pair(x, root.val));
        dfs(root.left, x + 1, y - 1);
        dfs(root.right, x + 1, y + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Pair>> entry : map.entrySet()) {
            List<Integer> t = new ArrayList<>();
            List<Pair> pairs = entry.getValue();
            Collections.sort(pairs, (o1, o2) -> {
                if (o1.x == o2.x) return o1.val - o2.val;
                return o1.x - o2.x;
            });
            for (Pair p : pairs) t.add(p.val);
            res.add(t);
        }
        return res;
    }

    static class Pair {
        int x;
        int val;

        public Pair(int x, int val) {
            this.x = x;
            this.val = val;
        }
    }
}
