/*! *****************************************************************************
@author Heming
founded at 2020-11-21 15:21:30
created by IntelliJ IDEA
description: LeetCode 215：数组中的第k个最大元素
from：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
***************************************************************************** */

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function(nums, k) {
  // 相当于调用了库函数，这个解法图一乐呵
  nums.sort((a, b) => a - b);
  return nums[nums.length - k];
};
