package blogandquestion.algorithms.nowcoder.newease1;

import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/04 20:29:51
 * description:
 * 网易校招试题
 * 参见：https://www.nowcoder.com/test/27977350/summary
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] chars = br.readLine().toCharArray();
        int n = chars.length;
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1];
            if (chars[i] == '1') {
                if (i + 2 <= n) dp[i] += dp[i + 2];
                if (i + 3 <= n) dp[i] += dp[i + 3];
            }
        }
        System.out.println(dp[0]);
    }
}


/**
 * 参考：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/mian-shi-ti-46-ba-shu-zi-fan-yi-cheng-zi-fu-chua-6/
 */
class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int n = chars.length;
        int[] dp = new int[n + 1];
        dp[0] = 1; // 无字符时翻译方案为1
        dp[1] = 1; // 存在1个字符时翻译方案为1
        for (int i = 1; i < n; i++) {
            dp[i + 1] = dp[i];
            if (chars[i - 1] == '1') {
                dp[i + 1] += dp[i - 1];
            }
            if (i > 1 && chars[i - 2] == '1') {
                dp[i + 1] += dp[i - 2];
            }
        }
        System.out.println(dp[n]);
    }
}


class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] chars = br.readLine().split(" ");
        int n = chars.length;
        int left = 0, right = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if ("0".equals(chars[i])) {
                left = i;
                right = i;
                while (right < n && "0".equals(chars[right])) {
                    right++;
                    i++;
                }
                if (right == n || left == 0) {
                    max = Math.max(max, right - left);
                } else {
                    if ((right - left) % 2 == 0) {
                        max = Math.max(max, (right - left) / 2);
                    } else {
                        max = Math.max(max, (right - left) / 2 + 1);
                    }
                }
            }
        }
        System.out.println(max);
    }

    // 0 0 1 0 0 1 0 1 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 1 0
}

class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        char[] source = t.toCharArray();
        int n = source.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (j < s.length() && source[i] == s.charAt(j)) {
                j++;
            }
            if (j == s.length()) {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }
}


/**
 * 和力扣中一题很相似：https://leetcode-cn.com/problems/longest-harmonious-subsequence
 */
class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] source = br.readLine().split(" ");
        int n = source.length;
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            int key = Integer.valueOf(source[i]);
//            if (map.containsKey(key)) {
//                map.put(key, map.get(key) + 1);
//            } else {
//                map.put(key, 1);
//            }
//        }
//        int res = 0;
//        for (int key : map.keySet()) {
//            if (map.containsKey(key + 1)) {
//                res = Math.max(res, map.get(key) + map.get(key + 1));
//            }
//        }
//        System.out.println(res);
        int[] nums = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(source[i]);
        for (int i = 0; i < n; i++) {
            int min = nums[i];
            int max = nums[i];
            int right = i;
            while (right < n && Math.abs(nums[right] - min) <= 1 && Math.abs(nums[right] - max) <= 1) {
                max = Math.max(max, nums[right]);
                min = Math.min(min, nums[right]);
                right++;
            }
            if (max - min == 1) {
                res = Math.max(res, right - i);
//                i = right - 1;
            }
        }
        System.out.println(res);
    }
}
