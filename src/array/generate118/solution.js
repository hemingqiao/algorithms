/*! *****************************************************************************
@author Heming
founded at 2020-11-23 19:59:00
created by IntelliJ IDEA
description: 118 杨辉三角
from：https://leetcode-cn.com/problems/pascals-triangle/
***************************************************************************** */


/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function(numRows) {
  let res = Array(numRows).fill(0).map(value => []);
  res[0] = [1];
  for (let i = 1; i < numRows; i++) {
    for (let j = 0; j <= i; j++) {
      if (j === 0 || j === i) {
        res[i].push(1);
      } else {
        res[i].push(res[i - 1][j - 1] + res[i - 1][j]);
      }
    }
  }
  return res;
};

console.log(generate(5));
