package src.array.finddisappearednumbers448;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/26 14:15:05
 * description:
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 *
 * 和442题很类似，因为题目限定了元素值的大小范围，可以使用一个数组来记录对应值的出现次数，出现次数为0
 * 的索引就是所求。（注意要排除掉索引0，因为所有元素都是大于等于1的）
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        int[] times = new int[len + 1];
        for (int num : nums) {
            times[num]++;
        }
        for (int i = 1; i < len + 1; i++) {
            if (times[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
