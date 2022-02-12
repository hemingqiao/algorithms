package src.array.largegrouppositions830;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/05 09:04:05
 * description:
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 *
 * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 *
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 *
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 *
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abbxxxxzzy"
 * 输出：[[3,6]]
 * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * 示例 2：
 *
 * 输入：s = "abc"
 * 输出：[]
 * 解释："a","b" 和 "c" 均不是符合要求的较大分组。
 * 示例 3：
 *
 * 输入：s = "abcdddeeeeaabbbcd"
 * 输出：[[3,5],[6,9],[12,14]]
 * 解释：较大分组为 "ddd", "eeee" 和 "bbb"
 * 示例 4：
 *
 * 输入：s = "aba"
 * 输出：[]
 *  
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅含小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/positions-of-large-groups
 *
 * 参考：https://github.com/grandyang/leetcode/issues/830
 */
public class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        // 本题中字符串的最大长度不超过1000，所以转为char数组和直接从字符串上进行读取时间效率差不多
        // 甚至于直接从字符串上进行读取更快
        char[] chars = s.toCharArray();
        int n = chars.length;
        List<List<Integer>> ret = new ArrayList<>();
        int l = 0, r = 0;
        while (r < n) {
            while (r < n && chars[r] == chars[l]) r++;
            if (r - l >= 3) {
//                List<Integer> temp = new ArrayList<>();
//                temp.add(l);
//                temp.add(r - 1);
//                ret.add(temp);
                ret.add(Arrays.asList(l, r - 1));
            }
            l = r;
        }
        return ret;
    }
}

class AnotherSolution {
    public List<List<Integer>> largeGroupPositions(String s) {
        int n = s.length();
        List<List<Integer>> res = new ArrayList<>();
        int left = 0, right = 0;
        while (right < n) {
            while (right < n && s.charAt(right) == s.charAt(left)) right++;
            if (right - left >= 3) {
                res.add(Arrays.asList(left, right - 1));
            }
            left = right;
        }
        return res;
    }
}
