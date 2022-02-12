package src.array.findcontinuoussequencelcof;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/28 15:02:38
 * description:
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 *
 */
public class Solution {
    /*
    public int[][] findContinuousSequence(int target) {
        int mid = target >>> 1;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= mid; i++) {
            int sum = i, cur = i;
            while (sum < target) {
                cur++;
                sum += cur;
            }
            if (sum == target) {
                List<Integer> temp = new ArrayList<>();
                for (int j = i; j <= cur; j++) temp.add(j);
                list.add(temp);
            }
        }
        int n = list.cnt();
        int[][] ret = new int[n][];
        for (int i = 0; i < n; i++) {
            List<Integer> l = list.get(i);
            int cnt = l.cnt();
            int[] t = new int[cnt];
            for (int k = 0; k < cnt; k++) t[k] = l.get(k);
            ret[i] = t;
        }
        return ret;
    }
    */

    // 返回值竟然是数组，WTF
    public int[][] findContinuousSequence(int target) {
        int mid = target >>> 1;
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i <= mid; i++) {
            int sum = i, cur = i;
            while (sum < target) {
                cur++;
                sum += cur;
            }
            if (sum == target) {
                int[] temp = new int[cur - i + 1];
                int p = 0;
                for (int j = i; j <= cur; j++) temp[p++] = j;
                list.add(temp);
            }
        }
        /*int n = list.cnt();
        int[][] ret = new int[n][];
        for (int i = 0; i < n; i++) {
            ret[i] = list.get(i);
        }
        return ret;*/
        return list.toArray(new int[0][]);
    }


    // 双指针解法
    // 参考：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/mian-shi-ti-57-ii-he-wei-sde-lian-xu-zheng-shu-x-2/
    public int[][] findContinuousSequence1(int target) {
        List<int[]> list = new ArrayList<>();
        int l = 1, r = 2;
        while (l < r) {
            int sum = (r + l) * (r - l + 1) / 2;
            if (sum == target) {
                int[] temp = new int[r - l + 1];
                int p = 0;
                for (int i = l; i <= r; i++) temp[p++] = i;
                list.add(temp);
            } else if (sum > target) {
                l++;
            } else {
                r++;
            }
        }
        return list.toArray(new int[0][]);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] ret = s.findContinuousSequence(9);
        System.out.println(Arrays.deepToString(ret));
    }
}
