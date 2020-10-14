package blogandquestion.algorithms.doublepointer.minwindow76;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/12 08:36:17
 * description: 改这个把我改死了，结果最后发现错在了substring上，endIndex应该是start + length我一开始写成了left + length，
 * 气死了气死了
 */
public class SolutionMinWindow {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        int[] need = new int[128];
        int[] window = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int right = 0;
        int length = Integer.MAX_VALUE;
        int start = 0; // 用来标记截取字符串的起始位置
        int total = t.length(); // 用total检测窗口中是否覆盖了t中所有的字符
        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;
            // 如果need中需要这个字符
            if (need[ch] > 0) {
                window[ch]++;
                // 窗口中的这个字符数量如果小于need中字符的数量，说明窗口中还需要这个字符，同时需要的总字符数减1
                if (window[ch] <= need[ch]) {
                    total--;
                }
            }

            // 如果需要的总字符数等于零，窗口中的字符数已经满足要求，开始缩减窗口找到包含所有字符的最短子串
            while (total == 0) {
                if (right - left < length) {
                    length = right - left;
                    start = left;
                }

                char l = s.charAt(left);
                if (need[l] > 0) { // 如果need中含有这个即将被移出窗口的字符，说明这个字符是需要的
                    window[l]--;
                    if (window[l] < need[l]) { // 窗口中的这个字符数量小于need中这个字符数量，需要的总字符数加1
                        total++;
                    }
                }
                left++;
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }

    public static void main(String[] args) {
        SolutionMinWindow smw = new SolutionMinWindow();
        String s ="ADOBECODEBANC", t = "ABC";
        String s1 = "DOABCEODEBANC", t1 = "ABC";
        String result = smw.minWindow(s, t);
        String result2 = smw.minWindow(s1, t1);
        System.out.println(result);
        System.out.println(result2);
    }
}
