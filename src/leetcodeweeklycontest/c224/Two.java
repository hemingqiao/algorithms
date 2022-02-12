package src.leetcodeweeklycontest.c224;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/17 10:28:00
 * description:
 *
 */
public class Two {
    public int cnt = 0;
    public int tupleSameProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        backtrack(nums, 0, n - 1);
//        int cnt = 0;
//        int left = 0, right = n - 1;
//        while (left < right) {
//            int temp = nums[left] * nums[right];
//            int l = left + 1, r = right - 1;
//            while (l < r) {
//                int p = nums[l] * nums[r];
//                if (p > temp) {
//                    r--;
//                } else if (p < temp) {
//                    l++;
//                } else {
//                    cnt++;
//                    l++;
//                    r--;
//                }
//            }
//            if (left + 1 < right && nums[left + 1] * nums[right] > temp) {
//                left++;
//            } else {
//                right--;
//            }
//        }
        return cnt * 8;
    }

    public void backtrack(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int temp = nums[start] * nums[end];
        int l = start + 1, r = end - 1;
        while (l < r) {
            int p = nums[l] * nums[r];
            if (p > temp) {
                r--;
            } else if (p < temp) {
                l++;
            } else {
                cnt++;
                l++;
                r--;
            }
        }
        backtrack(nums, start + 1, end);
        backtrack(nums, start, end - 1);
    }

    public static void main(String[] args) {
        Two t = new Two();
        int[] test = new int[]{2, 3, 4, 6, 8, 12};
        int res = t.tupleSameProduct(test);
        System.out.println(res);
    }
}
