package src.hashtable.intersection349;

import java.util.*;

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


    public int[] intersection1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, n1 = nums1.length, n2 = nums2.length;
        List<Integer> list = new ArrayList<>();
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                if (list.isEmpty() || list.get(list.size() - 1) != nums1[i]) {
                    list.add(nums1[i]);
                }
                i++;
                j++;
            }
        }
        int[] ret = new int[list.size()];
        int p = 0;
        for (int num : list) ret[p++] = num;
        return ret;
    }
}
