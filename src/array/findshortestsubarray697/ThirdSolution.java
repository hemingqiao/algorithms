package src.array.findshortestsubarray697;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/18 20:30:51
 * description:
 * 参考：https://leetcode-cn.com/problems/degree-of-an-array/solution/qian-lu-qi-qu-wang-wo-men-ke-yi-hu-xiang-8nrv/
 */
public class ThirdSolution {
    public int findShortestSubArray(int[] nums) {
        // 计数排序
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int[] count = new int[max - min + 1];
        int degree = 0;
        for (int num : nums) {
            degree = Math.max(degree, ++count[num - min]);
        }
        if (degree == 1) return 1;
        int res = Integer.MAX_VALUE;
        int n = count.length;
        for (int i = 0; i < n; i++) {
            if (count[i] != degree) continue;
            int temp = i + min;
            int left = 0, right = nums.length - 1;
            while (left < right && nums[left] != temp) left++;
            while (left < right && nums[right] != temp) right--;
            res = Math.min(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        ThirdSolution ts = new ThirdSolution();
        int[] test = new int[]{1, 2, 2, 3, 1};
        int res = ts.findShortestSubArray(test);
        System.out.println(res);
    }
}
