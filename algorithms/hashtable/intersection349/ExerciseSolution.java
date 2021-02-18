package blogandquestion.algorithms.hashtable.intersection349;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/18 18:52:38
 * description:
 */
public class ExerciseSolution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) set.add(num);
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }
        int[] ret = new int[list.size()];
        int p = 0;
        for (int num : list) ret[p++] = num;
        return ret;
    }
}
