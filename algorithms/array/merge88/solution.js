/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
const merge = function(nums1, m, nums2, n) {
    let i = m - 1, j = n - 1;
    let idx = m + n - 1;
    while (i >= 0 && j >= 0) {
        nums1[idx--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
    }
    while (j >= 0) nums1[idx--] = nums2[j--];
};
