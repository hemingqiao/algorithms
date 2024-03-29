package src.binarysearch.findmediansortedarrays4;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/28 14:37:55
 * description:
 * 参考：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/jiang-qi-zhuan-wei-zhao-liang-ge-you-xu-shu-zu-de-/
 * 参考：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-s-114/
 * 参考：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/te-bie-de-er-fen-by-bigsai/
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        if ((totalLen & 1) == 1) {
            // 总长度是奇数
            return findKth(nums1, nums2, (totalLen >> 1) + 1);
        } else {
            // 偶数
            return (findKth(nums1, nums2, totalLen >> 1) + findKth(nums1, nums2, (totalLen >> 1) + 1)) / 2.0;
        }
    }

    public int findKth(int[] nums1, int[] nums2, int k) {
        int left = Math.max(0, (k - nums2.length)), right = Math.min(k, nums1.length);
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums2[k - mid - 1] > nums1[mid]) {
                // mid + j = k，k - mid - 1取到了nums2中j的前一个位置
                // 如果nums2[j - 1]即nums2[k - mid - 1]大于nums1[i]即nums1[mid]的话，nums1[mid]前最多有k - 2个数
                // 可以舍弃nums1[mid]前的所有元素。
                // 具体参考：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-s-114/
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        //循环结束时的位置le即为所求位置，第k小即为max(nums1[left-1]),nums2[k-left-1])，但是由于le可以为0、k,所以
        //le-1或者k-le-1可能不存在所以下面单独判断下
        int nums1LeftMax = left == 0 ? Integer.MIN_VALUE : nums1[left - 1];
        int nums2LeftMax = left == k ? Integer.MIN_VALUE : nums2[k - left - 1];
        return Math.max(nums1LeftMax, nums2LeftMax);
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/zong-he-bai-jia-ti-jie-zong-jie-zui-qing-xi-yi-don/
 */
class AnotherSolution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    // i: nums1的起始位置 j: nums2的起始位置
    public int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) return nums2[j + k - 1]; // nums1为空数组
        if (j >= nums2.length) return nums1[i + k - 1]; // nums2为空数组
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }
}

/*

这道题让求两个有序数组的中位数，而且限制了时间复杂度为O(log (m+n))，看到这个时间复杂度，自然而然的想到了应该使用二分查找法来求解。
那么回顾一下中位数的定义，如果某个有序数组长度是奇数，那么其中位数就是最中间那个，如果是偶数，那么就是最中间两个数字的平均值。
这里对于两个有序数组也是一样的，假设两个有序数组的长度分别为m和n，由于两个数组长度之和 m+n 的奇偶不确定，因此需要分情况来讨论，
对于奇数的情况，直接找到最中间的数即可，偶数的话需要求最中间两个数的平均值。为了简化代码，不分情况讨论，可以使用一个小trick，
分别找第 (m+n+1) / 2 个，和 (m+n+2) / 2 个，然后求其平均值即可，这对奇偶数均适用。加入 m+n 为奇数的话，那么其实 (m+n+1) / 2
和 (m+n+2) / 2 的值相等，相当于两个相同的数字相加再除以2，还是其本身。

这里需要定义一个函数来在两个有序数组中找到第K个元素，下面重点来看如何实现找到第K个元素。首先，为了避免产生新的数组从而增加时间复杂度，
使用两个变量i和j分别来标记数组nums1和nums2的起始位置。然后来处理一些边界问题，比如当某一个数组的起始位置大于等于其数组长度时，
说明其所有数字均已经被淘汰了，相当于一个空数组了，那么实际上就变成了在另一个数组中找数字，直接就可以找出来了。还有就是如果K=1的话，
那么只需要比较nums1和nums2的起始位置i和j上的数字就可以了。难点就在于一般的情况怎么处理？因为需要在两个有序数组中找到第K个元素，
为了加快搜索的速度，需要要使用二分法，对K二分，意思是需要分别在nums1和nums2中查找第K/2个元素，注意这里由于两个数组的长度不定，
所以有可能某个数组没有第K/2个数字，所以需要先检查一下，数组中到底存不存在第K/2个数字，如果存在就取出来，否则就赋值上一个整型最大值。
如果某个数组没有第K/2个数字，那么我们就淘汰另一个数组的前K/2个数字即可。有没有可能两个数组都不存在第K/2个数字呢，这道题里是不可能的，
因为我们的K不是任意给的，而是给的m+n的中间值，所以必定至少会有一个数组是存在第K/2个数字的。最后就是二分法的核心所在了，
比较这两个数组的第K/2小的数字midVal1和midVal2的大小，如果第一个数组的第K/2个数字小的话，那么说明要找的数字肯定不在nums1中的前K/2个
数字，所以可以将其淘汰，将nums1的起始位置向后移动K/2个，并且此时的K也自减去K/2，调用递归。反之，则淘汰nums2中的前K/2个数字，
并将nums2的起始位置向后移动K/2个，并且此时的K也自减去K/2，调用递归即可。

 */

