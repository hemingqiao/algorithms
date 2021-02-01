package blogandquestion.algorithms.array.faircandyswap888;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/01 11:17:07
 * description:
 */
public class AnotherSolution {
    public int[] fairCandySwap(int[] A, int[] B) {
        Set<Integer> set = new HashSet<>();
        int sumA = 0, sumB = 0;
        for (int num : A) {
            sumA += num;
            set.add(num);
        }
        for (int num : B) sumB += num;
        int delta = (sumA - sumB) / 2;
        int[] ans = new int[2];
        for (int num : B) {
            int b = delta + num;
            if (set.contains(b)) {
                ans[0] = b;
                ans[1] = num;
                break;
            }
        }
        return ans;
    }
}
