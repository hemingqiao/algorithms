package blogandquestion.algorithms.numbers.rotatearray.findmin153;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/10 20:14:27
 * description: 一个通用的解决这四道旋转升序数组的思路
 */
public class GeneralSolution {
    /*
    // 这个解法对于搜索长度为1或者数组长度为1时的情况，放在了while外面进行处理（left < right），也可以放在循环里面进行处理
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // 此时[left, mid]区间是有序的
            if (nums[mid] > nums[right]) {
                // 则最小值位于右边，将搜索左边界收缩
                left = mid + 1;
            } else {
                // 此时nums[mid] < nums[right]，题目设定不存在重复的值，所以排除nums[left] == nums[mid]
                // 表明[mid, right]区间是有序的，最小值落在mid及mid的左边
                right = mid;
            }
        }
        return nums[left];
    }
    */

    // 这个解法对于搜索长度为1或者数组长度为1时的情况，放在了while里面进行处理（left <= right），也可以放在循环里面进行处理
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 如果判断条件放在循环内，应该在一进入循环就判断left到right是否是递增的
            // 而不能将判断条件放在mid下面，写为nums[left] <= nums[mid]，当输入为[3,4,5,1,2]就会报错
            if (nums[left] <= nums[right]) return nums[left];
            int mid = (left + right) / 2;

            // 此时[left, mid]区间是有序的
            if (nums[mid] > nums[right]) {
                // 则最小值位于右边，将搜索左边界收缩
                left = mid + 1;
            } else {
                // 此时nums[mid] < nums[right]，题目设定不存在重复的值，所以排除nums[left] == nums[mid]
                // 表明[mid, right]区间是有序的，最小值落在mid及mid的左边
                right = mid;
            }
        }
        return -1;
    }
}
