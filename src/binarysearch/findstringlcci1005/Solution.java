package src.binarysearch.findstringlcci1005;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/23 19:29:26
 * description:
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 *
 * 示例1:
 *
 *  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 *  输出：-1
 *  说明: 不存在返回-1。
 * 示例2:
 *
 *  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 *  输出：4
 * 提示:
 *
 * words的长度在[1, 1000000]之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sparse-array-search-lcci
 *
 * 参考：https://leetcode-cn.com/problems/sparse-array-search-lcci/solution/er-fen-pai-xu-zhao-chu-zhong-jian-fei-kong-zi-fu-c/
 * 参考：https://leetcode-cn.com/problems/sparse-array-search-lcci/solution/java-er-fen-cha-zhao-yong-shi-0mschao-guo-100-by-w/
 */
public class Solution {
    public int findString(String[] words, String s) {
        int left = 0, right = words.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            while (mid <= right && words[mid].equals("")) {
                mid++;
            }
            // 如果mid等于right + 1，表明右侧全部是空字符串，从mid - 1处向左查找
            if (mid == right + 1) {
                mid = ((left + right) >>> 1) - 1;
                while (mid >= left && words[mid].equals("")) {
                    mid--;
                }
                // 如果mid < left表明左边也全部都是空字符串，返回-1
                if (mid < left) {
                    return -1;
                }
            }
            String w = words[mid];
            if (w.compareTo(s) > 0) {
                // mid位于目标索引的右边
                right = mid - 1;
            } else if (w.compareTo(s) < 0) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
