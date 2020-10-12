package blogandquestion.algorithms.doublepointer.minwindow76;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/11 21:14:35
 * description: 双指针滑动窗口。
 */
public class AnotherSolution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int validNum = 0; // validNum表示窗口中满足need字符的个数
        int start = 0, length = Integer.MAX_VALUE; // 记录最小覆盖子串的起始索引和长度
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 更新窗口内的数据
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);

                if (window.get(c).equals(need.get(c))) { // 注意这里比较的时候使用的是equals方法而不是==，==比较的是地址
                    // 如果窗口中c字符的个数等于need中c字符的个数，窗口中满足need字符的个数加1
                    validNum++;
                }
            }

            // 判断左侧窗口是否需要收缩，根据窗口中满足need字符的个数和need所需的字符个数是否相等来判断
            while (validNum == need.size()) {
                //System.out.println("111");
                // 更新最小覆盖字串
                if (right - left < length) {
                    start = left;
                    length = right - left;
                }

                // d是要移出窗口的字符
                char d = s.charAt(left);
                // 窗口左指针右移
                left++;
                // 更新窗口内的数据
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        validNum--;
                    }
                    // 将window内字符d出现次数减1
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }
}
