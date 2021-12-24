/*! *****************************************************************************
@author Heming
founded at 2020-11-23 22:27:39
created by IntelliJ IDEA
description: LeetCode 12 整数转罗马数字
from：https://leetcode-cn.com/problems/integer-to-roman/
***************************************************************************** */

/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function(num) {
  let values = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1];
  let romans = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"];
  let res = "";
  for (let i = 0; i < romans.length; i++) {
    while (num >= values[i]) {
      num -= values[i];
      res += romans[i];
    }
  }
  return res;
};
