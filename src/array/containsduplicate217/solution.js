/*! *****************************************************************************
@author Heming
founded at 2020-12-01 21:43:39
created by IntelliJ IDEA
description: LeetCode 217：存在重复元素
from：https://leetcode-cn.com/problems/contains-duplicate/
***************************************************************************** */

/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function(nums) {
  const set = new Set(nums);
  return set.size === nums.length;
};
