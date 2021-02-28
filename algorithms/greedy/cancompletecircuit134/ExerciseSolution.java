package blogandquestion.algorithms.greedy.cancompletecircuit134;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/28 08:56:26
 * description:
 * 二刷
 */
public class ExerciseSolution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, sum = 0, start = 0;
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        return total < 0 ? -1 : start;
    }
}
