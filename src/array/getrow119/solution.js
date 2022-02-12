/*! *****************************************************************************
@author Heming
founded at 2020-11-23 20:16:23
created by IntelliJ IDEA
description: 119 杨辉三角II
from：https://leetcode-cn.com/problems/pascals-triangle-ii/
***************************************************************************** */

/**
 * @param {number} rowIndex
 * @return {number[]}
 */
var getRow = function(rowIndex) {
  // 类似于动态规划降维
  // 先将数组用0填充，然后每一层从右向左算
  if (rowIndex < 0) return [];
  let dp = Array(rowIndex + 1).fill(0);
  dp[0] = 1;
  for (let i = 1; i <= rowIndex; i++) {
    for (let j = i; j >= 1; j--) {
      dp[j] = dp[j] + dp[j - 1];
    }
  }
  return dp;
};

console.log(getRow(3));
