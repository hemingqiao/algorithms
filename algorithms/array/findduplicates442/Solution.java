package blogandquestion.algorithms.array.findduplicates442;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/26 13:51:39
 * description:
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *
 * 示例：
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [2,3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-duplicates-in-an-array
 *
 */
public class Solution {
    // 使用set超时
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (!set.contains(num) && !res.contains(num)) {
                res.add(num);
            }
        }
        return res;
    }

    // 改进哈希表还是超时
    public List<Integer> findDuplicates1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int times = map.get(num);
                if (times == 1 && !res.contains(num)) {
                    res.add(num);
                }
            } else {
                map.put(num, 1);
            }
        }
        return res;
    }
}

class AnotherSolution {
    // 每遍历一次数组，就将此数的index对应的原来正的数字取负，若此index对应的数为负，则说明已出现过
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                result.add(Math.abs(nums[i]));
                continue;
            }

            nums[index] = -nums[index];
        }

        return result;
    }
}

/**
 * 这个解法最优
 */
class ThirdSolution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        int[] times = new int[len + 1];
        for (int num : nums) {
            times[num]++;
        }
        for (int j = 1; j < len + 1; j++) {
            if (times[j] == 2) {
                res.add(j);
            }
        }
        return res;
    }
}
