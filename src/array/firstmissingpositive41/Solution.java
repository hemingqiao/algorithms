package src.array.firstmissingpositive41;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/21 19:25:08
 * description:
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *  
 *
 * 提示：
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 *
 * 参考：https://leetcode-cn.com/problems/first-missing-positive/solution/javade-6chong-jie-fa-de-tu-wen-xiang-jie-wei-yun-s/
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if (len == 0) return 1;
        for (int i = 0; i < len; i++) {
            // 对于小于0的数和超过了数组长度的数，不进行处理
            // 如果数值已经摆在了正确的位置上（即nums[i]已经放在了索引为nums[i]处），也不进行处理
            while (nums[i] > 0 && nums[i] < len && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            }
        }
        // 最后执行一次遍历，查看对应位置上的元素是否正确，如果不正确直接返回
        for (int i = 1; i < len; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        // 如果上面遍历中对应位置上的元素都正确，表明从1到len - 1的元素值都存在，此时nums[0]可能为0也可能为len
        // 因为len在数组中找不到其对应的位置（越界），就需要判断索引0处是不是len，是就返回len + 1，否则返回len
        return nums[0] == len ? len + 1 : len;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = {1, 2, 0};
        int res = s.firstMissingPositive(test);
        System.out.println(res);
    }
}

/**
 * 暴力解法
 * 参考：https://leetcode-cn.com/problems/first-missing-positive/solution/javade-6chong-jie-fa-de-tu-wen-xiang-jie-wei-yun-s/
 */
class BruteSolution {
    // 题目要求找到没有出现的最小正整数，那么就可以从正整数1开始，搜索nums中是否存在这个正整数
    // nums中最多包含nums.length个从1开始的连续正整数，循环退出条件就是i > nums.length
    // 此时就可以直接返回这个i，也就是nums.length + 1
    public int firstMissingPositive(int[] nums) {
        for (int i = 1; i <= nums.length; i++) {
            boolean flag = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                // 在nums中没有找到i，返回i
                return i;
            }
        }
        return nums.length + 1;
    }
}

class BinarySearchSolution {
    // 对于在数组中查找某个值是否存在，可以先排序，再利用二分查找
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 1; i <= len; i++) {
            if (!binarySearch(nums, i)) {
                return i;
            }
        }
        return len + 1;
    }

    // 关于二分查找的细节，参见src/algorithms/binarysearch/binarySearch.md
    public boolean binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySearchSolution bss = new BinarySearchSolution();
        int[] test = {1, 2, 0};
        int res = bss.firstMissingPositive(test);
        System.out.println(res);
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/first-missing-positive/solution/javade-6chong-jie-fa-de-tu-wen-xiang-jie-wei-yun-s/
 */
class SetSolution {
    // 将数组中的元素放入集合，借助于集合判断某个数是否出现过
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
        }
        for (int i = 1; i <= len; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return len + 1;
    }
}
