package blogandquestion.algorithms.array.containsduplicate217;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/01 21:43:25
 * description:
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        return set.size() != nums.length;
    }
}
