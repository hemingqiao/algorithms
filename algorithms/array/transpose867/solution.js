/*! *****************************************************************************
@author Heming
founded at 2020-12-15 12:54:18
created by IntelliJ IDEA
description: LeetCode 867: 转置矩阵
from：https://leetcode-cn.com/problems/transpose-matrix/
***************************************************************************** */


/**
 * @param {number[][]} A
 * @return {number[][]}
 */
var transpose = function(A) {
  return A[0].map((_, index) => A.map(value => value[index]));
};

/*
[
  [1, 2, 3],
  [4, 5, 6],
]
具体思路就是将每一列转为新数组的每一行：
[
  [1, 4],
  [2, 5],
  [3, 6],
]
 */
