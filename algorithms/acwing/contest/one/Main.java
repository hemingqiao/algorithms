package blogandquestion.algorithms.acwing.contest.one;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/29 22:38:56
 * description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt(), k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = in.nextInt();
//        int[] nums = {1, 2, 1, 1, 1};
//        int n = 5, k = 5;
        Arrays.sort(nums);
        int l = 0, r = (int) 2e9;
        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            if (check(nums, mid, k)) l = mid;
            else r = mid - 1;
        }
        System.out.println(l);
    }

    public static boolean check(int[] nums, int mid, int k) {
        int n = nums.length;
        // res定义为long型，因为int最大值略大于2e9，有可能爆int
        long res = 0;
        for (int i = n / 2; i < n; i++) {
            if (mid > nums[i]) res += mid - nums[i];
        }
        return res <= k;
    }
}

class AnotherSolution {
    public int countGoodSubstrings(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            if (check(s.substring(i, i + 3))) ++res;
        }
        return res;
    }

    public boolean check(String s) {
        if (s.length() != 3) return false;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) set.add(s.charAt(i));
        return set.size() == 3;
    }

    public static void main(String[] args) {
        AnotherSolution as = new AnotherSolution();
        String test = "aababcabc";
        int res = as.countGoodSubstrings(test);
        System.out.println(res);
    }
}
