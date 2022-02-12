package src.string.lengthOfLongestSubstring3;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/26 21:06:41
 * description:
 * 三刷
 */
public class ExerciseSolution1 {
    public int lengthOfLongestSubstring(String s) {
        // 有必要的话，可以对s进行非空判断
        char[] chars = s.toCharArray();
        int n = chars.length;
        // 使用数组作为哈希表，如果字符过多，可以换用HashMap
        int[] cnt = new int[256];
        int res = 0;
        int left = 0, right = 0;
        while (right < n) {
            char t = chars[right++];
            cnt[t]++;
            // 对cnt中t的出现次数进行自增后，需要判断字符t的出现次数是否大于1
            // 如果此时字符t的出现次数大于1了，表明在前面t已经出现过了，此时需要收缩窗口左边界，直到t的出现次数不在大于1
            while (cnt[t] > 1) {
                --cnt[chars[left++]];
            }
            // right每向右移动一位（即窗口每向右滑动一次），就更新一次结果
            // 需要注意的是，在上面right已经执行过自增了，所以在这里区间长度计算方法为right - left，不需要再加上1了
            res = Math.max(res, right - left);
        }
        return res;
    }
}
