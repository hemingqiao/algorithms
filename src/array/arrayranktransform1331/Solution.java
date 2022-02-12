package src.array.arrayranktransform1331;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/06 11:36:42
 * description:
 * 给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
 *
 * 序号代表了一个元素有多大。序号编号的规则如下：
 *
 * 序号从 1 开始编号。
 * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
 * 每个数字的序号都应该尽可能地小。
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [40,10,20,30]
 * 输出：[4,1,2,3]
 * 解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
 * 示例 2：
 *
 * 输入：arr = [100,100,100]
 * 输出：[1,1,1]
 * 解释：所有元素有相同的序号。
 * 示例 3：
 *
 * 输入：arr = [37,12,28,9,100,56,80,5,12]
 * 输出：[5,3,4,2,8,6,7,1,3]
 *  
 *
 * 提示：
 *
 * 0 <= arr.length <= 105
 * -109 <= arr[i] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rank-transform-of-an-array
 *
 */
public class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] clone = arr.clone();
        Arrays.sort(arr);

        Map<Integer, Integer> map = new HashMap<>();
        // 用k来计数，因为题目要求每个数字的序号应该尽可能的小
        int k = 1;
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], k++);
            }
        }
        int[] res = new int[arr.length];
        for (int j = 0; j < arr.length; j++) {
            res[j] = map.get(clone[j]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {37,12, 28, 9, 100, 56, 80,  5, 12};
        Solution s = new Solution();
        int[] res = s.arrayRankTransform(test);
        System.out.println(Arrays.toString(res));
    }
}
