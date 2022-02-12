/*! *****************************************************************************
@author Heming
founded at 2020-11-21 15:00:56
created by IntelliJ IDEA
description: LeetCode 75：颜色分类
from：https://leetcode-cn.com/problems/sort-colors/
***************************************************************************** */

/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function (nums) {
  let counts = Array(3).fill(0);
  for (let i = 0; i < nums.length; i++) {
    counts[nums[i]]++;
  }
  let idx = 0;
  for (let j = 0; j < 3; j++) {
    for (let k = 0; k < counts[j]; k++) {
      nums[idx++] = j;
    }
  }
};

let colors = [2, 0, 2, 1, 1, 0];
sortColors(colors);
console.log(colors);
