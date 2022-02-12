package src.array.largestnumber179;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/24 20:16:22
 * description:
 * 给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 *
 * 输入：nums = [10]
 * 输出："10"
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 *
 * 参考：https://github.com/grandyang/leetcode/issues/179
 */
public class Solution {
    /*
    // WA
    public String largestNumber(int[] nums) {
        int n = nums.length;
        Integer[] integers = new Integer[n];
        for (int i = 0; i < n; i++) integers[i] = nums[i];
        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Solution.this.compare(o1, o2);
            }
        });
        StringBuilder ret = new StringBuilder();
        for (int j = n - 1; j >= 0; j--) ret.append(integers[j]);
        return ret.toString();
    }

    public int compare(int a, int b) {
        String A = String.valueOf(a), B = String.valueOf(b);
        if (A.length() == B.length()) {
            return a - b;
        }
        if (a != 0 && b != 0) {
            return a % 10 - b % 10;
        }
        return a + b;
    }
    */

    public String largestNumber(int[] nums) {
        int n = nums.length;
        Integer[] integers = new Integer[n];
        for (int i = 0; i < n; i++) integers[i] = nums[i];
        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                StringBuilder s1 = new StringBuilder(), s2 = new StringBuilder();
                return -1 * s1.append(o1).append(o2).toString().compareTo(s2.append(o2).append(o1).toString());
            }
        });
        StringBuilder ret = new StringBuilder();
        for (int i : integers) ret.append(i);
        return ret.charAt(0) == '0' ? "0" : ret.toString();
    }

    // 下面解法的时间效率稍微好些
    public String largestNumber1(int[] nums) {
        int n = nums.length;
        Integer[] integers = new Integer[n];
        for (int i = 0; i < n; i++) integers[i] = nums[i];
        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                StringBuilder s1 = new StringBuilder(), s2 = new StringBuilder();
                return s1.append(o1).append(o2).toString().compareTo(s2.append(o2).append(o1).toString());
            }
        });
        StringBuilder ret = new StringBuilder();
        for (int j = n - 1; j >= 0; j--) ret.append(integers[j]);
        return ret.charAt(0) == '0' ? "0" : ret.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] test = new int[]{3, 30, 34, 5, 9};
        int[] test = new int[]{10,2};
        String res = s.largestNumber(test);
        System.out.println(res);
    }
}
