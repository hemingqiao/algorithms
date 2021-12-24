package blogandquestion.algorithms.backtrack.judgepoint24679;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/29 19:44:02
 * description:
 */
public class ExerciseSolution {
    /*
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) list.add((double) num);
        return backtrack(list, 1e-6);
    }

    public boolean backtrack(List<Double> nums, double epsilon) {
        if (nums.cnt() == 1) return Math.abs(nums.get(0) - 24) < epsilon;
        int n = nums.cnt();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                List<Double> copy = new ArrayList<>(nums);
                double b = copy.remove(j), a = copy.remove(i);
                boolean valid = false;
                copy.add(a + b);
                valid |= backtrack(copy, epsilon);
                copy.set(copy.cnt() - 1, a - b);
                valid |= backtrack(copy, epsilon);
                copy.set(copy.cnt() - 1, a * b);
                valid |= backtrack(copy, epsilon);
                // 避免0出现在被除数上
                if (b > epsilon) {
                    copy.set(copy.cnt() - 1, a / b);
                    valid |= backtrack(copy, epsilon);
                }
                copy.set(copy.cnt() - 1, b - a);
                valid |= backtrack(copy, epsilon);
                if (a > epsilon) {
                    copy.set(copy.cnt() - 1, b / a);
                    valid |= backtrack(copy, epsilon);
                }
                if (valid) return true;
            }
        }
        return false;
    }
    */


    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) list.add((double) num);
        return backtrack(list);
    }

    public boolean backtrack(List<Double> list) {
        if (list.size() == 1) return Math.abs(list.get(0) - 24) < 1e-6;
        int n = list.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                List<Double> copy = new ArrayList<>(list);
                double b = copy.remove(j), a = copy.remove(i);
                boolean valid = false;
                copy.add(a + b);
                valid |= backtrack(copy);
                copy.set(copy.size() - 1, a - b);
                valid |= backtrack(copy);
                copy.set(copy.size() - 1, a * b);
                valid |= backtrack(copy);
                // 避免除零异常
                if (b > 1e-6) {
                    copy.set(copy.size() - 1, a / b);
                    valid |= backtrack(copy);
                }
                copy.set(copy.size() - 1, b - a);
                valid |= backtrack(copy);
                if (a > 1e-6) {
                    copy.set(copy.size() - 1, b / a);
                    valid |= backtrack(copy);
                }
                if (valid) return true;
            }
        }
        return false;
    }
}
