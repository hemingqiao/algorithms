package blogandquestion.algorithms.stack.monotonestack.nextgreaterelement496;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/24 11:17:49
 * description:
 */
public class Solution {
    // 运行时间倒是和下面的方法相差不大
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        // 将map的键值初始化为-1，如果在nums2中没有找到符合要求的元素，-1就是最终的值
        for (int i : nums1) {
            map.put(i, -1);
        }
        for (int j = 0; j < nums2.length; j++) {
            if (map.containsKey(nums2[j])) {
                for (int k = j + 1; k < nums2.length; k++) {
                    if (nums2[k] > nums2[j]) {
                        map.put(nums2[j], nums2[k]);
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}

class BruteSolution {
    // 暴力遍历
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int val = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] != val) {
                    continue;
                }
                while (j + 1 < nums2.length) {
                    if (nums2[j + 1] > val) {
                        res[i] = nums2[j + 1];
                        break;
                    }
                    j++;
                }
            }
            // 如果遍历nums2数组没有找到符合要求的值，将res[i]置为-1
            if (res[i] == 0) {
                res[i] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BruteSolution bs = new BruteSolution();
        int[] nums1 = {1,3,5,2,4};
        int[] nums2 = {6,5,4,3,2,1,7};
        int[] res = bs.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
}
