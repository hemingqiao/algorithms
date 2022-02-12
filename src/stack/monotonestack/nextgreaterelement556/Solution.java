package src.stack.monotonestack.nextgreaterelement556;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/06 09:21:46
 * description:
 * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
 *
 * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：21
 * 示例 2：
 *
 * 输入：n = 21
 * 输出：-1
 *  
 *
 * 提示：
 *
 * 1 <= n <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-iii
 *
 * @see src.array.nextpermutation31
 * 参考：https://github.com/grandyang/leetcode/issues/556
 */
public class Solution {
    public int nextGreaterElement(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int len = chars.length;
        int i = len - 2;
        for (; i >= 0; i--) {
            // 从后向前找到第一个小于其右边数字的数字
            if (chars[i] < chars[i + 1]) break;
        }
        // i == -1 意味着已经搜索完所有的元素都没有找到大于其右边数字的位置
        if (i == -1) return -1;
        for (int j = len - 1; j >= i; j--) {
            if (chars[j] > chars[i]) {
                // swap i j
                char temp = chars[j];
                chars[j] = chars[i];
                chars[i] = temp;
                break;
            }
        }
        // 对i + 1位置后的字符进行升序排序
        Arrays.sort(chars, i + 1, len);
        long res = Long.parseLong(String.valueOf(chars));
        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }

    /*
    比如12443322，这个数字的重排序结果应该为13222344，如果仔细观察的话会发现数字变大的原因是左数第二位的2变成了3，更进一步可以发现后面的数字由
    降序变为了升序，这也不难理解，因为要求刚好比给定数字大的排序方式。那么再观察下原数字，看看2是怎么确定的，可以发现，如果从后往前看的话，2是第一
    个小于其右边位数的数字，因为如果是个纯降序排列的数字，做任何改变都不会使数字变大，直接返回-1。知道了找出转折点的方法，再来看如何确定2和谁交换，
    这里2并没有跟4换位，而是跟3换了，那么如何确定的3？其实也是从后往前遍历，找到第一个大于2的数字交换，然后把转折点之后的数字按升序排列就是最终的
    结果了。最后记得为防止越界要转为长整数型，然后根据结果判断是否要返回-1即可
     */

    public static void main(String[] args) {
        Solution s = new Solution();
        int test = 12;
        int res = s.nextGreaterElement(test);
        System.out.println(res);
    }
}
