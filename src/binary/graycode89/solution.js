/*! *****************************************************************************
@author Heming
founded at 2020-11-25 11:52:02
created by IntelliJ IDEA
description: LeetCode 89 格雷编码
from：https://leetcode-cn.com/problems/gray-code/
***************************************************************************** */

/**
 * @param {number} n
 * @return {number[]}
 */
var grayCode = function(n) {
  let res = [0];
  for (let i = 0; i < n; i++) {
    let size = res.length;
    for (let j = size - 1; j >= 0; j--) {
      // let a = res[j];
      // let b = 1 << i;
      // let c = a | b;
      // res.push(c);
      res.push(res[j] | (1 << i))
    }
  }
  return res;
};

let res = grayCode(2);
console.log(res);

// https://mp.weixin.qq.com/s/Kh6pN-a_94v-CtUo4DlrXQ
