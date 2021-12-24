package blogandquestion.algorithms.backtrack.combine77;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/04 19:23:34
 * description:
 */
public class ExerciseSolution {
    // 常规回溯，有点慢
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(list, path, 1, n, k);
        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> path, int startIndex, int n, int k) {
        if (path.size() == k) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtrack(list, path, i + 1, n, k);
            path.remove(path.size() - 1);
        }
    }

    public void backtrack1(List<List<Integer>> list, List<Integer> path, int startIndex, int n, int k) {
        if (path.size() == k) {
            list.add(new ArrayList<>(path));
            return;
        }
        // 进行剪枝，当path中已有size个数时，还需要k - size个，所以如果从i到n不足k - size个，可以直接剪掉
        // 需要注意的是，由于起始索引从1开始，导致n - (k - path.cnt())之后还需要加上1
        for (int i = startIndex; i <= n && i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtrack(list, path, i + 1, n, k);
            path.remove(path.size() - 1);
        }
    }
}
