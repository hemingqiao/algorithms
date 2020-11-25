package blogandquestion.algorithms.array.singlenumber260;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/25 16:37:19
 * description:
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * 示例 :
 *
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 *
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-iii
 *
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int[] res = new int[2];
        int i = 0;
        for (int num : nums) {
            if (map.get(num) == 1) {
                res[i++] = num;
            }
        }
        return res;
    }

    public int[] singleNumber1(int[] nums) {
        // 使用set代替map
        // 比使用map快了3ms
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        int[] res = new int[2];
        int i = 0;
        for (int n : set) {
            res[i++] = n;
        }
        return res;
    }

    /*
    这题有位运算的解法，没看太懂，以后在刷的时候看吧
     */
}
