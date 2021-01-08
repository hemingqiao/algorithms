package blogandquestion.algorithms.array.frequencysort1636;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/08 09:56:40
 * description:
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。 
 *
 * 请你返回排序后的数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,2,2,3]
 * 输出：[3,1,1,2,2,2]
 * 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
 * 示例 2：
 *
 * 输入：nums = [2,3,1,3,2]
 * 输出：[1,3,3,2,2]
 * 解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
 * 示例 3：
 *
 * 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
 * 输出：[5,-1,4,4,-6,-6,1,1,1]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-increasing-frequency
 *
 */
public class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Pair> map = new HashMap<>();
        for (int num : nums) {
            Pair p = map.get(num);
            if (p != null) {
                p.frequency++;
                map.put(num, p);
            } else {
                map.put(num, new Pair(num, 1));
            }
        }
        List<Pair> list = new ArrayList<>();
        for (int n : map.keySet()) list.add(map.get(n));
        list.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.frequency > o2.frequency) {
                    return 1;
                } else if (o1.frequency < o2.frequency) {
                    return -1;
                } else {
                    return o2.value - o1.value;
                }
            }
        });
        int[] ret = new int[nums.length];
        int i = 0;
        for (Pair p : list) {
            while (p.frequency-- > 0) {
                ret[i++] = p.value;
            }
        }
        return ret;
    }

    static class Pair {
        public int value;
        public int frequency;

        public Pair(int value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 1, 2, 2, 2, 3};
        Solution s = new Solution();
        int[] ret = s.frequencySort(test);
        System.out.println(Arrays.toString(ret));
    }
}

class AnotherSolution {
    // 速度中等
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int f1 = map.get(o1); // o1的频率
                int f2 = map.get(o2); // o2的频率
                if (f1 > f2) {
                    return 1;
                } else if (f1 < f2) {
                    return -1;
                } else {
                    return o2 - o1;
                }
            }
        });
        int[] ret = new int[nums.length];
        int i = 0;
        for (int n : list) {
            int fre = map.get(n);
            while (fre-- > 0) ret[i++] = n;
        }
        return ret;
    }

    // 最慢
    public int[] frequencySort1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>(map.keySet());
        for (int num : nums) {
            list.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int f1 = map.get(o1); // o1的频率
                int f2 = map.get(o2); // o2的频率
                if (f1 > f2) {
                    return 1;
                } else if (f1 < f2) {
                    return -1;
                } else {
                    return o2 - o1;
                }
            }
        });
        int[] ret = new int[nums.length];
        int i = 0;
        for (int n : list) {
            ret[i++] = n;
        }
        return ret;
    }
}
